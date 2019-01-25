
package com.jaxb.POJOs;

import lombok.*;

import java.util.*;
import javax.xml.bind.annotation.*;

/**
 *  Ddii - Suministro Inmediato de Declaraciones Informativas.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeclaracionInformativa", propOrder = {
    "cabecera",
    "declarado"
})
public class DeclaracionInformativa {

    @Getter
    @Setter
    @XmlElement(name = "Cabecera", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected CabeceraDI cabecera;

    @XmlElement(name = "Declarado", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected List<DeclaradoType> declarado;

    /**
     * Gets the value of the declarado property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the declarado property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeclarado().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeclaradoType }
     * 
     * 
     */
    public List<DeclaradoType> getDeclarado() {
        if (declarado == null) {
            declarado = new ArrayList<DeclaradoType>();
        }
        return this.declarado;
    }

}
