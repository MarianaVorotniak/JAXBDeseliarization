package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlType(name = "Fault")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fault {

    @XmlElement(name = "faultcode")
    private String faultcode;

    @XmlElement(name = "faultstring")
    private String faultstring;

    @XmlElement(name = "detail")
    private Detail detail;
}
