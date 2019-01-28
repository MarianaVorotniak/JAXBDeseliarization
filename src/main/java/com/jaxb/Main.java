package com.jaxb;

import com.jaxb.exceptions.ParseException;
import com.jaxb.interfaces.Responses;
import com.jaxb.services.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a program to parse XML elements from a SOAP response using JAXB.
 *
 * @author Mariana Vorotniak
 */
public class Main {

    private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static String filePathRejected = "src\\main\\resources\\responses\\rejectedResponse.xml";
    private static String filePathRejectedWithMany = "src\\main\\resources\\responses\\rejectedWithManyResponse.xml";
    private static String filePathWithFaultHeaderResponse = "src\\main\\resources\\responses\\faultResponseHeaderError.xml";
    private static String filePathWithFaultTechnicalResponse = "src\\main\\resources\\responses\\faultResponseTechnicalError.xml";

    private static String filePathPartialAcceptance = "src\\main\\resources\\responses\\partialAcceptanceResponse.xml";

    private static String filePathAcceptedWithOne = "src\\main\\resources\\responses\\acceptedWithOneResponse.xml";
    private static String filePathAcceptedWithMany = "src\\main\\resources\\responses\\acceptedWithManyResponses.xml";


    public static void main(String[] args) throws ParseException {

        MainService service = new MainService();

        Responses objectResponse = service.getResponse(filePathRejectedWithMany);

        LOGGER.info(objectResponse.getMessage());
    }
}
