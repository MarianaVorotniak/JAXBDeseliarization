
package com.jaxb.POJOs;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 *  Respuesta a un envío Ddii 
 * 
 * <p>Java class for RespuestaOperacionesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RespuestaOperacionesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IDRegistroDeclarado" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax20Type"/&gt;
 *         &lt;element name="EstadoRegistro" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd}EstadoRegistroType"/&gt;
 *         &lt;element name="CodigoErrorRegistro" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd}ErrorDetalleType" minOccurs="0"/&gt;
 *         &lt;element name="DescripcionErrorRegistro" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax500Type" minOccurs="0"/&gt;
 *         &lt;element name="CSV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaOperacionesType", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd", propOrder = {
    "idRegistroDeclarado",
    "estadoRegistro",
    "codigoErrorRegistro",
    "descripcionErrorRegistro",
    "csv"
})
public class RespuestaOperacionesType {

    @XmlElement(name = "IDRegistroDeclarado", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String idRegistroDeclarado;
    @XmlElement(name = "EstadoRegistro", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    @XmlSchemaType(name = "string")
    protected EstadoRegistroType estadoRegistro;
    @XmlElement(name = "CodigoErrorRegistro", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    protected BigInteger codigoErrorRegistro;
    @XmlElement(name = "DescripcionErrorRegistro", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String descripcionErrorRegistro;
    @XmlElement(name = "CSV")
    protected String csv;

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

    /**
     * Gets the value of the estadoRegistro property.
     * 
     * @return
     *     possible object is
     *     {@link EstadoRegistroType }
     *     
     */
    public EstadoRegistroType getEstadoRegistro() {
        return estadoRegistro;
    }

    /**
     * Sets the value of the estadoRegistro property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoRegistroType }
     *     
     */
    public void setEstadoRegistro(EstadoRegistroType value) {
        this.estadoRegistro = value;
    }

    /**
     * Gets the value of the codigoErrorRegistro property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodigoErrorRegistro() {
        return codigoErrorRegistro;
    }

    /**
     * Sets the value of the codigoErrorRegistro property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodigoErrorRegistro(BigInteger value) {
        this.codigoErrorRegistro = value;
    }

    /**
     * Gets the value of the descripcionErrorRegistro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionErrorRegistro() {
        return descripcionErrorRegistro;
    }

    /**
     * Sets the value of the descripcionErrorRegistro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionErrorRegistro(String value) {
        this.descripcionErrorRegistro = value;
    }

    /**
     * Gets the value of the csv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSV() {
        return csv;
    }

    /**
     * Sets the value of the csv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSV(String value) {
        this.csv = value;
    }

}
