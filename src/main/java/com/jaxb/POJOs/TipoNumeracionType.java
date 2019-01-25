
package com.jaxb.POJOs;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.*;

/**
 * Java class for TipoNumeracionType.
 */
@AllArgsConstructor
@XmlType(name = "TipoNumeracionType")
@XmlEnum
public enum TipoNumeracionType {

    /**
     * Number
     */
    NUM("NUM"),

    /**
     * Kilometer
     */
    KM("KM"),

    /**
     * Without number
     */
    @XmlEnumValue("S/N")
    S_N("S/N"),

    /**
     * Other
     */
    OTR("OTR");
    private final String value;

    public String value() {
        return value;
    }

    public static TipoNumeracionType fromValue(String v) {
        for (TipoNumeracionType c: TipoNumeracionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
