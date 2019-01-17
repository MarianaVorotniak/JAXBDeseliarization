package com.jaxb.POJOs;

import lombok.*;

import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "Body")
@XmlAccessorType(XmlAccessType.FIELD)
public class Body {

    @XmlElement(name = "RespuestaDeclaracion", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private RespuestaDeclaracion declarationResponse;

    @XmlAttribute(name = "Id")
    private String id;

}