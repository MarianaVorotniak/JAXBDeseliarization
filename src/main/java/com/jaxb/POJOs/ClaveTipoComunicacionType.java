
package com.jaxb.POJOs;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.*;

/**
 * Java class for ClaveTipoComunicacionType.
 */
@AllArgsConstructor
@XmlType(name = "ClaveTipoComunicacionType")
@XmlEnum
public enum ClaveTipoComunicacionType {

    /**
     *  A0 Registration (A record is added to the book)
     */
    @XmlEnumValue("A0")
    A_0("A0"),

    /**
     *  A1 Modification (The information is replaced by the existing)
     */
    @XmlEnumValue("A1")
    A_1("A1");

    private final String value;

    public String value() {
        return value;
    }

    public static ClaveTipoComunicacionType fromValue(String v) {
        for (ClaveTipoComunicacionType c: ClaveTipoComunicacionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
