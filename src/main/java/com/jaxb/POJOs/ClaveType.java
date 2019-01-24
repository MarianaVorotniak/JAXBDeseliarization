
package com.jaxb.POJOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClaveType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ClaveType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="T"/&gt;
 *     &lt;enumeration value="C"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ClaveType")
@XmlEnum
public enum ClaveType {


    /**
     * Titular 
     * 
     */
    T,

    /**
     * Cedente 
     * 
     */
    C;

    public String value() {
        return name();
    }

    public static ClaveType fromValue(String v) {
        return valueOf(v);
    }

}
