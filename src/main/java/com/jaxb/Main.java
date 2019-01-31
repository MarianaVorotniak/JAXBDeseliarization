package com.jaxb;

import com.jaxb.POJOs.ResponseUtil;
import com.jaxb.exceptions.ParseException;
import com.jaxb.services.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * This is a program to parse XML elements from a SOAP response using JAXB.
 *
 * @author Mariana Vorotniak
 */
public class Main {

    private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static final String filePathRejected = "src\\main\\resources\\testResponses\\faultWithoutCallstack.xml";
    private static final String filePathRejectedWithMany = null;
    private static final String filePathFaultHeaderResponse = "";
    private static final String filePathFaultTechnicalResponse = "src\\main\\resources\\responses\\faultResponseTechnicalEror.xml";

    private static final String filePathPartialAcceptance = "src\\main\\resources\\testResponses\\notRecognizedResponse.xml";

    private static final String filePathAcceptedWithOne = "src\\main\\resources\\responses\\acceptedWithOneResponse.xml";
    private static final String filePathAcceptedWithMany = "src\\main\\resources\\responses\\acceptedWithManyResponses.xml";

    private static final List<String> listOfFiles = Arrays.asList(filePathRejected, filePathRejectedWithMany, filePathFaultHeaderResponse, filePathFaultTechnicalResponse,
            filePathPartialAcceptance, filePathAcceptedWithOne, filePathAcceptedWithMany);

    public static void main(String[] args) {

        MainService service = new MainService();

         processResponses(listOfFiles, service);

    }

    public static void processResponses(List<String> listOfFilePaths, MainService service){
        Object objectResponse;
        String message = "";
        for (String filePath : listOfFilePaths) {
            try {
                LOGGER.info("Reading file [{}]", filePath);
                objectResponse = service.getResponse(filePath);
                message = ResponseUtil.getMessage(objectResponse) + "\n\n";
                LOGGER.info("File successfully read!\n" + message);
            } catch (ParseException e) {
                LOGGER.info(e.getMessage());
            }
        }
    }
}
