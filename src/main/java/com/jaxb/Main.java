package com.jaxb;

import com.jaxb.POJOs.RespuestaDeclaracion;
import com.jaxb.POJOs.RespuestaLinea;
import com.jaxb.exceptions.ParseException;
import com.jaxb.services.ParseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

/**
 * This is a program to parse XML elements from a SOAP response using JAXB.
 *
 * @author Mariana Vorotniak
 */
public class Main {

    private static String filePathRejected = "src\\main\\resources\\realResponses\\registration\\rejected\\rejectedResponse.xml";
    private static String filePathAccepted = "src\\main\\resources\\realResponses\\registration\\accepted\\acceptedWithOneResponse.xml";

    private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ParseException {

        RespuestaDeclaracion response = getResponse();

        String status = translate(response.getSendStatus());

        if (isAccepted(response))
            LOGGER.info("The status is [{}]", status);
        else {
            RespuestaLinea lineResponse = response.getLineResponse();
            int code = lineResponse.getRecordCode();
            String errorMessage = Errors.findMessageByCode(code);
            LOGGER.info("The status is [{}] and the error is [{}]", status, errorMessage);
        }
    }

    public static boolean isAccepted(RespuestaDeclaracion response) {
        String status = response.getSendStatus();
        if (status.equals("Aceptacion Completa"))
            return true;
        return false;
    }

    public static RespuestaDeclaracion getResponse() throws ParseException {
        ParseService service = new ParseService();
        String fileContent = readFile(filePathRejected);
        RespuestaDeclaracion response = service.parseResponse(fileContent);
        return response;
    }

    public static String readFile(String path) throws ParseException {
        byte[] encoded = null;
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
