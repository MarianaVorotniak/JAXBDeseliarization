package com.jaxb.unmarshall;

import javax.xml.bind.annotation.*;

@XmlType(name = "Periodo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Periodo {

    @XmlElement(name = "Ejercicio", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private int exerciseNumber;

    @XmlElement(name = "Periodo", namespace="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    private String periodCode;

    public int getExerciseNumber() {
        return exerciseNumber;
    }

    public void setExerciseNumber(int exerciseNumber) {
        this.exerciseNumber = exerciseNumber;
    }

    public String getPeriodCode() {
        return periodCode;
    }

    public void setPeriodCode(String periodCode) {
        this.periodCode = periodCode;
    }

    public Periodo() {
    }
}
