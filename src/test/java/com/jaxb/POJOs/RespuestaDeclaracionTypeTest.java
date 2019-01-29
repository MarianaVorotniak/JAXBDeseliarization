package com.jaxb.POJOs;

import org.apache.log4j.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class RespuestaDeclaracionTypeTest {

    @InjectMocks
    private RespuestaDeclaracionType respuestaDeclaracionType;

    @Mock
    private List<RespuestaOperacionesType> respuestaLinea;

    @Mock
    private Appender mockAppender;

    private static Logger logger;
    private static ByteArrayOutputStream out;
    private static Appender appender;

    @Before
    public void init() {

        respuestaDeclaracionType = new RespuestaDeclaracionType();
        respuestaDeclaracionType.setEstadoEnvio(EstadoEnvioType.ACEPTACION_PARCIAL);

        RespuestaOperacionesType respuestaOperacionesType = new RespuestaOperacionesType();
        respuestaOperacionesType.setIdRegistroDeclarado("206");
        respuestaOperacionesType.setDescripcionErrorRegistro("El NIF no esta identificado. NIF Cedente: 50874160T. NOMBRE_RAZON: Michelle 'Chelle' Taylor. ");
        respuestaOperacionesType.setCodigoErrorRegistro(BigInteger.valueOf(1106));
        respuestaOperacionesType.setEstadoRegistro(EstadoRegistroType.RECHAZADO);

        respuestaLinea = new ArrayList<>();
        respuestaLinea.add(respuestaOperacionesType);

        respuestaDeclaracionType.getRespuestaLinea().add(respuestaLinea.get(0));

        LogManager.getRootLogger().addAppender(mockAppender);

        Layout layout = new SimpleLayout();

        logger = Logger.getLogger(RespuestaDeclaracionType.class);
        out = new ByteArrayOutputStream();
        appender = new WriterAppender(layout, out);
        logger.addAppender(appender);

    }

    @Test
    public void printMessageTest() {
        respuestaDeclaracionType.printMessage();

        String logMsg = out.toString();

        assertNotNull(logMsg);
        assertTrue(logMsg.contains("The status of registration/modification is [" + respuestaDeclaracionType.getEstadoEnvio().value() + "]\n"));
        assertTrue(logMsg.contains("El NIF no esta identificado. NIF Cedente: 50874160T. NOMBRE_RAZON: Michelle 'Chelle' Taylor. "));
    }

    @Test
    public void getFinalErrorMessageTest() {
        RespuestaOperacionesType firstElemOfList = respuestaLinea.get(0);
        String finalMessageWithNull = respuestaDeclaracionType.getFinalErrorMessage(null, firstElemOfList);
        assertEquals(finalMessageWithNull, "\nUnknown error code [" + firstElemOfList.getCodigoErrorRegistro() + "], message: " + firstElemOfList.getDescripcionErrorRegistro() + ", DeclarationID: " + firstElemOfList.getIdRegistroDeclarado() + "\n");

        String finalMessage = respuestaDeclaracionType.getFinalErrorMessage("", firstElemOfList);
        assertEquals(finalMessage, "\nThe error is: code [" + firstElemOfList.getCodigoErrorRegistro() + "], message: " + "" + " (" + firstElemOfList.getDescripcionErrorRegistro() + "), DeclarationID: " + firstElemOfList.getIdRegistroDeclarado() + "\n");
    }

    @Test
    public void isAcceptedTest() {
        String status = respuestaDeclaracionType.getEstadoEnvio().value();
        boolean isAccepted = respuestaDeclaracionType.isAccepted(status);
        assertEquals(false, isAccepted);
    }

    @Test
    public void isLineResponseRejectedTest() {
        boolean isRejected = respuestaDeclaracionType.isLineResponseRejected(respuestaLinea.get(0));
        assertEquals(true, isRejected);
    }

    @After
    public void destroy() {
        logger.removeAppender(appender);
    }

}
