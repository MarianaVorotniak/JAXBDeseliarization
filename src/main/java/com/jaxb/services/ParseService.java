package com.jaxb.services;

import com.jaxb.POJOs.*;
import com.jaxb.POJOs.Detail;
import com.jaxb.exceptions.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class ParseService {

    private static Logger LOGGER = LoggerFactory.getLogger(ParseService.class);

    public RespuestaDeclaracion parseResponse(String fileContent) throws ParseException {
        Body bodyResponse = getResponseBody(fileContent);
        RespuestaDeclaracion declarationResponse = bodyResponse.getDeclarationResponse();

        return declarationResponse;
    }

    public Fault parseFaultResponse(String fileContent) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(fileContent));

        Document doc = builder.parse(src);
        String faultstring = doc.getElementsByTagName("faultstring").item(0).getTextContent();
        String faultcode = doc.getElementsByTagName("faultcode").item(0).getTextContent();

        Detail detail = new Detail();
        detail.setCallstack(doc.getElementsByTagName("callstack").item(0).getTextContent());

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

        JAXBContext context = null;
        Envelope fullResponse = null;
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
