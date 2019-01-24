package com.jaxb.services;

import com.jaxb.POJOs.*;
import com.jaxb.exceptions.ParseException;
import org.w3c.dom.Document;
import org.xml.sax.*;

import javax.xml.bind.*;
import javax.xml.parsers.*;
import java.io.*;

public class ParseService {

    public RespuestaDeclaracion parseResponse(String fileContent) throws ParseException {
        Body bodyResponse = getResponseBody(fileContent);
        RespuestaDeclaracion declarationResponse = bodyResponse.getDeclarationResponse();

        return declarationResponse;
    }

    public Fault parseFaultResponse(String fileContent) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(fileContent));

        Document document = builder.parse(src);
        String faultstring = document.getElementsByTagName("faultstring").item(0).getTextContent();
        String faultcode = document.getElementsByTagName("faultcode").item(0).getTextContent();

        Detail detail = new Detail();
        detail.setCallstack(document.getElementsByTagName("callstack").item(0).getTextContent());

        Fault fault = new Fault();
        fault.setFaultstring(faultstring);
        fault.setFaultcode(faultcode);
        fault.setDetail(detail);

        return fault;
    }

    public RespuestaConsultaDI parseConsultationResponse(String fileContent) throws ParseException {
        Body bodyResponse = getResponseBody(fileContent);
        RespuestaConsultaDI consultationResponse = bodyResponse.getResponseConsultationDI();

        return consultationResponse;
    }

    public RespuestaBajaDI parseCancelationResponse(String fileContent) throws ParseException {
        Body bodyResponse = getResponseBody(fileContent);
        RespuestaBajaDI cancelationResponse = bodyResponse.getCancelationResponseDI();

        return cancelationResponse;
    }

    public Body getResponseBody(String fileContent) throws ParseException {
        Envelope fullResponse = unmarshal(fileContent);
        Body bodyResponse = fullResponse.getResponseBody();

        return bodyResponse;
    }

    public Envelope unmarshal(String fileContent) throws ParseException {

        if (fileContent == null)
            throw new ParseException("File content is null");
        else if (fileContent.isEmpty())
            throw new ParseException("File content is empty");

        StringReader reader = new StringReader(fileContent);

        JAXBContext context;
        Envelope fullResponse;

        try {
            context = JAXBContext.newInstance(Envelope.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            fullResponse = (Envelope) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            throw new ParseException("Wrong xml");
        }

        return fullResponse;
    }

}
