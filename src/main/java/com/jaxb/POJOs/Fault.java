package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.*;

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
