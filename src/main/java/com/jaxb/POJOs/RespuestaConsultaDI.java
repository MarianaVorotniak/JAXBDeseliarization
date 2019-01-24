package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "RespuestaConsultaDI")
@XmlAccessorType(XmlAccessType.FIELD)
public class RespuestaConsultaDI {

    @XmlElement(name = "Cabecera", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaConsultaDI.xsd")
    private Cabecera head;

    @XmlElement(name = "ResultadoConsulta", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaConsultaDI.xsd")
    private String consultationResult;

    @XmlElement(name = "Declarado", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaConsultaDI.xsd")
    private Declarado declaration;
}
