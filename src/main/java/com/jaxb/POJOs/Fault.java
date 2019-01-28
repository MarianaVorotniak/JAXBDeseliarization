package com.jaxb.POJOs;

import com.jaxb.exceptions.ParseException;
import com.jaxb.interfaces.Responses;
import com.jaxb.services.ParseService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.annotation.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

@Data
@XmlType(name = "Fault")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fault implements Responses {

    private static Logger LOGGER = LoggerFactory.getLogger(Fault.class);

    @XmlElement
    private String faultcode;

    @XmlElement
    private String faultstring;

    @XmlElement
    private Detail detail;

    public String getMessage() {
        return "Cause of the Fault response - [" + getFaultstring() + "]";
    }

}