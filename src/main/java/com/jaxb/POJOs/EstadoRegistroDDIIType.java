
package com.jaxb.POJOs;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.*;


/**
 * Java class for EstadoRegistroDDIIType.
 */
@AllArgsConstructor
@XmlType(name = "EstadoRegistroDDIIType")
@XmlEnum
public enum EstadoRegistroDDIIType {

    /**
     * The record was stored without errors
     */
    @XmlEnumValue("Aceptado")
    ACEPTADO("Aceptado"),

    /**
     * The stored record has been discharged
     */
    @XmlEnumValue("DeBaja")
    DE_BAJA("DeBaja");
    private final String value;

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
