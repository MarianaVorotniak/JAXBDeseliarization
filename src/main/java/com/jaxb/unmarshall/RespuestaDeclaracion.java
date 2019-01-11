package com.jaxb.unmarshall;

import javax.xml.bind.annotation.*;

@XmlType(name = "RespuestaDeclaracion")
@XmlAccessorType(XmlAccessType.FIELD)
public class RespuestaDeclaracion {

    @XmlElement(name = "Cabecera", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private Cabecera cabecera;

    @XmlElement(name = "EstadoEnvio", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private String sentStatus;

    @XmlElement(name = "RespuestaLinea", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private RespuestaLinea lineResponse;

    public Cabecera getCabecera() {
        return cabecera;
    }

    public void setCabecera(Cabecera cabecera) {
        this.cabecera = cabecera;
    }

    public String getSentStatus() {
        return sentStatus;
    }

    public void setSentStatus(String sentStatus) {
        this.sentStatus = sentStatus;
    }

    public RespuestaLinea getLineResponse() {
        return lineResponse;
    }

    public void setLineResponse(RespuestaLinea lineResponse) {
        this.lineResponse = lineResponse;
    }

    public RespuestaDeclaracion() {
    }
}
