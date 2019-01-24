
package com.jaxb.POJOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoNumeracionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoNumeracionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NUM"/&gt;
 *     &lt;enumeration value="KM"/&gt;
 *     &lt;enumeration value="S/N"/&gt;
 *     &lt;enumeration value="OTR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TipoNumeracionType")
@XmlEnum
public enum TipoNumeracionType {


    /**
     * Número 
     * 
     */
    NUM("NUM"),

    /**
     * Kilómetro 
     * 
     */
    KM("KM"),

    /**
     * Sin número 
     * 
     */
    @XmlEnumValue("S/N")
    S_N("S/N"),

    /**
     * Otro 
     * 
     */
    OTR("OTR");
    private final String value;

    TipoNumeracionType(String v) {
        value = v;
    }

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
