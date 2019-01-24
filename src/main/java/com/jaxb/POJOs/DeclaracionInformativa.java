
package com.jaxb.POJOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Ddii - Suministro Inmediato de Declaraciones Informativas. 
 * 
 * <p>Java class for DeclaracionInformativa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeclaracionInformativa"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Cabecera" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}CabeceraDI"/&gt;
 *         &lt;element name="Declarado" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}DeclaradoType" maxOccurs="10000"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeclaracionInformativa", propOrder = {
    "cabecera",
    "declarado"
})
public class DeclaracionInformativa {

    @XmlElement(name = "Cabecera", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected CabeceraDI cabecera;
    @XmlElement(name = "Declarado", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected List<DeclaradoType> declarado;

    /**
     * Gets the value of the cabecera property.
     * 
     * @return
     *     possible object is
     *     {@link CabeceraDI }
     *     
     */
    public CabeceraDI getCabecera() {
        return cabecera;
    }

    /**
     * Sets the value of the cabecera property.
     * 
     * @param value
     *     allowed object is
     *     {@link CabeceraDI }
     *     
     */
    public void setCabecera(CabeceraDI value) {
        this.cabecera = value;
    }

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
