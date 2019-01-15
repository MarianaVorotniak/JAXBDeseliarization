package com.jaxb.services;

import com.jaxb.POJOs.Body;
import com.jaxb.POJOs.Envelope;
import com.jaxb.POJOs.RespuestaDeclaracion;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ParseService {

    private static Logger LOGGER = LoggerFactory.getLogger(ParseService.class);

    public RespuestaDeclaracion parseResponse(String filePath) {
        Envelope fullResponse = unmarshal(filePath);

        if (fullResponse.getResponseBody() == null && fullResponse.getHeader() == null)
            return new RespuestaDeclaracion();

        Body bodyResponse = fullResponse.getResponseBody();
        RespuestaDeclaracion declarationResponse = bodyResponse.getDeclarationResponse();

        return declarationResponse;
    }


    private Envelope unmarshal(String filePath) {
        Envelope fullResponse = null;

        try {
        File responseFile = new File(filePath);

        if(!responseFile.exists() || responseFile.isDirectory() || filePath.isEmpty()) {
            LOGGER.warn("File:\n\t\t -does not exist;\n\t\t -or is a directory;\n\t\t -or path is empty");
            return new Envelope();
        }

        if(!checkXml(filePath))
            return new Envelope();

        JAXBContext context = JAXBContext.newInstance(Envelope.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        fullResponse = (Envelope) unmarshaller.unmarshal(responseFile);

        } catch (NullPointerException e) {
            LOGGER.warn("Entered file is null");
            return new Envelope();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return fullResponse;
    }

    private boolean checkXml(String filePath) throws ParserConfigurationException, IOException, SAXException {

        if(!checkExtension(filePath))
            return false;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);

        DocumentBuilder builder = factory.newDocumentBuilder();

        builder.setErrorHandler(new ErrorHandler() {
            public void warning(SAXParseException e) throws SAXException {
                LOGGER.warn(e.getMessage());
            }

            public void error(SAXParseException e) throws SAXException {
                LOGGER.error(e.getMessage());
            }

            public void fatalError(SAXParseException e) throws SAXException {
                LOGGER.error("FATAL - " + e.getMessage());
            }
        });

        try {
            Document document = builder.parse(new InputSource(filePath));
        } catch (SAXException e) {
            return false;
        }

        return true;
    }

    private boolean checkExtension(String filePath) {
        if (!FilenameUtils.getExtension(filePath).equals("xml")) {
            LOGGER.warn("The file's extension is not xml");
            return false;
        }
        return true;
    }
}
