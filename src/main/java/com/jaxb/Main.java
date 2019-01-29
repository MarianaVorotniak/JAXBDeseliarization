package com.jaxb;

import com.jaxb.POJOs.ResponseUtil;
import com.jaxb.exceptions.ParseException;
import com.jaxb.services.MainService;

/**
 * This is a program to parse XML elements from a SOAP response using JAXB.
 *
 * @author Mariana Vorotniak
 */
public class Main {

    private static final String filePathRejected = "src\\main\\resources\\responses\\rejectedResponse.xml";
    private static final String filePathRejectedWithMany = "src\\main\\resources\\responses\\rejectedWithManyResponse.xml";
    private static final String filePathWithFaultHeaderResponse = "src\\main\\resources\\responses\\faultResponseHeaderError.xml";
    private static final String filePathWithFaultTechnicalResponse = "src\\main\\resources\\responses\\faultResponseTechnicalError.xml";

    private static final String filePathPartialAcceptance = "src\\main\\resources\\responses\\partialAcceptanceResponse.xml";

    private static final String filePathAcceptedWithOne = "src\\main\\resources\\responses\\acceptedWithOneResponse.xml";
    private static final String filePathAcceptedWithMany = "src\\main\\resources\\responses\\acceptedWithManyResponses.xml";


    public static void main(String[] args) throws ParseException {

        MainService service = new MainService();

        Object objectResponse = service.getResponse(filePathWithFaultTechnicalResponse);

        String message  = ResponseUtil.getMessage(objectResponse);

        System.out.println(message);
    }
}
