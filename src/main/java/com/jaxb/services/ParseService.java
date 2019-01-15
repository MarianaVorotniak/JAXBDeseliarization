package com.jaxb.services;

import com.jaxb.IncorrectFileException;
import com.jaxb.POJOs.Body;
import com.jaxb.POJOs.Envelope;
import com.jaxb.POJOs.RespuestaDeclaracion;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ParseService {

    private static Logger LOGGER = LoggerFactory.getLogger(ParseService.class);

    public RespuestaDeclaracion parseResponse(String filePath) throws IncorrectFileException {
        Envelope fullResponse = unmarshal(filePath);

        Body bodyResponse = fullResponse.getResponseBody();
        RespuestaDeclaracion declarationResponse = bodyResponse.getDeclarationResponse();

        return declarationResponse;
    }


    private Envelope unmarshal(String filePath) throws IncorrectFileException {

        if (filePath == null)
            throw new IncorrectFileException("File path is null");
        else if (filePath.isEmpty())
            throw new IncorrectFileException("File path is empty");
        else if (checkExtension(filePath) == false)
            throw new IncorrectFileException("File extension is not xml");

        Envelope fullResponse = null;

        try {
        File responseFile = new File(filePath);

        if(!responseFile.exists() || responseFile.isDirectory()) {
            throw new IncorrectFileException("File does not exist or is a directory");
        }

        JAXBContext context = JAXBContext.newInstance(Envelope.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        fullResponse = (Envelope) unmarshaller.unmarshal(responseFile);

        } catch (JAXBException e) {
            throw new IncorrectFileException("Wrong xml");
        }

        return fullResponse;
    }

    private boolean checkExtension(String filePath) {
        if (!FilenameUtils.getExtension(filePath).equals("xml"))
            return false;
        return true;
    }
}
