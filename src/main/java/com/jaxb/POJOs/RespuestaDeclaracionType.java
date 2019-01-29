package com.jaxb.POJOs;

import java.util.*;
import javax.xml.bind.annotation.*;

/**
 *  Response of sending Ddii
 * 
 * Java class for RespuestaDeclaracionType complex type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaDeclaracionType", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd", propOrder = {
    "respuestaLinea"
})
public class RespuestaDeclaracionType extends RespuestaComunAltaType {

    @XmlElement(name = "RespuestaLinea", namespace = "https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd")
    protected List<RespuestaOperacionesType> respuestaLinea;

    /**
     * Gets the value of the respuestaLinea property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the respuestaLinea property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRespuestaLinea().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RespuestaOperacionesType }
     */
    public List<RespuestaOperacionesType> getRespuestaLinea() {
        if (respuestaLinea == null) {
            respuestaLinea = new ArrayList<>();
        }
        return this.respuestaLinea;
    }

}
