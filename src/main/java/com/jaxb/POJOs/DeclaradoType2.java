
package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * Declaration data
 * 
 * Java class for DeclaradoType2 complex type.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeclaradoType2", propOrder = {
    "idRegistroDeclarado"
})
public class DeclaradoType2 {

    @XmlElement(name = "IDRegistroDeclarado", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String idRegistroDeclarado;

}
