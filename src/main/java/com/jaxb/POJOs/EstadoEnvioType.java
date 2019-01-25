
package com.jaxb.POJOs;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.*;


/**
 * Java class for EstadoEnvioType.
 */
@AllArgsConstructor
@XmlType(name = "EstadoEnvioType", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
@XmlEnum
public enum EstadoEnvioType {

    /**
     * Fully acceptance
     */
    @XmlEnumValue("Aceptacion Completa")
    ACEPTACION_COMPLETA("Aceptacion Completa"),

    /**
     * Partial acceptance
     */
    @XmlEnumValue("Aceptacion Parcial")
    ACEPTACION_PARCIAL("Aceptacion Parcial"),

    /**
     * Full rejection
     */
    @XmlEnumValue("Rechazo Completo")
    RECHAZO_COMPLETO("Rechazo Completo");
    private final String value;

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
