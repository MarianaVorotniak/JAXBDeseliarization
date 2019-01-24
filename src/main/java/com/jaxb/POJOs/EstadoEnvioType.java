
package com.jaxb.POJOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstadoEnvioType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EstadoEnvioType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Aceptacion Completa"/&gt;
 *     &lt;enumeration value="Aceptacion Parcial"/&gt;
 *     &lt;enumeration value="Rechazo Completo"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EstadoEnvioType", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
@XmlEnum
public enum EstadoEnvioType {


    /**
     * Aceptacion Completa
     * 
     */
    @XmlEnumValue("Aceptacion Completa")
    ACEPTACION_COMPLETA("Aceptacion Completa"),

    /**
     * Aceptacion Parcial
     * 
     */
    @XmlEnumValue("Aceptacion Parcial")
    ACEPTACION_PARCIAL("Aceptacion Parcial"),

    /**
     * Rechazo Completo
     * 
     */
    @XmlEnumValue("Rechazo Completo")
    RECHAZO_COMPLETO("Rechazo Completo");
    private final String value;

    EstadoEnvioType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EstadoEnvioType fromValue(String v) {
        for (EstadoEnvioType c: EstadoEnvioType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
