
package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * Java class for RespuestaComunAltaType complex type.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaComunAltaType", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd", propOrder = {
    "csv",
    "datosPresentacion",
    "cabecera",
    "estadoEnvio"
})
@XmlSeeAlso({
    RespuestaDeclaracionType.class
})
public class RespuestaComunAltaType {

    @XmlElement(name = "CSV")
    protected String csv;

    @XmlElement(name = "DatosPresentacion", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected DatosPresentacionType datosPresentacion;

    @XmlElement(name = "Cabecera", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected CabeceraDI cabecera;

    @XmlElement(name = "EstadoEnvio", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    @XmlSchemaType(name = "string")
    protected EstadoEnvioType estadoEnvio;

}
