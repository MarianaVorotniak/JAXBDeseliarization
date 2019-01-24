package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "DatosPresentacion")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatosPresentacion {

    @XmlElement(name = "NIFPresentador", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String nifPresenter;

    @XmlElement(name = "TimestampPresentacion", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String timestamp;
}
