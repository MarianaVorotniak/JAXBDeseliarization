package com.jaxb;

import com.jaxb.exceptions.ParseException;
import com.jaxb.services.MainService;
import org.apache.log4j.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class MainTest {

    @Mock
    private Appender mockAppender;

    private static MainService service;
    private static List<String> listOfFiles;
    private static List<String> listOfWrongFiles;

    private static Logger logger;
    private static ByteArrayOutputStream out;
    private static Appender appender;

    @Before
    public void init() {
        service = new MainService();

        listOfFiles = new ArrayList<>();
        listOfWrongFiles = new ArrayList<>();

        listOfFiles = Arrays.asList("src\\main\\resources\\responses\\rejectedResponse.xml", "src\\main\\resources\\responses\\rejectedWithManyResponse.xml");
        listOfWrongFiles = Arrays.asList(null, "src\\main\\resources\\testResponses\\notRecognizedResponse.xml");


        LogManager.getRootLogger().addAppender(mockAppender);

        Layout layout = new SimpleLayout();

        logger = Logger.getLogger(Main.class);
        out = new ByteArrayOutputStream();
        appender = new WriterAppender(layout, out);
        logger.addAppender(appender);
    }

    @Test
    public void processResponsesTest() {
        Main.processResponses(listOfFiles, service);

        String logMsg = out.toString();
        assertNotNull(logMsg);
        assertTrue(logMsg.contains("IDRegistroDeclarado [000009], EstadoRegistro [RECHAZADO], message: The Tax ID is not identified, spanish message: El NIF no esta identificado. NIF: 77780619R. NOMBRE_RAZON: SunSea Costa Brava. "));
        assertTrue(logMsg.contains("IDRegistroDeclarado [653], EstadoRegistro [RECHAZADO]. Unknown error code [1200], spanish message: Campo sin valor o fomato incorrecto: NombreVia"));
        assertFalse(logMsg.contains("Error en la cabecera. El NIF del declarante es inválido. NIF:B98156129. NOMBRE_RAZON:HomeAway]"));
    }

    @Test
    public void processResponsesByWrongPathsTest() {
        Main.processResponses(listOfWrongFiles, service);

        String logMsg = out.toString();
        assertNotNull(logMsg);
        assertTrue(logMsg.contains("Reading file [null]"));
        assertTrue(logMsg.contains("Error in file src\\main\\resources\\testResponses\\notRecognizedResponse.xml"));
    }

    @After
    public void destroy() {
        logger.removeAppender(appender);
    }

}
