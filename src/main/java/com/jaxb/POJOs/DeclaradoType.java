
package com.jaxb.POJOs;

import lombok.*;

import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Data of the declaration
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeclaradoType", propOrder = {
    "idRegistroDeclarado",
    "idDeclarado",
    "detalle"
})
public class DeclaradoType {

    @Getter
    @Setter
    @XmlElement(name = "IDRegistroDeclarado", required = true, namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
    protected String idRegistroDeclarado;

    @XmlElement(name = "IDDeclarado", required = true)
    protected List<DeclaradoType.IDDeclarado> idDeclarado;

    @Getter
    @Setter
    @XmlElement(name = "Detalle", required = true)
    protected DeclaradoType.Detalle detalle;

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
     */
    public List<DeclaradoType.IDDeclarado> getIDDeclarado() {
        if (idDeclarado == null) {
            idDeclarado = new ArrayList<DeclaradoType.IDDeclarado>();
        }
        return this.idDeclarado;
    }

    /**
     * Java class for anonymous complex type.
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

        @Getter
        @Setter
        @XmlElement(name = "IDInmueble", required = true)
        protected DeclaradoType.Detalle.IDInmueble idInmueble;

        @Getter
        @Setter
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
         *  Operation breakdown data
         * 
         * Java class for anonymous complex type.
         */
        @Data
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
             * Java class for anonymous complex type.
             */
            @Data
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

            }

            /**
             * Java class for anonymous complex type.
             */
            @Data
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

            }

        }

        /**
         *  Data of the assignee
         * 
         * Java class for anonymous complex type.
         */
        @Data
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

        }

        /**
         *  Property information
         */
        @Data
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
             * Java class for anonymous complex type.
             */
            @Data
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
                 * Java class for anonymous complex type.
                 */
                @Data
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

                }

            }

        }

    }

    /**
     *  Data of the declaration
     * 
     * Java class for anonymous complex type.
     */
    @Data
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

    }

}
