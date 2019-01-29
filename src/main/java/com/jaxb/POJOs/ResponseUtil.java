package com.jaxb.POJOs;

import com.jaxb.Errors;
import com.jaxb.exceptions.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

public class ResponseUtil{

    private static Logger LOGGER = LoggerFactory.getLogger(ResponseUtil.class);

    public static String getMessage(Object objectResponse) {
        if (objectResponse.getClass() == Fault.class)
            return getMessage((Fault)objectResponse);
        return getMessage((RespuestaDeclaracionType)objectResponse);
    }

    public static String getMessage(Fault fault) {
        return "Cause of the Fault response - [" + fault.getFaultstring() + "]";
    }

    public static String getMessage(RespuestaDeclaracionType response){
        String status = response.getEstadoEnvio().value();

        String message = "The status of registration/modification is [" + status + "]\n";

        if (!isAccepted(status)) {
            for (RespuestaOperacionesType lineResponse : response.getRespuestaLinea())
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
       return message;
    }

    public static String getFinalErrorMessage(String errorMessage, RespuestaOperacionesType lineResponse) {
        if (errorMessage == null)
            return "\nUnknown error code [" + lineResponse.getCodigoErrorRegistro() + "], message: " + lineResponse.getDescripcionErrorRegistro() + ", DeclarationID: " + lineResponse.getIdRegistroDeclarado() + "\n";

        return "\nThe error is: code [" + lineResponse.getCodigoErrorRegistro() + "], message: " + errorMessage + " (" + lineResponse.getDescripcionErrorRegistro() + "), DeclarationID: " + lineResponse.getIdRegistroDeclarado() + "\n";
    }

    public static boolean isAccepted(String status) {
        return status.equals("Aceptacion Completa");
    }

    public static boolean isLineResponseRejected(RespuestaOperacionesType lineResponse) {
        return lineResponse.getEstadoRegistro() == EstadoRegistroType.RECHAZADO;
    }

}
