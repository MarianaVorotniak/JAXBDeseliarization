package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "Body")
@XmlAccessorType(XmlAccessType.FIELD)
    public class Body {

    @XmlElement(name = "RespuestaDeclaracion", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private RespuestaDeclaracionType respuestaDeclaracionType;

    @XmlAttribute(name = "Id")
    private String id;

    @XmlElement(name="Fault")
    private Fault fault;

}

