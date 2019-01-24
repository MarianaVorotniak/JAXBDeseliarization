package com.jaxb.services;

import com.jaxb.Errors;
import com.jaxb.POJOs.*;
import com.jaxb.exceptions.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.*;

public class MainService {

    private static Logger LOGGER = LoggerFactory.getLogger(MainService.class);
    private static ParseService service = new ParseService();

    public void checkResponseType(Object objectResponse) throws ParseException {
        if (objectResponse instanceof RespuestaDeclaracionType) {
            RespuestaDeclaracionType response = (RespuestaDeclaracionType) objectResponse;
            acceptedOrRejectedMessage(response);
        }
        else if (objectResponse instanceof Fault){
            Fault faultResponse = (Fault) objectResponse;
            LOGGER.info("The fault code is [{}]", faultResponse.getFaultcode());
        } else if (objectResponse == null) {
            LOGGER.info("There is no response.");
        }
    }

    public void acceptedOrRejectedMessage(RespuestaDeclaracionType response) throws ParseException {
        if (isAccepted(response))
            printSendStatus(response);
        else
            printErrorMessages(response);
    }

    public void printErrorMessages(RespuestaDeclaracionType response) throws ParseException {
        printSendStatus(response);
        for (RespuestaOperacionesType lineResponse : response.getRespuestaLinea()) {
            BigInteger code = lineResponse.getCodigoErrorRegistro();
            String errorMessage = Errors.findMessageByCode(code);

            LOGGER.info("The error is [{}]", errorMessage);
        }
    }

    public void printSendStatus(RespuestaDeclaracionType response) throws ParseException {
        String status = translate(response.getEstadoEnvio().value());
        LOGGER.info("The status is [{}]", status);
    }

    public boolean isAccepted(RespuestaDeclaracionType response) {
        String status = response.getEstadoEnvio().value();
        if (status.equals("Aceptacion Completa"))
            return true;
        return false;
    }

    public Object getResponse(String filePath) throws ParseException, IOException, SAXException, ParserConfigurationException {
        String fileContent = readFile(filePath);
        if (fileContent.contains("RespuestaDeclaracion"))
            return service.parseResponse(fileContent);
        else if (fileContent.contains("Fault"))
            return service.parseFaultResponse(fileContent);
        else return new Object();
    }

    public static String readFile(String path) throws ParseException {
        byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (NoSuchFileException e) {
            throw new ParseException("File does not exist");
        } catch (IOException e) {
            throw new ParseException("IOException");
        }

        return new String(encoded);
    }

    public static String translate(String wordToTranslate) throws ParseException {
        String accepted = "Fully accepted";
        String rejected = "Rejected";
        if (wordToTranslate.equals("Aceptacion Completa"))
            return accepted;
        else if (wordToTranslate.equals("Rechazo Completo"))
            return rejected;
        else throw new ParseException("Word is not a correct status");

    }
}
