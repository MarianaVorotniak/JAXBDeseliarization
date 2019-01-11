package com.jaxb.POJOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@XmlType(name = "Body")
@XmlAccessorType(XmlAccessType.FIELD)
public class Body {

    @XmlElement(name = "RespuestaDeclaracion", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private RespuestaDeclaracion declarationResponse;

    @XmlAttribute(name = "Id")
    private String id;

}
