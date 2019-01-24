package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "Detalle")
@XmlAccessorType(XmlAccessType.FIELD)
public class Detalle {

    @XmlElement(name = "IDCesionario", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private IDCesionario idAssignee;

    @XmlElement(name = "IDInmueble", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private IDInmueble idProperty;

    @XmlElement(name = "DesgloseOperacion", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private DesgloseOperacion operationBreakdown;

}
