
package com.jaxb.POJOs;

import javax.xml.bind.annotation.*;

/**
 * Java class for CountryMiembroType.
 */
@XmlType(name = "CountryMiembroType")
@XmlEnum
public enum CountryMiembroType {

    DE,
    AT,
    BE,
    BG,
    CZ,
    CY,
    HR,
    DK,
    SK,
    SI,
    EE,
    FI,
    FR,
    GR,
    HU,
    IE,
    IT,
    LV,
    LT,
    LU,
    MT,
    NL,
    PL,
    PT,
    GB,
    RO,
    SE;

    public String value() {
        return name();
    }

    public static CountryMiembroType fromValue(String v) {
        return valueOf(v);
    }

}
