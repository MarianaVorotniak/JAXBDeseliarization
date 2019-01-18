package com.jaxb.POJOs;

import lombok.Data;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "Cabecera")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cabecera {

    @Size(max = 2)
    @XmlElement(name = "TipoComunicacion", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String communicationType;

    @Size (max = 3)
    @XmlElement(name = "Modelo", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private int modelNumber;

    @XmlElement(name = "Periodo", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private Periodo period;

    @Size (max = 3)
    @XmlElement(name = "IDVersionModelo", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String modelVersionID;

    @XmlElement(name = "IDDeclarante", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private IDDeclarante idDeclaration;

}
