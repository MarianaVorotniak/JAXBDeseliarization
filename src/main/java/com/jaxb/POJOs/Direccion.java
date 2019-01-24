package com.jaxb.POJOs;

import lombok.Data;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "Direccion")
@XmlAccessorType(XmlAccessType.FIELD)
public class Direccion {

    @Size (max = 30)
    @XmlElement(name = "NombreMunicipio", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String municipalityName;

    @Size (max = 3)
    @XmlElement(name = "CodigoMunicipio", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private int municipalityCode;

    @Size (max = 2)
    @XmlElement(name = "CodigoProvincia", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String cityCode;
}
