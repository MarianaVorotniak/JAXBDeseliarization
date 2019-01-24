package com.jaxb.POJOs;

import lombok.Data;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "PeriodoCesion")
@XmlAccessorType(XmlAccessType.FIELD)
public class PeriodoCesion {

    @XmlElement(name = "FechaIntermediacion", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String intermediationDate;

    @XmlElement(name = "FechaInicioCesion", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String startOfSessionDate;

    @Size (max = 3)
    @XmlElement(name = "NumeroDiasDisfrute", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private int numberOfDays;
}
