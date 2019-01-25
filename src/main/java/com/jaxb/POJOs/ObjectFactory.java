
package com.jaxb.POJOs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.jaxb.POJOs package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RespuestaDeclaracion_QNAME = new QName("https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd", "RespuestaDeclaracion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.jaxb.POJOs
     */
    public ObjectFactory() {
    }

    public DeclaradoType createDeclaradoType() {
        return new DeclaradoType();
    }

    public DeclaradoType.Detalle createDeclaradoTypeDetalle() {
        return new DeclaradoType.Detalle();
    }

    public DeclaradoType.Detalle.DesgloseOperacion createDeclaradoTypeDetalleDesgloseOperacion() {
        return new DeclaradoType.Detalle.DesgloseOperacion();
    }

    public DeclaradoType.Detalle.IDInmueble createDeclaradoTypeDetalleIDInmueble() {
        return new DeclaradoType.Detalle.IDInmueble();
    }

    public DeclaradoType.Detalle.IDInmueble.DatosInmueble createDeclaradoTypeDetalleIDInmuebleDatosInmueble() {
        return new DeclaradoType.Detalle.IDInmueble.DatosInmueble();
    }

    public CabeceraDI createCabeceraDI() {
        return new CabeceraDI();
    }

    public CabeceraDI.IDDeclarante createCabeceraDIIDDeclarante() {
        return new CabeceraDI.IDDeclarante();
    }

    public DeclaracionInformativa createDeclaracionInformativa() {
        return new DeclaracionInformativa();
    }

    public DeclaradoType2 createDeclaradoType2() {
        return new DeclaradoType2();
    }

    public DatosPresentacionType createDatosPresentacionType() {
        return new DatosPresentacionType();
    }

    public DatosPresentacion2Type createDatosPresentacion2Type() {
        return new DatosPresentacion2Type();
    }

    public PersonaFisicaJuridicaESType createPersonaFisicaJuridicaESType() {
        return new PersonaFisicaJuridicaESType();
    }

    public PersonaFisicaJuridicaUnicaESType createPersonaFisicaJuridicaUnicaESType() {
        return new PersonaFisicaJuridicaUnicaESType();
    }

    public PersonaFisicaJuridicaType createPersonaFisicaJuridicaType() {
        return new PersonaFisicaJuridicaType();
    }

    public IDOtroType createIDOtroType() {
        return new IDOtroType();
    }

    public RespuestaDeclaracionType createRespuestaDeclaracionType() {
        return new RespuestaDeclaracionType();
    }

    public RespuestaComunAltaType createRespuestaComunAltaType() {
        return new RespuestaComunAltaType();
    }

    public RespuestaOperacionesType createRespuestaOperacionesType() {
        return new RespuestaOperacionesType();
    }

    public DeclaradoType.IDDeclarado createDeclaradoTypeIDDeclarado() {
        return new DeclaradoType.IDDeclarado();
    }

    public DeclaradoType.Detalle.IDCesionario createDeclaradoTypeDetalleIDCesionario() {
        return new DeclaradoType.Detalle.IDCesionario();
    }

    public DeclaradoType.Detalle.DesgloseOperacion.PeriodoCesion createDeclaradoTypeDetalleDesgloseOperacionPeriodoCesion() {
        return new DeclaradoType.Detalle.DesgloseOperacion.PeriodoCesion();
    }

    public DeclaradoType.Detalle.DesgloseOperacion.MedioPago createDeclaradoTypeDetalleDesgloseOperacionMedioPago() {
        return new DeclaradoType.Detalle.DesgloseOperacion.MedioPago();
    }

    public DeclaradoType.Detalle.IDInmueble.DatosInmueble.Direccion createDeclaradoTypeDetalleIDInmuebleDatosInmuebleDireccion() {
        return new DeclaradoType.Detalle.IDInmueble.DatosInmueble.Direccion();
    }

    public CabeceraDI.Periodo createCabeceraDIPeriodo() {
        return new CabeceraDI.Periodo();
    }

    public CabeceraDI.IDDeclarante.PersonaContacto createCabeceraDIIDDeclarantePersonaContacto() {
        return new CabeceraDI.IDDeclarante.PersonaContacto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaDeclaracionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RespuestaDeclaracionType }{@code >}
     */
    @XmlElementDecl(namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd", name = "RespuestaDeclaracion")
    public JAXBElement<RespuestaDeclaracionType> createRespuestaDeclaracion(RespuestaDeclaracionType value) {
        return new JAXBElement<RespuestaDeclaracionType>(_RespuestaDeclaracion_QNAME, RespuestaDeclaracionType.class, null, value);
    }

}
