package com.jaxb.POJOs;

import com.jaxb.Errors;

import java.math.BigInteger;

public class ResponseUtil{

    public static String getMessage(Object objectResponse) {
        if (objectResponse instanceof Fault)
            return getMessage((Fault)objectResponse);
        return getMessage((RespuestaDeclaracionType)objectResponse);
    }

    private static String getMessage(Fault fault) {
        if (isFaultStringNotEmpty(fault))
            return "Cause of the Fault response - [" + fault.getFaultstring() + "]";
        else if (isFaultDetailNotNull(fault))
            return "Cause of the Fault response - [" + fault.getDetail().getCallstack() + "]";
        return "Fault code is " + fault.getFaultcode();
    }

    private static boolean isFaultStringNotEmpty(Fault fault) {
        return !fault.getFaultstring().equals("");
    }

    private static boolean isFaultDetailNotNull(Fault fault) {
        return fault.getDetail().getCallstack() != null;
    }

    private static String getMessage(RespuestaDeclaracionType response){
        String status = response.getEstadoEnvio().value();

        StringBuilder message = new StringBuilder();
        message.append("The status of registration/modification is [" + status + "]. Quantity of responses - " + response.getRespuestaLinea().size() + "\n");

            for (RespuestaOperacionesType lineResponse : response.getRespuestaLinea()) {
                message.append("\nIDRegistroDeclarado [" + lineResponse.getIdRegistroDeclarado() + "], EstadoRegistro [" + lineResponse.getEstadoRegistro() + "]");
                if (isLineResponseRejected(lineResponse)) {
                    BigInteger code = lineResponse.getCodigoErrorRegistro();
                    message.append(Errors.findMessageByCode(code));
                    message.append(", spanish message: " + lineResponse.getDescripcionErrorRegistro());
                }
            }

       return message.toString();
    }

    private static boolean isLineResponseRejected(RespuestaOperacionesType lineResponse) {
        return lineResponse.getEstadoRegistro() == EstadoRegistroType.RECHAZADO;
    }

}
