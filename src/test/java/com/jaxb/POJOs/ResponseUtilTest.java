package com.jaxb.POJOs;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ResponseUtilTest {

    @Mock
    private RespuestaDeclaracionType respuestaDeclaracionType;
    @Mock
    private List<RespuestaOperacionesType> respuestaLinea;
    @Mock
    private static ResponseUtil responseUtil;
    @Mock
    private static Fault fault;

    @Before
    public void init() {
        respuestaDeclaracionType = new RespuestaDeclaracionType();
        respuestaDeclaracionType.setEstadoEnvio(EstadoEnvioType.ACEPTACION_PARCIAL);

        RespuestaOperacionesType respuestaOperacionesTypeRejected = new RespuestaOperacionesType();
        respuestaOperacionesTypeRejected.setIdRegistroDeclarado("206");
        respuestaOperacionesTypeRejected.setDescripcionErrorRegistro("El NIF no esta identificado. NIF Cedente: 50874160T. NOMBRE_RAZON: Michelle 'Chelle' Taylor. ");
        respuestaOperacionesTypeRejected.setCodigoErrorRegistro(BigInteger.valueOf(1106));
        respuestaOperacionesTypeRejected.setEstadoRegistro(EstadoRegistroType.RECHAZADO);

        RespuestaOperacionesType respuestaOperacionesTypeAccepted = new RespuestaOperacionesType();
        respuestaOperacionesTypeAccepted.setIdRegistroDeclarado("206");
        respuestaOperacionesTypeAccepted.setEstadoRegistro(EstadoRegistroType.ACEPTADO);

        respuestaLinea = new ArrayList<>();
        respuestaLinea.add(respuestaOperacionesTypeRejected);
        respuestaLinea.add(respuestaOperacionesTypeAccepted);

        respuestaDeclaracionType.getRespuestaLinea().add(respuestaLinea.get(0));
        respuestaDeclaracionType.getRespuestaLinea().add(respuestaLinea.get(1));

        fault = new Fault();

        fault.setFaultstring("Codigo[4105].Error en la cabecera. El NIF del declarante es inválido. NIF:B98156129. NOMBRE_RAZON:HomeAway");
        fault.setFaultcode("env:Client");
    }

    @Test
    public void getMessageTest() {
        Object faultOb = fault;
        Object responseOb = respuestaDeclaracionType;

        String messageFault = responseUtil.getMessage(faultOb);
        assertTrue(messageFault.contains("Cause of the Fault response - [" + fault.getFaultstring() + "]"));

        String messageResponse = responseUtil.getMessage(responseOb);
        assertTrue(messageResponse.contains("The status of registration/modification is [Aceptacion Parcial]."));
        assertTrue(messageResponse.contains("El NIF no esta identificado. NIF Cedente: 50874160T. NOMBRE_RAZON: Michelle 'Chelle' Taylor. "));
    }

}
