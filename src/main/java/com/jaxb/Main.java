package com.jaxb;

import com.jaxb.POJOs.*;
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
    private static String filePathWithFaultHeaderResponse = "src\\main\\resources\\realResponses\\registration\\rejected\\faultResponseHeaderError.xml"; //TODO : RETURNS NULL
    private static String filePathWithFaultTechnicalResponse = "src\\main\\resources\\realResponses\\registration\\rejected\\faultResponseTechnicalError.xml"; //TODO : RETURNS NULL

    private static String filePathAcceptedWithOne = "src\\main\\resources\\realResponses\\registration\\accepted\\acceptedWithOneResponse.xml";
    private static String filePathAcceptedWithMany = "src\\main\\resources\\realResponses\\registration\\accepted\\acceptedWithManyResponses.xml";

    private static String filePathConsultationResponse = "src\\main\\resources\\realResponses\\consultation\\consultationResponse.xml";

    private static String filePathCancelationResponse = "src\\main\\resources\\realResponses\\cancelation\\cancelationResponse.xml";

    private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ParseException {

        Object objectResponse = getResponse(filePathCancelationResponse);

        if (objectResponse instanceof RespuestaDeclaracion) {
            RespuestaDeclaracion response = (RespuestaDeclaracion) objectResponse;
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
        else if (objectResponse instanceof Fault){
            Fault faultResponse = (Fault) objectResponse;
            LOGGER.info("The fault code is [{}]", faultResponse);
        }
        else if (objectResponse instanceof RespuestaBajaDI) {
            RespuestaBajaDI cancelationResponse = (RespuestaBajaDI) objectResponse;
            LOGGER.info("The fault code is [{}]", cancelationResponse);
        }
        else if (objectResponse instanceof RespuestaConsultaDI) {
            RespuestaConsultaDI consultationResponse = (RespuestaConsultaDI) objectResponse;
            LOGGER.info("The fault code is [{}]", consultationResponse);
        }

    }

    public static boolean isAccepted(RespuestaDeclaracion response) {
        String status = response.getSendStatus();
        if (status.equals("Aceptacion Completa"))
            return true;
        return false;
    }

    public static Object getResponse(String filePath) throws ParseException {
        ParseService service = new ParseService();
        String fileContent = readFile(filePath);
        if (fileContent.contains("RespuestaDeclaracion"))
            return service.parseResponse(fileContent);
        else if (fileContent.contains("Fault"))
            return service.parseFaultResponse(fileContent);
        else if (fileContent.contains("RespuestaConsultaDI"))
            return service.parseConsultationResponse(fileContent);
        else
            return service.parseCancelationResponse(fileContent);
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
