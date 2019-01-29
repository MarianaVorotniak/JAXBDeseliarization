package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Fault {

    @XmlElement
    private String faultcode;

    @XmlElement
    private String faultstring;

    @XmlElement
    private Detail detail;

}