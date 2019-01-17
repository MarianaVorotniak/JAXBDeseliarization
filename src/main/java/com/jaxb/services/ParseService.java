package com.jaxb.services;

import com.jaxb.exceptions.ParseException;
import com.jaxb.POJOs.Body;
import com.jaxb.POJOs.Envelope;
import com.jaxb.POJOs.RespuestaDeclaracion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class ParseService {

    private static Logger LOGGER = LoggerFactory.getLogger(ParseService.class);

    public RespuestaDeclaracion parseResponse(String fileContent) throws ParseException {
        Envelope fullResponse = unmarshal(fileContent);

        Body bodyResponse = fullResponse.getResponseBody();
        RespuestaDeclaracion declarationResponse = bodyResponse.getDeclarationResponse();

        return declarationResponse;
    }


    private Envelope unmarshal(String fileContent) throws ParseException {

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
