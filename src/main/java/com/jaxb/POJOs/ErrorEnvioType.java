
package com.jaxb.POJOs;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.*;

/**
 * Java class for ErrorEnvioType.
 */
@AllArgsConstructor
@XmlType(name = "ErrorEnvioType", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
@XmlEnum
public enum ErrorEnvioType {

    /**
     * Scheme validation error
     */
    @XmlEnumValue("ERR01")
    ERR_01("ERR01"),

    /**
     * Unknown declaration
     */
    @XmlEnumValue("ERR03")
    ERR_03("ERR03"),

    /**
     * The declaration must be identified by a Spanish NIF
     */
    @XmlEnumValue("ERR04")
    ERR_04("ERR04"),

    /**
     * Incorrect NIF
     */
    @XmlEnumValue("ERR05")
    ERR_05("ERR05");
    private final String value;

    public String value() {
        return value;
    }

    public static ErrorEnvioType fromValue(String v) {
        for (ErrorEnvioType c: ErrorEnvioType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
