package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "Envelope")
@XmlRootElement(name="Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {

    @XmlElement(name = "Header", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Header header;

    @XmlElement(name="Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body responseBody;

}
