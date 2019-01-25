package com.jaxb;

import com.jaxb.exceptions.ParseException;
import com.jaxb.interfaces.Responses;
import com.jaxb.services.MainService;

/**
 * This is a program to parse XML elements from a SOAP response using JAXB.
 *
 * @author Mariana Vorotniak
 */
public class Main {

    private static String filePathRejected = "src\\main\\resources\\responses\\rejectedResponse.xml";
    private static String filePathWithFaultHeaderResponse = "src\\main\\resources\\responses\\faultResponseHeaderError.xml";
    private static String filePathWithFaultTechnicalResponse = "src\\main\\resources\\responses\\faultResponseTechnicalError.xml";

    private static String filePathAcceptedWithOne = "src\\main\\resources\\responses\\acceptedWithOneResponse.xml";
    private static String filePathAcceptedWithMany = "src\\main\\resources\\responses\\acceptedWithManyResponses.xml";


    public static void main(String[] args) throws ParseException {

        MainService service = new MainService();

        Responses objectResponse = service.getResponse(filePathRejected);

        service.printResponse(objectResponse);
    }

}
