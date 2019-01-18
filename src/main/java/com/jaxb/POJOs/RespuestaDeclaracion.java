package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlType(name = "RespuestaDeclaracion")
@XmlAccessorType(XmlAccessType.FIELD)
public class RespuestaDeclaracion {

    @XmlElement(name = "Cabecera", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private Cabecera cabecera;

    @XmlElement(name = "EstadoEnvio", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private String sendStatus;

    @XmlElement(name = "RespuestaLinea", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private List<RespuestaLinea> lineResponse;

    @XmlElement(name = "CSV", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private String csv;

    @XmlElement(name = "DatosPresentacion", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private DatosPresentacion presentationData;

    @XmlElement(name = "Declarado", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private Declarado declaration;

}
