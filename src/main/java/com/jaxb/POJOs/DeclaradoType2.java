
package com.jaxb.POJOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Datos correspondientes al Declarado 
 * 
 * <p>Java class for DeclaradoType2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeclaradoType2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IDRegistroDeclarado" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax20Type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeclaradoType2", propOrder = {
    "idRegistroDeclarado"
})
public class DeclaradoType2 {

    @XmlElement(name = "IDRegistroDeclarado", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String idRegistroDeclarado;

    /**
     * Gets the value of the idRegistroDeclarado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDRegistroDeclarado() {
        return idRegistroDeclarado;
    }

    /**
     * Sets the value of the idRegistroDeclarado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDRegistroDeclarado(String value) {
        this.idRegistroDeclarado = value;
    }

}
