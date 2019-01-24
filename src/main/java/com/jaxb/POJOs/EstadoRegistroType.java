
package com.jaxb.POJOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstadoRegistroType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EstadoRegistroType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Aceptado"/&gt;
 *     &lt;enumeration value="Rechazado"/&gt;
 *     &lt;enumeration value="Aceptado con Errores"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EstadoRegistroType", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
@XmlEnum
public enum EstadoRegistroType {


    /**
     * Aceptado
     * 
     */
    @XmlEnumValue("Aceptado")
    ACEPTADO("Aceptado"),

    /**
     * Rechazado
     * 
     */
    @XmlEnumValue("Rechazado")
    RECHAZADO("Rechazado"),

    /**
     * Aceptado con Errores
     * 
     */
    @XmlEnumValue("Aceptado con Errores")
    ACEPTADO_CON_ERRORES("Aceptado con Errores");
    private final String value;

    EstadoRegistroType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EstadoRegistroType fromValue(String v) {
        for (EstadoRegistroType c: EstadoRegistroType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
