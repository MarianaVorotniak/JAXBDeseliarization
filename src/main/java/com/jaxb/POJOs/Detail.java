package com.jaxb.POJOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "detail")
@XmlAccessorType(XmlAccessType.FIELD)
public class Detail {

    @XmlElement
    private String callstack;

    public String getCallstack() {
        return callstack;
    }

    public void setCallstack(String callstack) {
        this.callstack = callstack;
    }

}
