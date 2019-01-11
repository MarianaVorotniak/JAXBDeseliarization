package com.jaxb.unmarshall;

import javax.xml.bind.annotation.*;

@XmlType(name = "Cabecera")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cabecera {

    @XmlElement(name = "TipoComunicacion", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String communicationType;

    @XmlElement(name = "Modelo", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private int modelNumber;

    @XmlElement(name = "Periodo", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private Periodo period;

    @XmlElement(name = "IDVersionModelo", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private int modelVersionID;

    @XmlElement(name = "IDDeclarante", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private IDDeclarante idDeclarante;

    public String getCommunicationType() {
        return communicationType;
    }

    public void setCommunicationType(String communicationType) {
        this.communicationType = communicationType;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Periodo getPeriod() {
        return period;
    }

    public void setPeriod(Periodo period) {
        this.period = period;
    }

    public int getModelVersionID() {
        return modelVersionID;
    }

    public void setModelVersionID(int modelVersionID) {
        this.modelVersionID = modelVersionID;
    }

    public IDDeclarante getIdDeclarante() {
        return idDeclarante;
    }

    public void setIdDeclarante(IDDeclarante idDeclarante) {
        this.idDeclarante = idDeclarante;
    }

    public Cabecera() {
    }
}
