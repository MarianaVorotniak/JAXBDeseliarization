package com.jaxb.POJOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@XmlType(name = "RespuestaLinea")
@XmlAccessorType(XmlAccessType.FIELD)
public class RespuestaLinea {

    @XmlElement(name = "IDRegistroDeclarado", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private String recordID;

    @XmlElement(name = "EstadoRegistro", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private String recordStatus;

    @XmlElement(name = "CodigoErrorRegistro", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private int recordCode;

    @XmlElement(name = "DescripcionErrorRegistro", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private int errorDescription;

}
