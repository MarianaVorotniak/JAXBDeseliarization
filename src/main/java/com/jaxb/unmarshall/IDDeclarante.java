package com.jaxb.unmarshall;

import javax.xml.bind.annotation.*;

@XmlType(name = "IDDeclarante")
@XmlAccessorType(XmlAccessType.FIELD)
public class IDDeclarante {

    @XmlElement(name = "NIF", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String nif;

    @XmlElement(name = "NombreRazon", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String reasonName;

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    public IDDeclarante() {
    }
}
