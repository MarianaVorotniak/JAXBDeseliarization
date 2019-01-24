package com.jaxb.POJOs;

import lombok.Data;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;

@Data
@XmlType(name = "MedioPago")
@XmlAccessorType(XmlAccessType.FIELD)
public class MedioPago {

    @Size (max = 2)
    @XmlElement(name = "ClaveMedioPago", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private int paymentMethodkey;

    @Size (max = 30)
    @XmlElement(name = "IDMedioPago", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String paymentMethodId;
}
