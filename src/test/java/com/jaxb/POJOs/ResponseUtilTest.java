package com.jaxb.POJOs;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ResponseUtilTest {

    @InjectMocks
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
    public void getMessageByObj() {
        Object faultOb = fault;
        Object responseOb = respuestaDeclaracionType;

        String messageFault = responseUtil.getMessage(faultOb);
        assertTrue(messageFault.contains("Cause of the Fault response - [" + fault.getFaultstring() + "]"));

        String messageResponse = responseUtil.getMessage(responseOb);
        assertTrue(messageResponse.contains("The status of registration/modification is [" + respuestaDeclaracionType.getEstadoEnvio().value() + "]\n"));
        assertTrue(messageResponse.contains("El NIF no esta identificado. NIF Cedente: 50874160T. NOMBRE_RAZON: Michelle 'Chelle' Taylor. "));
    }

    @Test
    public void getMessageTest() {
        String message = responseUtil.getMessage(respuestaDeclaracionType);

        assertTrue(message.contains("The status of registration/modification is [" + respuestaDeclaracionType.getEstadoEnvio().value() + "]\n"));
        assertTrue(message.contains("El NIF no esta identificado. NIF Cedente: 50874160T. NOMBRE_RAZON: Michelle 'Chelle' Taylor. "));
    }

    @Test
    public void getFinalErrorMessageTest() {
        RespuestaOperacionesType firstElemOfList = respuestaLinea.get(0);
        String finalMessageWithNull = responseUtil.getFinalErrorMessage(null, firstElemOfList);
        assertEquals(finalMessageWithNull, "\nUnknown error code [" + firstElemOfList.getCodigoErrorRegistro() + "], message: " + firstElemOfList.getDescripcionErrorRegistro() + ", DeclarationID: " + firstElemOfList.getIdRegistroDeclarado() + "\n");

        String finalMessage = responseUtil.getFinalErrorMessage("", firstElemOfList);
        assertEquals(finalMessage, "\nThe error is: code [" + firstElemOfList.getCodigoErrorRegistro() + "], message: " + "" + " (" + firstElemOfList.getDescripcionErrorRegistro() + "), DeclarationID: " + firstElemOfList.getIdRegistroDeclarado() + "\n");
    }

    @Test
    public void isAcceptedTest() {
        String status = respuestaDeclaracionType.getEstadoEnvio().value();
        boolean isAccepted = responseUtil.isAccepted(status);
        assertEquals(false, isAccepted);
    }

    @Test
    public void isLineResponseRejectedTest() {
        boolean isRejected = responseUtil.isLineResponseRejected(respuestaLinea.get(0));
        assertEquals(true, isRejected);
    }

    @Test
    public void getFaultMessageTest() {
        String message = responseUtil.getMessage(fault);
        assertEquals(message, "Cause of the Fault response - [" + fault.getFaultstring() + "]");
    }

}