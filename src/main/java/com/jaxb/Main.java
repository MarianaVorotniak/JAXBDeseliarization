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

    private static final String filePathRejected = "src\\main\\resources\\responses\\rejectedResponse.xml";
    private static final String filePathRejectedWithMany = "src\\main\\resources\\responses\\rejectedWithManyResponse.xml";
    private static final String filePathFaultHeaderResponse = "src\\main\\resources\\responses\\faultResponseHeaderError.xml";
    private static final String filePathFaultTechnicalResponse = "src\\main\\resources\\responses\\faultResponseTechnicalError.xml";

    private static final String filePathPartialAcceptance = "src\\main\\resources\\responses\\partialAcceptanceResponse.xml";

    private static final String filePathAcceptedWithOne = "src\\main\\resources\\responses\\acceptedWithOneResponse.xml";
    private static final String filePathAcceptedWithMany = "src\\main\\resources\\responses\\acceptedWithManyResponses.xml";

    private static final List<String> listOfFiles = Arrays.asList(filePathRejected, filePathRejectedWithMany, filePathFaultHeaderResponse, filePathFaultTechnicalResponse,
            filePathPartialAcceptance, filePathAcceptedWithOne, filePathAcceptedWithMany);

    public static void main(String[] args) throws ParseException {

        MainService service = new MainService();

         processResponses(listOfFiles, service);

    }

    public static void processResponses(List<String> responses, MainService service) throws ParseException {
        Object objectResponse;
        StringBuilder message = new StringBuilder();
        for (String response : responses) {
            objectResponse = service.getResponse(response);
            message.append(ResponseUtil.getMessage(objectResponse) + "\n\n\n");
        }
        LOGGER.info(message.toString());
    }
}
