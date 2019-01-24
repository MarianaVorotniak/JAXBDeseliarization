package com.jaxb.POJOs;

import lombok.Data;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "DatosInmueble")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatosInmueble {

    @Size (max = 25)
    @XmlElement(name = "ReferenciaCatastral", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String cadastralReference;

    @XmlElement(name = "Direccion", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private Direccion direction;
}
