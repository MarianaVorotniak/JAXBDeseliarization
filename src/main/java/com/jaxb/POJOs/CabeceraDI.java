
package com.jaxb.POJOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 *  Datos de contexto de un suministro 
 * 
 * <p>Java class for CabeceraDI complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CabeceraDI"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TipoComunicacion" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}ClaveTipoComunicacionType"/&gt;
 *         &lt;element name="Modelo" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}ModeloType"/&gt;
 *         &lt;element name="Periodo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Ejercicio" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}YearType"/&gt;
 *                   &lt;element name="Periodo" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TipoPeriodoType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="IDVersionModelo" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}VersionModeloType"/&gt;
 *         &lt;element name="IDDeclarante"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="NIF" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}NIFType"/&gt;
 *                   &lt;element name="NombreRazon" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax120Type"/&gt;
 *                   &lt;element name="NIFRepresentante" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}NIFType" minOccurs="0"/&gt;
 *                   &lt;element name="PersonaContacto" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Telefono" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax12Type"/&gt;
 *                             &lt;element name="ApellidosNombre" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax120Type"/&gt;
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
@XmlType(name = "CabeceraDI", propOrder = {
    "tipoComunicacion",
    "modelo",
    "periodo",
    "idVersionModelo",
    "idDeclarante"
})
public class CabeceraDI {

    @XmlElement(name = "TipoComunicacion", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    @XmlSchemaType(name = "string")
    protected ClaveTipoComunicacionType tipoComunicacion;
    @XmlElement(name = "Modelo", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String modelo;
    @XmlElement(name = "Periodo", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected CabeceraDI.Periodo periodo;
    @XmlElement(name = "IDVersionModelo", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String idVersionModelo;
    @XmlElement(name = "IDDeclarante", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected CabeceraDI.IDDeclarante idDeclarante;

    /**
     * Gets the value of the tipoComunicacion property.
     * 
     * @return
     *     possible object is
     *     {@link ClaveTipoComunicacionType }
     *     
     */
    public ClaveTipoComunicacionType getTipoComunicacion() {
        return tipoComunicacion;
    }

    /**
     * Sets the value of the tipoComunicacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClaveTipoComunicacionType }
     *     
     */
    public void setTipoComunicacion(ClaveTipoComunicacionType value) {
        this.tipoComunicacion = value;
    }

    /**
     * Gets the value of the modelo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Sets the value of the modelo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelo(String value) {
        this.modelo = value;
    }

    /**
     * Gets the value of the periodo property.
     * 
     * @return
     *     possible object is
     *     {@link CabeceraDI.Periodo }
     *     
     */
    public CabeceraDI.Periodo getPeriodo() {
        return periodo;
    }

    /**
     * Sets the value of the periodo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CabeceraDI.Periodo }
     *     
     */
    public void setPeriodo(CabeceraDI.Periodo value) {
        this.periodo = value;
    }

    /**
     * Gets the value of the idVersionModelo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDVersionModelo() {
        return idVersionModelo;
    }

    /**
     * Sets the value of the idVersionModelo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDVersionModelo(String value) {
        this.idVersionModelo = value;
    }

    /**
     * Gets the value of the idDeclarante property.
     * 
     * @return
     *     possible object is
     *     {@link CabeceraDI.IDDeclarante }
     *     
     */
    public CabeceraDI.IDDeclarante getIDDeclarante() {
        return idDeclarante;
    }

    /**
     * Sets the value of the idDeclarante property.
     * 
     * @param value
     *     allowed object is
     *     {@link CabeceraDI.IDDeclarante }
     *     
     */
    public void setIDDeclarante(CabeceraDI.IDDeclarante value) {
        this.idDeclarante = value;
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
     *         &lt;element name="NIF" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}NIFType"/&gt;
     *         &lt;element name="NombreRazon" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax120Type"/&gt;
     *         &lt;element name="NIFRepresentante" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}NIFType" minOccurs="0"/&gt;
     *         &lt;element name="PersonaContacto" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Telefono" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax12Type"/&gt;
     *                   &lt;element name="ApellidosNombre" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax120Type"/&gt;
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
        "nif",
        "nombreRazon",
        "nifRepresentante",
        "personaContacto"
    })
    public static class IDDeclarante {

        @XmlElement(name = "NIF", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
        protected String nif;
        @XmlElement(name = "NombreRazon", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
        protected String nombreRazon;
        @XmlElement(name = "NIFRepresentante", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
        protected String nifRepresentante;
        @XmlElement(name = "PersonaContacto")
        protected CabeceraDI.IDDeclarante.PersonaContacto personaContacto;

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
         * Gets the value of the personaContacto property.
         * 
         * @return
         *     possible object is
         *     {@link CabeceraDI.IDDeclarante.PersonaContacto }
         *     
         */
        public CabeceraDI.IDDeclarante.PersonaContacto getPersonaContacto() {
            return personaContacto;
        }

        /**
         * Sets the value of the personaContacto property.
         * 
         * @param value
         *     allowed object is
         *     {@link CabeceraDI.IDDeclarante.PersonaContacto }
         *     
         */
        public void setPersonaContacto(CabeceraDI.IDDeclarante.PersonaContacto value) {
            this.personaContacto = value;
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
         *         &lt;element name="Telefono" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax12Type"/&gt;
         *         &lt;element name="ApellidosNombre" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TextMax120Type"/&gt;
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
            "telefono",
            "apellidosNombre"
        })
        public static class PersonaContacto {

            @XmlElement(name = "Telefono", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
            protected String telefono;
            @XmlElement(name = "ApellidosNombre", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
            protected String apellidosNombre;

            /**
             * Gets the value of the telefono property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTelefono() {
                return telefono;
            }

            /**
             * Sets the value of the telefono property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTelefono(String value) {
                this.telefono = value;
            }

            /**
             * Gets the value of the apellidosNombre property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getApellidosNombre() {
                return apellidosNombre;
            }

            /**
             * Sets the value of the apellidosNombre property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setApellidosNombre(String value) {
                this.apellidosNombre = value;
            }

        }

    }


    /**
     *  Período al que corresponden los apuntes. todos los apuntes deben corresponder al mismo período impositivo 
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
     *         &lt;element name="Ejercicio" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}YearType"/&gt;
     *         &lt;element name="Periodo" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd}TipoPeriodoType"/&gt;
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
        "ejercicio",
        "periodo"
    })
    public static class Periodo {

        @XmlElement(name = "Ejercicio", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
        protected String ejercicio;
        @XmlElement(name = "Periodo", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
        protected String periodo;

        /**
         * Gets the value of the ejercicio property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEjercicio() {
            return ejercicio;
        }

        /**
         * Sets the value of the ejercicio property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEjercicio(String value) {
            this.ejercicio = value;
        }

        /**
         * Gets the value of the periodo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPeriodo() {
            return periodo;
        }

        /**
         * Sets the value of the periodo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPeriodo(String value) {
            this.periodo = value;
        }

    }

}
