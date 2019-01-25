
package com.jaxb.POJOs;

import javax.xml.bind.annotation.*;

/**
 * Java class for ClaveType.
 */
@XmlType(name = "ClaveType")
@XmlEnum
public enum ClaveType {

    /**
     * Headline
     */
    T,

    /**
     * Assignor
     */
    C;

    public String value() {
        return name();
    }

    public static ClaveType fromValue(String v) {
        return valueOf(v);
    }

}
