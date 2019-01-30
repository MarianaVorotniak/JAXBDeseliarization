package com.jaxb.POJOs;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@XmlType(name = "detail")
@XmlAccessorType(XmlAccessType.FIELD)
public class Detail {

    @XmlElement
    private String callstack;

}
