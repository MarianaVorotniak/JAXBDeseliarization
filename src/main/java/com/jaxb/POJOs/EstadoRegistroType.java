
package com.jaxb.POJOs;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.*;


/**
 * Java class for EstadoRegistroType.
 */
@AllArgsConstructor
@XmlType(name = "EstadoRegistroType", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
@XmlEnum
public enum EstadoRegistroType {

    /**
     * Accepted
     */
    @XmlEnumValue("Aceptado")
    ACEPTADO("Aceptado"),

    /**
     * Rejected
     */
    @XmlEnumValue("Rechazado")
    RECHAZADO("Rechazado"),

    /**
     * Accepted with errors
     */
    @XmlEnumValue("Aceptado con Errores")
    ACEPTADO_CON_ERRORES("Aceptado con Errores");
    private final String value;

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
