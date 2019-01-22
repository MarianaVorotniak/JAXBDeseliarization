package com.jaxb.services;

import com.jaxb.Errors;
import com.jaxb.POJOs.*;
import com.jaxb.exceptions.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class MainService {

    private static Logger LOGGER = LoggerFactory.getLogger(MainService.class);

    public void checkResponseType(Object objectResponse) throws ParseException {
        if (objectResponse instanceof RespuestaDeclaracion) {
            RespuestaDeclaracion response = (RespuestaDeclaracion) objectResponse;
            acceptedOrRejectedMessage(response);
        }
        else if (objectResponse instanceof Fault){
            Fault faultResponse = (Fault) objectResponse;
            LOGGER.info("The fault code is [{}]", faultResponse.getFaultcode());
        }
        else if (objectResponse instanceof RespuestaBajaDI) {
            RespuestaBajaDI cancelationResponse = (RespuestaBajaDI) objectResponse;
            LOGGER.info("The response is [{}]", cancelationResponse.getSendStatus());
        }
        else if (objectResponse instanceof RespuestaConsultaDI) {
            RespuestaConsultaDI consultationResponse = (RespuestaConsultaDI) objectResponse;
            LOGGER.info("The consultation result is [{}]", consultationResponse.getConsultationResult());
        }
        LOGGER.info("There is no response.");
    }

    public void acceptedOrRejectedMessage(RespuestaDeclaracion response) throws ParseException {
        String status = translate(response.getSendStatus());

        if (isAccepted(response))
            LOGGER.info("The status is [{}]", status);
        else {
            for (RespuestaLinea lineResponse : response.getLineResponse()) {
                int code = lineResponse.getRecordCode();
                String errorMessage = Errors.findMessageByCode(code);
                LOGGER.info("The status is [{}] and the error is [{}]", status, errorMessage);
            }
        }
    }

    public boolean isAccepted(RespuestaDeclaracion response) {
        String status = response.getSendStatus();
        if (status.equals("Aceptacion Completa"))
            return true;
        return false;
    }

    public Object getResponse(String filePath) throws ParseException, IOException, SAXException, ParserConfigurationException {
        ParseService service = new ParseService();
        String fileContent = readFile(filePath);
        if (fileContent.contains("RespuestaDeclaracion"))
            return service.parseResponse(fileContent);
        else if (fileContent.contains("Fault"))
            return service.parseFaultResponse(fileContent);
        else if (fileContent.contains("RespuestaConsultaDI"))
            return service.parseConsultationResponse(fileContent);
        else if (fileContent.contains("RespuestaBajaDI"))
            return service.parseCancelationResponse(fileContent);
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
