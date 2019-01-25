package com.jaxb.POJOs;

import com.jaxb.interfaces.LoggerMessage;
import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "Fault")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fault implements LoggerMessage {

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