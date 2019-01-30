package com.jaxb.POJOs;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

/**
 * Java class for DatosPresentacion2Type complex type.
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosPresentacion2Type", propOrder = {
    "nifPresentador",
    "timestampPresentacion",
    "csv"
})
public class DatosPresentacion2Type {

    @XmlElement(name = "NIFPresentador", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String nifPresentador;

    @XmlElement(name = "TimestampPresentacion", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String timestampPresentacion;

    @XmlElement(name = "CSV")
    protected String csv;

}
