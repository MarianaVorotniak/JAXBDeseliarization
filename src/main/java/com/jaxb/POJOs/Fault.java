package com.jaxb.POJOs;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Fault {

    @XmlElement
    private String faultcode;

    @XmlElement
    private String faultstring;

    @XmlElement
    private Detail detail;

}