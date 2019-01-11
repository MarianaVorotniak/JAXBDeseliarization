package com.jaxb.services;

import com.jaxb.POJOs.RespuestaDeclaracion;
import lombok.Getter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

@Getter
public class ParseService {

    private JAXBElement<RespuestaDeclaracion> response;
    private XMLStreamReader xmlStreamReader;

    public ParseService(String filePath) throws XMLStreamException, JAXBException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        StreamSource streamSource = new StreamSource(filePath);
        xmlStreamReader = xmlInputFactory.createXMLStreamReader(streamSource);

        goToResponseTag();

        unmarshal();
    }

    public void goToResponseTag() throws XMLStreamException {
        xmlStreamReader.nextTag();

        while(!xmlStreamReader.getLocalName().equals("RespuestaDeclaracion")) {
            xmlStreamReader.nextTag();
        }
    }

    public void unmarshal() throws JAXBException, XMLStreamException {
        JAXBContext jaxbContext = JAXBContext.newInstance(RespuestaDeclaracion.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        response = unmarshaller.unmarshal(xmlStreamReader, RespuestaDeclaracion.class);
        xmlStreamReader.close();
    }


}
