package com.jaxb;

import com.jaxb.exceptions.ParseException;
import com.jaxb.services.MainService;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * This is a program to parse XML elements from a SOAP response using JAXB.
 *
 * @author Mariana Vorotniak
 */
public class Main {

    private static String filePathRejected = "src\\main\\resources\\realResponses\\registration\\rejected\\rejectedResponse.xml";
    private static String filePathWithFaultHeaderResponse = "src\\main\\resources\\realResponses\\registration\\rejected\\faultResponseHeaderError.xml";
    private static String filePathWithFaultTechnicalResponse = "src\\main\\resources\\realResponses\\registration\\rejected\\faultResponseTechnicalError.xml";

    private static String filePathAcceptedWithOne = "src\\main\\resources\\realResponses\\registration\\accepted\\acceptedWithOneResponse.xml";
    private static String filePathAcceptedWithMany = "src\\main\\resources\\realResponses\\registration\\accepted\\acceptedWithManyResponses.xml";

    private static String filePathConsultationResponse = "src\\main\\resources\\realResponses\\consultation\\consultationResponse.xml";

    private static String filePathCancelationResponse = "src\\main\\resources\\realResponses\\cancelation\\cancelationResponse.xml";


    public static void main(String[] args) throws ParseException, ParserConfigurationException, SAXException, IOException {

        MainService service = new MainService();

        Object objectResponse = service.getResponse(filePathCancelationResponse);

        service.checkResponseType(objectResponse);
    }

}
