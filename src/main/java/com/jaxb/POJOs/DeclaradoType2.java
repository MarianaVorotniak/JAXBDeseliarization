package com.jaxb.POJOs;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

/**
 * Declaration data
 * 
 * Java class for DeclaradoType2 complex type.
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeclaradoType2", propOrder = {
    "idRegistroDeclarado"
})
public class DeclaradoType2 {

    @XmlElement(name = "IDRegistroDeclarado", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    protected String idRegistroDeclarado;

}
