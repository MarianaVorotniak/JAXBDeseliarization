
package com.jaxb.POJOs;

import javax.xml.bind.annotation.*;

/**
 * Java class for MacrodatoType.
 */
@XmlType(name = "MacrodatoType")
@XmlEnum
public enum MacrodatoType {

    S,
    N;

    public String value() {
        return name();
    }

    public static MacrodatoType fromValue(String v) {
        return valueOf(v);
    }

}
