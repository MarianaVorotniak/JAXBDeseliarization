package com.jaxb.services;

import com.jaxb.POJOs.Body;
import com.jaxb.POJOs.Envelope;
import com.jaxb.POJOs.RespuestaDeclaracion;
import lombok.NoArgsConstructor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@NoArgsConstructor
public class ParseService {

    public RespuestaDeclaracion parseResponse(String filePath) throws JAXBException {
        Envelope fullResponse = unmarshal(filePath);

        Body bodyResponse = fullResponse.getResponseBody();
        RespuestaDeclaracion declarationResponse = bodyResponse.getDeclarationResponse();

        return declarationResponse;
    }


    public Envelope unmarshal(String filePath) throws JAXBException {
        File responseFile = new File(filePath);

        JAXBContext context = JAXBContext.newInstance(Envelope.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Envelope fullResponse = (Envelope) unmarshaller.unmarshal(responseFile);

        return fullResponse;
    }
}
