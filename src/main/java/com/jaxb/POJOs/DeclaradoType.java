
package com.jaxb.POJOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Datos correspondientes al Declarado 
 * 
 * <p>Java class for DeclaradoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeclaradoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IDRegistroDeclarado" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax20Type"/&gt;
 *         &lt;element name="IDDeclarado" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Clave" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}ClaveType"/&gt;
 *                   &lt;element name="NombreRazon" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax120Type"/&gt;
 *                   &lt;element name="NIFRepresentante" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}NIFType" minOccurs="0"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="NIF" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}NIFType"/&gt;
 *                     &lt;element name="IDOtro" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}IDOtroType"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Detalle"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="IDCesionario" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="NombreRazon" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax120Type"/&gt;
 *                             &lt;element name="NIFRepresentante" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}NIFType" minOccurs="0"/&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="NIF" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}NIFType"/&gt;
 *                               &lt;element name="IDOtro" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}IDOtroType"/&gt;
 *                             &lt;/choice&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="IDInmueble"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="SituacionInmueble" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}SituacionInmuebleType"/&gt;
 *                             &lt;element name="DatosInmueble"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="ReferenciaCatastral" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}ReferenciaCatastralType" minOccurs="0"/&gt;
 *                                       &lt;element name="Direccion"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="NombreMunicipio" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax30Type" minOccurs="0"/&gt;
 *                                                 &lt;element name="CodigoMunicipio" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type"/&gt;
 *                                                 &lt;element name="CodigoProvincia" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}CodigoProvinciaType"/&gt;
 *                                                 &lt;element name="TipoVia" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax5Type"/&gt;
 *                                                 &lt;element name="NombreVia" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax50Type"/&gt;
 *                                                 &lt;element name="TipoNumeracion" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TipoNumeracionType"/&gt;
 *                                                 &lt;element name="NumeroVivienda" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax5Type" minOccurs="0"/&gt;
 *                                                 &lt;element name="CalificadorNumero" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
 *                                                 &lt;element name="Bloque" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
 *                                                 &lt;element name="Portal" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
 *                                                 &lt;element name="Escalera" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
 *                                                 &lt;element name="PlantaPiso" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
 *                                                 &lt;element name="Puerta" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
 *                                                 &lt;element name="Complemento" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax40Type" minOccurs="0"/&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="DesgloseOperacion"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="PeriodoCesion"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="FechaIntermediacion" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}fecha" minOccurs="0"/&gt;
 *                                       &lt;element name="FechaInicioCesion" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}fecha"/&gt;
 *                                       &lt;element name="NumeroDiasDisfrute" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Importe" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}ImporteSgn12.2Type"/&gt;
 *                             &lt;element name="NumeroContrato" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax20Type" minOccurs="0"/&gt;
 *                             &lt;element name="MedioPago" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="ClaveMedioPago" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}MedioPagoType" minOccurs="0"/&gt;
 *                                       &lt;element name="IDMedioPago" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax30Type" minOccurs="0"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeclaradoType", propOrder = {
    "idRegistroDeclarado",
    "idDeclarado",
    "detalle"
})
public class DeclaradoType {

    @XmlElement(name = "IDRegistroDeclarado", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String idRegistroDeclarado;
    @XmlElement(name = "IDDeclarado", required = true)
    protected List<DeclaradoType.IDDeclarado> idDeclarado;
    @XmlElement(name = "Detalle", required = true)
    protected DeclaradoType.Detalle detalle;

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
     * Gets the value of the idDeclarado property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idDeclarado property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDDeclarado().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeclaradoType.IDDeclarado }
     * 
     * 
     */
    public List<DeclaradoType.IDDeclarado> getIDDeclarado() {
        if (idDeclarado == null) {
            idDeclarado = new ArrayList<DeclaradoType.IDDeclarado>();
        }
        return this.idDeclarado;
    }

    /**
     * Gets the value of the detalle property.
     * 
     * @return
     *     possible object is
     *     {@link DeclaradoType.Detalle }
     *     
     */
    public DeclaradoType.Detalle getDetalle() {
        return detalle;
    }

