
package com.jaxb.POJOs;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

/**
 * Data of a Spanish physical or legal entity with an associated NIF
 * 
 * Java class for PersonaFisicaJuridicaUnicaESType complex type.
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonaFisicaJuridicaUnicaESType", propOrder = {
    "nombreRazon",
    "nif"
})
public class PersonaFisicaJuridicaUnicaESType {

    @XmlElement(name = "NombreRazon", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String nombreRazon;

    @XmlElement(name = "NIF", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String nif;

}
