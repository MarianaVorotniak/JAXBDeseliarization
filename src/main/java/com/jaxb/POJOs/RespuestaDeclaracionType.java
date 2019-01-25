
package com.jaxb.POJOs;

import com.jaxb.Errors;
import com.jaxb.exceptions.ParseException;
import com.jaxb.interfaces.Responses;
import com.jaxb.services.MainService;
import com.jaxb.services.ParseService;

import java.math.BigInteger;
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
public class RespuestaDeclaracionType extends RespuestaComunAltaType implements Responses
{

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

    @Override
    public String getMessage() {
        String status = getEstadoEnvio().value();

        String message = "The status of registration/modification is [" + status + "]";

        if (!isAccepted(status)) {
            for (RespuestaOperacionesType lineResponse : getRespuestaLinea()) {
                BigInteger code = lineResponse.getCodigoErrorRegistro();
                String errorMessage = null;
                try {
                    errorMessage = Errors.findMessageByCode(code);
                } catch (ParseException e) {
                    message = "Unknown error code [" + code + "]";
                }

                message += "\nThe error is: code [" +  code + "], message [" + errorMessage + "]";
            }
        }
        return message;
    }

    public boolean isAccepted(String status) {
        return status.equals("Aceptacion Completa");
    }

}
