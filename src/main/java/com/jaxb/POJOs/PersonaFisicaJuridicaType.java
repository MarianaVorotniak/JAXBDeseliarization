
package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * Data of a Spanish or foreign physical or legal person
 * 
 * Java class for PersonaFisicaJuridicaType complex type.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonaFisicaJuridicaType", propOrder = {
    "nombreRazon",
    "nifRepresentante",
    "nif",
    "idOtro"
})
public class PersonaFisicaJuridicaType {

    @XmlElement(name = "NombreRazon", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String nombreRazon;

    @XmlElement(name = "NIFRepresentante", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String nifRepresentante;

    @XmlElement(name = "NIF", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String nif;

    @XmlElement(name = "IDOtro", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected IDOtroType idOtro;

}
