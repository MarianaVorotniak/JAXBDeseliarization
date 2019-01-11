package com.jaxb.unmarshall;

import javax.xml.bind.annotation.*;

@XmlType(name = "Body")
@XmlAccessorType(XmlAccessType.FIELD)
public class Body {

    @XmlElement(name = "RespuestaDeclaracion", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    private RespuestaDeclaracion declarationResponse;

    @XmlAttribute(name = "Id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RespuestaDeclaracion getDeclarationResponse() {
        return declarationResponse;
    }

    public void setDeclarationResponse(RespuestaDeclaracion declarationResponse) {
        this.declarationResponse = declarationResponse;
    }

    public Body() {
    }

}
