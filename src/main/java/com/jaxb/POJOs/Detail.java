package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "detail")
@XmlAccessorType(XmlAccessType.FIELD)
public class Detail {

    @XmlElement
    private String callstack;

}
