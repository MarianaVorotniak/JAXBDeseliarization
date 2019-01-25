package com.jaxb.services;

import com.jaxb.Errors;
import com.jaxb.POJOs.*;
import com.jaxb.exceptions.ParseException;
import com.jaxb.interfaces.LoggerMessage;
import org.slf4j.*;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.*;

public class MainService {

    private static Logger LOGGER = LoggerFactory.getLogger(MainService.class);
    private static ParseService service = new ParseService();
    private static DefaultResponse defaultResponse = new DefaultResponse();

    public void checkResponseType(LoggerMessage objectResponse) {
        if (objectResponse instanceof RespuestaDeclaracionType) {
            RespuestaDeclaracionType response = (RespuestaDeclaracionType) objectResponse;
            acceptedOrRejectedMessage(response);
        }
        else
            LOGGER.info(objectResponse.getMessage());
    }

    public void acceptedOrRejectedMessage(RespuestaDeclaracionType response) {
        if (isAccepted(response))
            LOGGER.info(response.getMessage());
        else
            printErrorMessages(response);
    }

    public void printErrorMessages(RespuestaDeclaracionType response) {
        LOGGER.info(response.getMessage());
        for (RespuestaOperacionesType lineResponse : response.getRespuestaLinea()) {
            BigInteger code = lineResponse.getCodigoErrorRegistro();
            String errorMessage = null;
            try {
                errorMessage = Errors.findMessageByCode(code);
            } catch (ParseException e) {
                LOGGER.warn("Unknown error code [{}]",  code);
            }

            LOGGER.info("The error is: code [{}], message [{}]", code, errorMessage);
        }
    }

    public boolean isAccepted(RespuestaDeclaracionType response) {
        String status = response.getEstadoEnvio().value();
        if (status.equals("Aceptacion Completa"))
            return true;
        return false;
    }

    public LoggerMessage getResponse(String filePath) {
        try {
            String fileContent = readFile(filePath);
            if (fileContent.contains("RespuestaDeclaracion"))
                return service.parseResponse(fileContent);
            else if (fileContent.contains("Fault"))
                return service.parseFaultResponse(fileContent);
        } catch (ParseException e) {
            LOGGER.info("File does not exist [{}]", filePath);
        }

        return defaultResponse;
    }

    public static String readFile(String path) throws ParseException {
        byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (NoSuchFileException e) {
            throw new ParseException("File does not exist :" +  path);
        } catch (IOException e) {
            throw new ParseException("IOException");
        }

        return new String(encoded);
    }

    public static String translate(String wordToTranslate) {
        String accepted = "Fully accepted";
        String rejected = "Rejected";
        if (wordToTranslate.equals("Aceptacion Completa"))
            return accepted;
        else if (wordToTranslate.equals("Rechazo Completo"))
            return rejected;
        else try {
                throw new ParseException();
            } catch (ParseException e) {
               LOGGER.info("Can't translate status, because it is not correct [{}]", wordToTranslate);
            }
        return new String();
    }
}
