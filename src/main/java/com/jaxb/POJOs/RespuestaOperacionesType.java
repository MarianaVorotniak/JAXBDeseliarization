
package com.jaxb.POJOs;

import lombok.Data;

import java.math.BigInteger;
import javax.xml.bind.annotation.*;

/**
 *  Response of sending Ddii
 * 
 * Java class for RespuestaOperacionesType complex type.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaOperacionesType", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd", propOrder = {
    "idRegistroDeclarado",
    "estadoRegistro",
    "codigoErrorRegistro",
    "descripcionErrorRegistro",
    "csv"
})
public class RespuestaOperacionesType {

    @XmlElement(name = "IDRegistroDeclarado", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String idRegistroDeclarado;

    @XmlElement(name = "EstadoRegistro", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    @XmlSchemaType(name = "string")
    protected EstadoRegistroType estadoRegistro;

    @XmlElement(name = "CodigoErrorRegistro", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    protected BigInteger codigoErrorRegistro;

    @XmlElement(name = "DescripcionErrorRegistro", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String descripcionErrorRegistro;

    @XmlElement(name = "CSV")
    protected String csv;

}
