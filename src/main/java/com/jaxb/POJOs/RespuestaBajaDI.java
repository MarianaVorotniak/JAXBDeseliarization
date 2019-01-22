package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlType(name = "RespuestaBajaDI")
@XmlAccessorType(XmlAccessType.FIELD)
public class RespuestaBajaDI {

    @XmlElement(name = "CSV", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaBajaDI.xsd")
    private String csv;

    @XmlElement(name = "DatosPresentacion", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaBajaDI.xsd")
    private DatosPresentacion presentationDate;

    @XmlElement(name = "Cabecera", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaBajaDI.xsd")
    private Cabecera head;

    @XmlElement(name = "Declarado", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaBajaDI.xsd")
    private Declarado declaration;

    @XmlElement(name = "EstadoEnvio", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaBajaDI.xsd")
    private String sendStatus;

    @XmlElement(name = "RespuestaLinea", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaBajaDI.xsd")
    private RespuestaLinea lineResponse;
}
