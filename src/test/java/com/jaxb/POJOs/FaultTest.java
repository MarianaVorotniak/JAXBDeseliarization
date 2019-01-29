package com.jaxb.POJOs;

import com.jaxb.services.MainService;
import org.apache.log4j.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class FaultTest {

    @Mock
    private static Fault fault;
    @Mock
    private Appender mockAppender;

    private static Logger logger;
    private static ByteArrayOutputStream out;
    private static Appender appender;

    @Before
    public void init() {
        fault = new Fault(new BasicMessage());

        fault.setFaultstring("Codigo[4105].Error en la cabecera. El NIF del declarante es inválido. NIF:B98156129. NOMBRE_RAZON:HomeAway");
        fault.setFaultcode("env:Client");

        LogManager.getRootLogger().addAppender(mockAppender);

        Layout layout = new SimpleLayout();

        logger = Logger.getLogger(Fault.class);
        out = new ByteArrayOutputStream();
        appender = new WriterAppender(layout, out);
        logger.addAppender(appender);

    }

    @Test
    public void printMessageTest() {
        fault.printMessage();

        String logMsg = out.toString();

        assertNotNull(logMsg);
        assertTrue(logMsg.contains("Cause of the Fault response"));
    }

    @Test
    public void getFaultMessageTest() {
        String message = fault.getFaultMessage();
        assertEquals(message, "Cause of the Fault response - [" + fault.getFaultstring() + "]");
    }

    @After
    public void destroy() {
        logger.removeAppender(appender);
    }
}
