package com.jaxb.POJOs;

import lombok.Data;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "IDDeclarante")
@XmlAccessorType(XmlAccessType.FIELD)
public class IDDeclarante {

    @Size (max = 9)
    @XmlElement(name = "NIF", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String nif;

    @Size (max = 120)
    @XmlElement(name = "NombreRazon", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String reasonName;

    @Size (max = 9)
    @XmlElement(name = "NIFRepresentante", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String nifRepresentative;

    @XmlElement(name = "PersonaContacto", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private PersonaContacto contactPerson;
}
