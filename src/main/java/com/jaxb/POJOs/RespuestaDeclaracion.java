package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "RespuestaDeclaracion")
@XmlAccessorType(XmlAccessType.FIELD)
public class RespuestaDeclaracion {

    @XmlElement(name = "Cabecera", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private Cabecera cabecera;

    @XmlElement(name = "EstadoEnvio", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private String sendStatus;

    @XmlElement(name = "RespuestaLinea", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private RespuestaLinea lineResponse;

}
