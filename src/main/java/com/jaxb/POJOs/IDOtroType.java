
package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * Physical or legal person identifier differs from the NIF (country code, type of identifier, and up to 15 characters).
 * Not allowed CodigoPais = ES and IDType = 01-NIF.
 * Counterpart for that case, NIF must be used instead of IDOtro.
 *
 * Java class for IDOtroType complex type.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDOtroType", propOrder = {
    "codigoPais",
    "idType",
    "id"
})
public class IDOtroType {

    @XmlElement(name = "CodigoPais", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    @XmlSchemaType(name = "string")
    protected CountryType2 codigoPais;

    @XmlElement(name = "IDType", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String idType;

    @XmlElement(name = "ID", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String id;

}
