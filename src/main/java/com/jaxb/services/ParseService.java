package com.jaxb.services;

import com.jaxb.POJOs.*;
import com.jaxb.exceptions.ParseException;
import org.slf4j.*;
import org.w3c.dom.Document;
import org.xml.sax.*;

import javax.xml.bind.*;
import javax.xml.parsers.*;
import java.io.*;

public class ParseService {

    private static Logger LOGGER = LoggerFactory.getLogger(ParseService.class);

    protected RespuestaDeclaracionType parseResponse(String fileContent) throws ParseException {
        Body bodyResponse = getResponseBody(fileContent);

        return bodyResponse.getRespuestaDeclaracionType();
    }

    protected Fault parseFaultResponse(String fileContent) throws ParseException {

        checkFileContent(fileContent);

        Fault fault = new Fault(new BasicMessage());

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource src = new InputSource();
            src.setCharacterStream(new StringReader(fileContent));

            Document document = builder.parse(src);
            String faultstring = document.getElementsByTagName("faultstring").item(0).getTextContent();
            String faultcode = document.getElementsByTagName("faultcode").item(0).getTextContent();

            Detail detail = new Detail();
            detail.setCallstack(document.getElementsByTagName("callstack").item(0).getTextContent());

            fault.setFaultstring(faultstring);
            fault.setFaultcode(faultcode);
            fault.setDetail(detail);
        } catch (ParserConfigurationException e) {
            LOGGER.warn("ParserConfigurationException [{}]", e.getMessage());
        } catch (IOException e) {
            LOGGER.warn("IOException [{}]", e.getMessage());
        } catch (SAXException e) {
            LOGGER.warn("SAXException [{}]", e.getMessage());
        }

        return fault;
    }

    private static Body getResponseBody(String fileContent) throws ParseException {
        Envelope fullResponse = unmarshal(fileContent);

        return fullResponse.getBody();
    }

    private static Envelope unmarshal(String fileContent) throws ParseException {

        checkFileContent(fileContent);

        StringReader reader = new StringReader(fileContent);

        Envelope fullResponse;

        try {
            JAXBContext context = JAXBContext.newInstance(Envelope.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            fullResponse = (Envelope) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
                throw new ParseException("Wrong xml. Can't unmarshal file. Cause: " + e.getMessage());
        }

        return fullResponse;
    }

    private static void checkFileContent(String fileContent) throws ParseException {
        if (fileContent == null)
            throw new ParseException("File content is null");
        else if (fileContent.isEmpty())
            throw new ParseException("File content is empty");
    }

}
