package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlType(name = "detail")
@XmlAccessorType(XmlAccessType.FIELD)
public class Detail {

    @XmlElement(name = "callstack")
    private String callstack;
}
