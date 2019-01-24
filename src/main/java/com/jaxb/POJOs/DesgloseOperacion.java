package com.jaxb.POJOs;

import lombok.Data;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "DesgloseOperacion")
@XmlAccessorType(XmlAccessType.FIELD)
public class DesgloseOperacion {

    @XmlElement(name = "PeriodoCesion", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private PeriodoCesion assignmentPeriod;

    @XmlElement(name = "Importe", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private double amount;

    @Size (max = 20)
    @XmlElement(name = "NumeroContrato", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String contractNumber;

    @XmlElement(name = "MedioPago", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private MedioPago paymentMethod;
}
