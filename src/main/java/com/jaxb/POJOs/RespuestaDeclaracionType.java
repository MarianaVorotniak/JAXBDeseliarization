
package com.jaxb.POJOs;

import com.jaxb.Errors;
import com.jaxb.exceptions.ParseException;
import com.jaxb.interfaces.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class RespuestaDeclaracionType extends RespuestaComunAltaType implements Message
{

    private static Logger LOGGER = LoggerFactory.getLogger(RespuestaDeclaracionType.class);

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
    public void getMessage(){
        String status = getEstadoEnvio().value();

        String message = "The status of registration/modification is [" + status + "]\n";

        if (!isAccepted(status)) {
            for (RespuestaOperacionesType lineResponse : getRespuestaLinea())
                if (isLineResponseRejected(lineResponse)) {
                    BigInteger code = lineResponse.getCodigoErrorRegistro();
                    String errorMessage = null;
                    try {
                        errorMessage = Errors.findMessageByCode(code);
                    } catch (ParseException e) {
                        LOGGER.warn("Problem while finding message for code [" + code + "]");
                    }
                    message += getFinalErrorMessage(errorMessage, lineResponse);
                }
        }
       LOGGER.info(message);
    }

    private String getFinalErrorMessage(String errorMessage, RespuestaOperacionesType lineResponse) {
        if (errorMessage == null)
            return "\nUnknown error code [" + lineResponse.getCodigoErrorRegistro() + "], message: " + lineResponse.getDescripcionErrorRegistro() + ", DeclarationID: " + lineResponse.getIdRegistroDeclarado() + "\n";

        return "\nThe error is: code [" + lineResponse.getCodigoErrorRegistro() + "], message: " + errorMessage + " (" + lineResponse.getDescripcionErrorRegistro() + "), DeclarationID: " + lineResponse.getIdRegistroDeclarado() + "\n";
    }

    private boolean isAccepted(String status) {
        return status.equals("Aceptacion Completa");
    }

    private boolean isLineResponseRejected(RespuestaOperacionesType lineResponse) {
        return lineResponse.getEstadoRegistro() == EstadoRegistroType.RECHAZADO;
    }

}