    /**
     * Sets the value of the detalle property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeclaradoType.Detalle }
     *     
     */
    public void setDetalle(DeclaradoType.Detalle value) {
        this.detalle = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="IDCesionario" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="NombreRazon" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax120Type"/&gt;
     *                   &lt;element name="NIFRepresentante" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}NIFType" minOccurs="0"/&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="NIF" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}NIFType"/&gt;
     *                     &lt;element name="IDOtro" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}IDOtroType"/&gt;
     *                   &lt;/choice&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="IDInmueble"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="SituacionInmueble" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}SituacionInmuebleType"/&gt;
     *                   &lt;element name="DatosInmueble"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="ReferenciaCatastral" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}ReferenciaCatastralType" minOccurs="0"/&gt;
     *                             &lt;element name="Direccion"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="NombreMunicipio" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax30Type" minOccurs="0"/&gt;
     *                                       &lt;element name="CodigoMunicipio" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type"/&gt;
     *                                       &lt;element name="CodigoProvincia" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}CodigoProvinciaType"/&gt;
     *                                       &lt;element name="TipoVia" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax5Type"/&gt;
     *                                       &lt;element name="NombreVia" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax50Type"/&gt;
     *                                       &lt;element name="TipoNumeracion" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TipoNumeracionType"/&gt;
     *                                       &lt;element name="NumeroVivienda" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax5Type" minOccurs="0"/&gt;
     *                                       &lt;element name="CalificadorNumero" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
     *                                       &lt;element name="Bloque" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
     *                                       &lt;element name="Portal" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
     *                                       &lt;element name="Escalera" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
     *                                       &lt;element name="PlantaPiso" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
     *                                       &lt;element name="Puerta" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
     *                                       &lt;element name="Complemento" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax40Type" minOccurs="0"/&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="DesgloseOperacion"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="PeriodoCesion"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="FechaIntermediacion" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}fecha" minOccurs="0"/&gt;
     *                             &lt;element name="FechaInicioCesion" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}fecha"/&gt;
     *                             &lt;element name="NumeroDiasDisfrute" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Importe" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}ImporteSgn12.2Type"/&gt;
     *                   &lt;element name="NumeroContrato" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax20Type" minOccurs="0"/&gt;
     *                   &lt;element name="MedioPago" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="ClaveMedioPago" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}MedioPagoType" minOccurs="0"/&gt;
     *                             &lt;element name="IDMedioPago" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax30Type" minOccurs="0"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "idCesionario",
        "idInmueble",
        "desgloseOperacion"
    })
    public static class Detalle {

        @XmlElement(name = "IDCesionario", required = true)
        protected List<DeclaradoType.Detalle.IDCesionario> idCesionario;
        @XmlElement(name = "IDInmueble", required = true)
        protected DeclaradoType.Detalle.IDInmueble idInmueble;
        @XmlElement(name = "DesgloseOperacion", required = true)
        protected DeclaradoType.Detalle.DesgloseOperacion desgloseOperacion;

        /**
         * Gets the value of the idCesionario property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the idCesionario property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIDCesionario().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DeclaradoType.Detalle.IDCesionario }
         * 
         * 
         */
        public List<DeclaradoType.Detalle.IDCesionario> getIDCesionario() {
            if (idCesionario == null) {
                idCesionario = new ArrayList<DeclaradoType.Detalle.IDCesionario>();
            }
            return this.idCesionario;
        }

        /**
         * Gets the value of the idInmueble property.
         * 
         * @return
         *     possible object is
         *     {@link DeclaradoType.Detalle.IDInmueble }
         *     
         */
        public DeclaradoType.Detalle.IDInmueble getIDInmueble() {
            return idInmueble;
        }

        /**
         * Sets the value of the idInmueble property.
         * 
         * @param value
         *     allowed object is
         *     {@link DeclaradoType.Detalle.IDInmueble }
         *     
         */
        public void setIDInmueble(DeclaradoType.Detalle.IDInmueble value) {
            this.idInmueble = value;
        }

        /**
         * Gets the value of the desgloseOperacion property.
         * 
         * @return
         *     possible object is
         *     {@link DeclaradoType.Detalle.DesgloseOperacion }
         *     
         */
        public DeclaradoType.Detalle.DesgloseOperacion getDesgloseOperacion() {
            return desgloseOperacion;
        }

        /**
         * Sets the value of the desgloseOperacion property.
         * 
         * @param value
         *     allowed object is
         *     {@link DeclaradoType.Detalle.DesgloseOperacion }
         *     
         */
        public void setDesgloseOperacion(DeclaradoType.Detalle.DesgloseOperacion value) {
            this.desgloseOperacion = value;
        }


        /**
         *  Datos del desglose operación 
         * 
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="PeriodoCesion"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="FechaIntermediacion" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}fecha" minOccurs="0"/&gt;
         *                   &lt;element name="FechaInicioCesion" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}fecha"/&gt;
         *                   &lt;element name="NumeroDiasDisfrute" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Importe" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}ImporteSgn12.2Type"/&gt;
         *         &lt;element name="NumeroContrato" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax20Type" minOccurs="0"/&gt;
         *         &lt;element name="MedioPago" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="ClaveMedioPago" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}MedioPagoType" minOccurs="0"/&gt;
         *                   &lt;element name="IDMedioPago" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax30Type" minOccurs="0"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "periodoCesion",
            "importe",
            "numeroContrato",
            "medioPago"
        })
        public static class DesgloseOperacion {

            @XmlElement(name = "PeriodoCesion", required = true)
            protected DeclaradoType.Detalle.DesgloseOperacion.PeriodoCesion periodoCesion;
            @XmlElement(name = "Importe", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
            protected String importe;
            @XmlElement(name = "NumeroContrato", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
            protected String numeroContrato;
            @XmlElement(name = "MedioPago")
            protected DeclaradoType.Detalle.DesgloseOperacion.MedioPago medioPago;

            /**
             * Gets the value of the periodoCesion property.
             * 
             * @return
             *     possible object is
             *     {@link DeclaradoType.Detalle.DesgloseOperacion.PeriodoCesion }
             *     
             */
            public DeclaradoType.Detalle.DesgloseOperacion.PeriodoCesion getPeriodoCesion() {
                return periodoCesion;
            }

            /**
             * Sets the value of the periodoCesion property.
             * 
             * @param value
             *     allowed object is
             *     {@link DeclaradoType.Detalle.DesgloseOperacion.PeriodoCesion }
             *     
             */
            public void setPeriodoCesion(DeclaradoType.Detalle.DesgloseOperacion.PeriodoCesion value) {
                this.periodoCesion = value;
            }

            /**
             * Gets the value of the importe property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getImporte() {
                return importe;
            }

            /**
             * Sets the value of the importe property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setImporte(String value) {
                this.importe = value;
            }

            /**
             * Gets the value of the numeroContrato property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNumeroContrato() {
                return numeroContrato;
            }

            /**
             * Sets the value of the numeroContrato property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNumeroContrato(String value) {
                this.numeroContrato = value;
            }

            /**
             * Gets the value of the medioPago property.
             * 
             * @return
             *     possible object is
             *     {@link DeclaradoType.Detalle.DesgloseOperacion.MedioPago }
             *     
             */
            public DeclaradoType.Detalle.DesgloseOperacion.MedioPago getMedioPago() {
                return medioPago;
            }

            /**
             * Sets the value of the medioPago property.
             * 
             * @param value
             *     allowed object is
             *     {@link DeclaradoType.Detalle.DesgloseOperacion.MedioPago }
             *     
             */
            public void setMedioPago(DeclaradoType.Detalle.DesgloseOperacion.MedioPago value) {
                this.medioPago = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="ClaveMedioPago" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}MedioPagoType" minOccurs="0"/&gt;
             *         &lt;element name="IDMedioPago" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax30Type" minOccurs="0"/&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "claveMedioPago",
                "idMedioPago"
            })
            public static class MedioPago {

                @XmlElement(name = "ClaveMedioPago", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                protected String claveMedioPago;
                @XmlElement(name = "IDMedioPago", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                protected String idMedioPago;

                /**
                 * Gets the value of the claveMedioPago property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getClaveMedioPago() {
                    return claveMedioPago;
                }

                /**
                 * Sets the value of the claveMedioPago property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setClaveMedioPago(String value) {
                    this.claveMedioPago = value;
                }

                /**
                 * Gets the value of the idMedioPago property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getIDMedioPago() {
                    return idMedioPago;
                }

                /**
                 * Sets the value of the idMedioPago property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setIDMedioPago(String value) {
                    this.idMedioPago = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="FechaIntermediacion" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}fecha" minOccurs="0"/&gt;
             *         &lt;element name="FechaInicioCesion" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}fecha"/&gt;
             *         &lt;element name="NumeroDiasDisfrute" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type"/&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "fechaIntermediacion",
                "fechaInicioCesion",
                "numeroDiasDisfrute"
            })
            public static class PeriodoCesion {

                @XmlElement(name = "FechaIntermediacion", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                protected String fechaIntermediacion;
                @XmlElement(name = "FechaInicioCesion", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                protected String fechaInicioCesion;
                @XmlElement(name = "NumeroDiasDisfrute", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                protected String numeroDiasDisfrute;

                /**
                 * Gets the value of the fechaIntermediacion property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFechaIntermediacion() {
                    return fechaIntermediacion;
                }

                /**
                 * Sets the value of the fechaIntermediacion property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFechaIntermediacion(String value) {
                    this.fechaIntermediacion = value;
                }

                /**
                 * Gets the value of the fechaInicioCesion property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFechaInicioCesion() {
                    return fechaInicioCesion;
                }

                /**
                 * Sets the value of the fechaInicioCesion property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFechaInicioCesion(String value) {
                    this.fechaInicioCesion = value;
                }

                /**
                 * Gets the value of the numeroDiasDisfrute property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNumeroDiasDisfrute() {
                    return numeroDiasDisfrute;
                }

                /**
                 * Sets the value of the numeroDiasDisfrute property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNumeroDiasDisfrute(String value) {
                    this.numeroDiasDisfrute = value;
                }

            }

        }


        /**
         *  Datos del cesionario 
         * 
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="NombreRazon" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax120Type"/&gt;
         *         &lt;element name="NIFRepresentante" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}NIFType" minOccurs="0"/&gt;
         *         &lt;choice&gt;
         *           &lt;element name="NIF" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}NIFType"/&gt;
         *           &lt;element name="IDOtro" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}IDOtroType"/&gt;
         *         &lt;/choice&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "nombreRazon",
            "nifRepresentante",
            "nif",
            "idOtro"
        })
        public static class IDCesionario {

            @XmlElement(name = "NombreRazon", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
            protected String nombreRazon;
            @XmlElement(name = "NIFRepresentante", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
            protected String nifRepresentante;
            @XmlElement(name = "NIF", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
            protected String nif;
            @XmlElement(name = "IDOtro", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
            protected IDOtroType idOtro;

            /**
             * Gets the value of the nombreRazon property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNombreRazon() {
                return nombreRazon;
            }

            /**
             * Sets the value of the nombreRazon property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNombreRazon(String value) {
                this.nombreRazon = value;
            }

            /**
             * Gets the value of the nifRepresentante property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNIFRepresentante() {
                return nifRepresentante;
            }

            /**
             * Sets the value of the nifRepresentante property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNIFRepresentante(String value) {
                this.nifRepresentante = value;
            }

            /**
             * Gets the value of the nif property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNIF() {
                return nif;
            }

            /**
             * Sets the value of the nif property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNIF(String value) {
                this.nif = value;
            }

            /**
             * Gets the value of the idOtro property.
             * 
             * @return
             *     possible object is
             *     {@link IDOtroType }
             *     
             */
            public IDOtroType getIDOtro() {
                return idOtro;
            }

            /**
             * Sets the value of the idOtro property.
             * 
             * @param value
             *     allowed object is
             *     {@link IDOtroType }
             *     
             */
            public void setIDOtro(IDOtroType value) {
                this.idOtro = value;
            }

        }


        /**
         *  Datos del inmueble 
         * 
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="SituacionInmueble" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}SituacionInmuebleType"/&gt;
         *         &lt;element name="DatosInmueble"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="ReferenciaCatastral" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}ReferenciaCatastralType" minOccurs="0"/&gt;
         *                   &lt;element name="Direccion"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="NombreMunicipio" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax30Type" minOccurs="0"/&gt;
         *                             &lt;element name="CodigoMunicipio" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type"/&gt;
         *                             &lt;element name="CodigoProvincia" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}CodigoProvinciaType"/&gt;
         *                             &lt;element name="TipoVia" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax5Type"/&gt;
         *                             &lt;element name="NombreVia" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax50Type"/&gt;
         *                             &lt;element name="TipoNumeracion" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TipoNumeracionType"/&gt;
         *                             &lt;element name="NumeroVivienda" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax5Type" minOccurs="0"/&gt;
         *                             &lt;element name="CalificadorNumero" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
         *                             &lt;element name="Bloque" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
         *                             &lt;element name="Portal" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
         *                             &lt;element name="Escalera" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
         *                             &lt;element name="PlantaPiso" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
         *                             &lt;element name="Puerta" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
         *                             &lt;element name="Complemento" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax40Type" minOccurs="0"/&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "situacionInmueble",
            "datosInmueble"
        })
        public static class IDInmueble {

            @XmlElement(name = "SituacionInmueble", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
            protected String situacionInmueble;
            @XmlElement(name = "DatosInmueble", required = true)
            protected DeclaradoType.Detalle.IDInmueble.DatosInmueble datosInmueble;

            /**
             * Gets the value of the situacionInmueble property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSituacionInmueble() {
                return situacionInmueble;
            }

            /**
             * Sets the value of the situacionInmueble property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSituacionInmueble(String value) {
                this.situacionInmueble = value;
            }

            /**
             * Gets the value of the datosInmueble property.
             * 
             * @return
             *     possible object is
             *     {@link DeclaradoType.Detalle.IDInmueble.DatosInmueble }
             *     
             */
            public DeclaradoType.Detalle.IDInmueble.DatosInmueble getDatosInmueble() {
                return datosInmueble;
            }

            /**
             * Sets the value of the datosInmueble property.
             * 
             * @param value
             *     allowed object is
             *     {@link DeclaradoType.Detalle.IDInmueble.DatosInmueble }
             *     
             */
            public void setDatosInmueble(DeclaradoType.Detalle.IDInmueble.DatosInmueble value) {
                this.datosInmueble = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="ReferenciaCatastral" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}ReferenciaCatastralType" minOccurs="0"/&gt;
             *         &lt;element name="Direccion"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="NombreMunicipio" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax30Type" minOccurs="0"/&gt;
             *                   &lt;element name="CodigoMunicipio" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type"/&gt;
             *                   &lt;element name="CodigoProvincia" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}CodigoProvinciaType"/&gt;
             *                   &lt;element name="TipoVia" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax5Type"/&gt;
             *                   &lt;element name="NombreVia" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax50Type"/&gt;
             *                   &lt;element name="TipoNumeracion" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TipoNumeracionType"/&gt;
             *                   &lt;element name="NumeroVivienda" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax5Type" minOccurs="0"/&gt;
             *                   &lt;element name="CalificadorNumero" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
             *                   &lt;element name="Bloque" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
             *                   &lt;element name="Portal" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
             *                   &lt;element name="Escalera" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
             *                   &lt;element name="PlantaPiso" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
             *                   &lt;element name="Puerta" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
             *                   &lt;element name="Complemento" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax40Type" minOccurs="0"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "referenciaCatastral",
                "direccion"
            })
            public static class DatosInmueble {

                @XmlElement(name = "ReferenciaCatastral", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                protected String referenciaCatastral;
                @XmlElement(name = "Direccion", required = true)
                protected DeclaradoType.Detalle.IDInmueble.DatosInmueble.Direccion direccion;

                /**
                 * Gets the value of the referenciaCatastral property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getReferenciaCatastral() {
                    return referenciaCatastral;
                }

                /**
                 * Sets the value of the referenciaCatastral property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setReferenciaCatastral(String value) {
                    this.referenciaCatastral = value;
                }

                /**
                 * Gets the value of the direccion property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link DeclaradoType.Detalle.IDInmueble.DatosInmueble.Direccion }
                 *     
                 */
                public DeclaradoType.Detalle.IDInmueble.DatosInmueble.Direccion getDireccion() {
                    return direccion;
                }

                /**
                 * Sets the value of the direccion property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link DeclaradoType.Detalle.IDInmueble.DatosInmueble.Direccion }
                 *     
                 */
                public void setDireccion(DeclaradoType.Detalle.IDInmueble.DatosInmueble.Direccion value) {
                    this.direccion = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="NombreMunicipio" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax30Type" minOccurs="0"/&gt;
                 *         &lt;element name="CodigoMunicipio" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type"/&gt;
                 *         &lt;element name="CodigoProvincia" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}CodigoProvinciaType"/&gt;
                 *         &lt;element name="TipoVia" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax5Type"/&gt;
                 *         &lt;element name="NombreVia" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax50Type"/&gt;
                 *         &lt;element name="TipoNumeracion" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TipoNumeracionType"/&gt;
                 *         &lt;element name="NumeroVivienda" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax5Type" minOccurs="0"/&gt;
                 *         &lt;element name="CalificadorNumero" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
                 *         &lt;element name="Bloque" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
                 *         &lt;element name="Portal" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
                 *         &lt;element name="Escalera" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
                 *         &lt;element name="PlantaPiso" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
                 *         &lt;element name="Puerta" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax3Type" minOccurs="0"/&gt;
                 *         &lt;element name="Complemento" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax40Type" minOccurs="0"/&gt;
                 *       &lt;/sequence&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "nombreMunicipio",
                    "codigoMunicipio",
                    "codigoProvincia",
                    "tipoVia",
                    "nombreVia",
                    "tipoNumeracion",
                    "numeroVivienda",
                    "calificadorNumero",
                    "bloque",
                    "portal",
                    "escalera",
                    "plantaPiso",
                    "puerta",
                    "complemento"
                })
                public static class Direccion {

                    @XmlElement(name = "NombreMunicipio", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                    protected String nombreMunicipio;
                    @XmlElement(name = "CodigoMunicipio", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                    protected String codigoMunicipio;
                    @XmlElement(name = "CodigoProvincia", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                    protected String codigoProvincia;
                    @XmlElement(name = "TipoVia", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                    protected String tipoVia;
                    @XmlElement(name = "NombreVia", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                    protected String nombreVia;
                    @XmlElement(name = "TipoNumeracion", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                    @XmlSchemaType(name = "string")
                    protected TipoNumeracionType tipoNumeracion;
                    @XmlElement(name = "NumeroVivienda", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                    protected String numeroVivienda;
                    @XmlElement(name = "CalificadorNumero", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                    protected String calificadorNumero;
                    @XmlElement(name = "Bloque", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                    protected String bloque;
                    @XmlElement(name = "Portal", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                    protected String portal;
                    @XmlElement(name = "Escalera", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                    protected String escalera;
                    @XmlElement(name = "PlantaPiso", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                    protected String plantaPiso;
                    @XmlElement(name = "Puerta", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                    protected String puerta;
                    @XmlElement(name = "Complemento", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
                    protected String complemento;

                    /**
                     * Gets the value of the nombreMunicipio property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNombreMunicipio() {
                        return nombreMunicipio;
                    }

                    /**
                     * Sets the value of the nombreMunicipio property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNombreMunicipio(String value) {
                        this.nombreMunicipio = value;
                    }

                    /**
                     * Gets the value of the codigoMunicipio property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCodigoMunicipio() {
                        return codigoMunicipio;
                    }

                    /**
                     * Sets the value of the codigoMunicipio property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCodigoMunicipio(String value) {
                        this.codigoMunicipio = value;
                    }

                    /**
                     * Gets the value of the codigoProvincia property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCodigoProvincia() {
                        return codigoProvincia;
                    }

                    /**
                     * Sets the value of the codigoProvincia property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCodigoProvincia(String value) {
                        this.codigoProvincia = value;
                    }

                    /**
                     * Gets the value of the tipoVia property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTipoVia() {
                        return tipoVia;
                    }

                    /**
                     * Sets the value of the tipoVia property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTipoVia(String value) {
                        this.tipoVia = value;
                    }

                    /**
                     * Gets the value of the nombreVia property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNombreVia() {
                        return nombreVia;
                    }

                    /**
                     * Sets the value of the nombreVia property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNombreVia(String value) {
                        this.nombreVia = value;
                    }

                    /**
                     * Gets the value of the tipoNumeracion property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link TipoNumeracionType }
                     *     
                     */
                    public TipoNumeracionType getTipoNumeracion() {
                        return tipoNumeracion;
                    }

                    /**
                     * Sets the value of the tipoNumeracion property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link TipoNumeracionType }
                     *     
                     */
                    public void setTipoNumeracion(TipoNumeracionType value) {
                        this.tipoNumeracion = value;
                    }

                    /**
                     * Gets the value of the numeroVivienda property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNumeroVivienda() {
                        return numeroVivienda;
                    }

                    /**
                     * Sets the value of the numeroVivienda property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNumeroVivienda(String value) {
                        this.numeroVivienda = value;
                    }

                    /**
                     * Gets the value of the calificadorNumero property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCalificadorNumero() {
                        return calificadorNumero;
                    }

                    /**
                     * Sets the value of the calificadorNumero property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCalificadorNumero(String value) {
                        this.calificadorNumero = value;
                    }

                    /**
                     * Gets the value of the bloque property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getBloque() {
                        return bloque;
                    }

                    /**
                     * Sets the value of the bloque property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setBloque(String value) {
                        this.bloque = value;
                    }

                    /**
                     * Gets the value of the portal property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getPortal() {
                        return portal;
                    }

                    /**
                     * Sets the value of the portal property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setPortal(String value) {
                        this.portal = value;
                    }

                    /**
                     * Gets the value of the escalera property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getEscalera() {
                        return escalera;
                    }

                    /**
                     * Sets the value of the escalera property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setEscalera(String value) {
                        this.escalera = value;
                    }

                    /**
                     * Gets the value of the plantaPiso property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getPlantaPiso() {
                        return plantaPiso;
                    }

                    /**
                     * Sets the value of the plantaPiso property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setPlantaPiso(String value) {
                        this.plantaPiso = value;
                    }

                    /**
                     * Gets the value of the puerta property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getPuerta() {
                        return puerta;
                    }

                    /**
                     * Sets the value of the puerta property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setPuerta(String value) {
                        this.puerta = value;
                    }

                    /**
                     * Gets the value of the complemento property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getComplemento() {
                        return complemento;
                    }

                    /**
                     * Sets the value of the complemento property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setComplemento(String value) {
                        this.complemento = value;
                    }

                }

            }

        }

    }


    /**
     *  Datos del declarado 
     * 
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Clave" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}ClaveType"/&gt;
     *         &lt;element name="NombreRazon" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax120Type"/&gt;
     *         &lt;element name="NIFRepresentante" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}NIFType" minOccurs="0"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="NIF" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}NIFType"/&gt;
     *           &lt;element name="IDOtro" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}IDOtroType"/&gt;
     *         &lt;/choice&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "clave",
        "nombreRazon",
        "nifRepresentante",
        "nif",
        "idOtro"
    })
    public static class IDDeclarado {

        @XmlElement(name = "Clave", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
        @XmlSchemaType(name = "string")
        protected ClaveType clave;
        @XmlElement(name = "NombreRazon", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
        protected String nombreRazon;
        @XmlElement(name = "NIFRepresentante", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
        protected String nifRepresentante;
        @XmlElement(name = "NIF", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
        protected String nif;
        @XmlElement(name = "IDOtro", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
        protected IDOtroType idOtro;

        /**
         * Gets the value of the clave property.
         * 
         * @return
         *     possible object is
         *     {@link ClaveType }
         *     
         */
        public ClaveType getClave() {
            return clave;
        }

        /**
         * Sets the value of the clave property.
         * 
         * @param value
         *     allowed object is
         *     {@link ClaveType }
         *     
         */
        public void setClave(ClaveType value) {
            this.clave = value;
        }

        /**
         * Gets the value of the nombreRazon property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNombreRazon() {
            return nombreRazon;
        }

        /**
         * Sets the value of the nombreRazon property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNombreRazon(String value) {
            this.nombreRazon = value;
        }

        /**
         * Gets the value of the nifRepresentante property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNIFRepresentante() {
            return nifRepresentante;
        }

        /**
         * Sets the value of the nifRepresentante property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNIFRepresentante(String value) {
            this.nifRepresentante = value;
        }

        /**
         * Gets the value of the nif property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNIF() {
            return nif;
        }

        /**
         * Sets the value of the nif property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNIF(String value) {
            this.nif = value;
        }

        /**
         * Gets the value of the idOtro property.
         * 
         * @return
         *     possible object is
         *     {@link IDOtroType }
         *     
         */
        public IDOtroType getIDOtro() {
            return idOtro;
        }

        /**
         * Sets the value of the idOtro property.
         * 
         * @param value
         *     allowed object is
         *     {@link IDOtroType }
         *     
         */
        public void setIDOtro(IDOtroType value) {
            this.idOtro = value;
        }

    }

}
