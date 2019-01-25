
package com.jaxb.POJOs;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * Context data of a supply
 * 
 * Java class for CabeceraDI complex type.
 */
@Data
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
     * Java class for anonymous complex type.
     */
    @Data
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
         * Java class for anonymous complex type.
         */
        @Data
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

        }

    }

    /**
     *  Period to which the notes correspond. All the notes must correspond to the same tax period
     * 
     * Java class for anonymous complex type.
     */
    @Data
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

    }

}
