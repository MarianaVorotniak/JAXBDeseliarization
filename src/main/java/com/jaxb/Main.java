package com.jaxb;

import com.jaxb.POJOs.ResponseUtil;
import com.jaxb.exceptions.ParseException;
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

    private static final String filePathRejected = "src\\main\\resources\\responses\\rejectedResponse.xml";
    private static final String filePathRejectedWithMany = "src\\main\\resources\\responses\\rejectedWithManyResponse.xml";
    private static final String filePathFaultHeaderResponse = "src\\main\\resources\\responses\\faultResponseHeaderError.xml";
    private static final String filePathFaultTechnicalResponse = "src\\main\\resources\\responses\\faultResponseTechnicalError.xml";

    private static final String filePathPartialAcceptance = "src\\main\\resources\\responses\\partialAcceptanceResponse.xml";

    private static final String filePathAcceptedWithOne = "src\\main\\resources\\responses\\acceptedWithOneResponse.xml";
    private static final String filePathAcceptedWithMany = "src\\main\\resources\\responses\\acceptedWithManyResponses.xml";


    public static void main(String[] args) throws ParseException {

        MainService service = new MainService();

        Object objectResponse = service.getResponse(filePathAcceptedWithMany);

        String message  = ResponseUtil.getMessage(objectResponse);

        LOGGER.info(message);
    }
}
