
package com.jaxb.POJOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstadoRegistroDDIIType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EstadoRegistroDDIIType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Aceptado"/&gt;
 *     &lt;enumeration value="DeBaja"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EstadoRegistroDDIIType")
@XmlEnum
public enum EstadoRegistroDDIIType {


    /**
     * El registro se almacenado sin errores
     * 
     */
    @XmlEnumValue("Aceptado")
    ACEPTADO("Aceptado"),

    /**
     * El registro almacenado ha sido dado de baja
     * 
     */
    @XmlEnumValue("DeBaja")
    DE_BAJA("DeBaja");
    private final String value;

    EstadoRegistroDDIIType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EstadoRegistroDDIIType fromValue(String v) {
        for (EstadoRegistroDDIIType c: EstadoRegistroDDIIType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
