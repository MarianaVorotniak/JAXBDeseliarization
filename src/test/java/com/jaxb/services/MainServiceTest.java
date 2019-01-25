package com.jaxb.services;

import com.jaxb.POJOs.*;
import com.jaxb.exceptions.ParseException;
import org.apache.log4j.*;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MainServiceTest {

    @InjectMocks
    private MainService mainService;
    @Mock
    private RespuestaDeclaracionType responseAccepted;
    @Mock
    private RespuestaDeclaracionType responseRejected;
    @Mock
    private Fault fault;
    @Mock
    private List<RespuestaOperacionesType> lineResponse;
    @Mock
    private Appender mockAppender;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    private static Logger logger;
    private static ByteArrayOutputStream out;
    private static Appender appender;

    private static String filePathWithFaultHeaderResponse;
    private static String filePathAcceptedWithOne;
    private static String filePathWithTestResponse;

    @Before
    public void init() {
        responseAccepted = new RespuestaDeclaracionType();
        responseAccepted.setEstadoEnvio(EstadoEnvioType.ACEPTACION_COMPLETA);

        responseRejected= new RespuestaDeclaracionType();
        responseRejected.setEstadoEnvio(EstadoEnvioType.RECHAZO_COMPLETO);

        fault = new Fault();
        fault.setFaultcode("env:Client");

        lineResponse = new ArrayList<>();
        RespuestaOperacionesType firstElemOfLineResponseList = new RespuestaOperacionesType();
        firstElemOfLineResponseList.setEstadoRegistro(EstadoRegistroType.RECHAZADO);
        firstElemOfLineResponseList.setIDRegistroDeclarado("000009");
        firstElemOfLineResponseList.setCodigoErrorRegistro(BigInteger.valueOf(1106));
        firstElemOfLineResponseList.setDescripcionErrorRegistro("El NIF no esta identificado. NIF: 77780619R. NOMBRE_RAZON: SunSea Costa Brava. ");
        lineResponse.add(firstElemOfLineResponseList);

        responseRejected.getRespuestaLinea().add(firstElemOfLineResponseList);

        LogManager.getRootLogger().addAppender(mockAppender);

        Layout layout = new SimpleLayout();

        logger = Logger.getLogger(MainService.class);
        out = new ByteArrayOutputStream();
        appender = new WriterAppender(layout, out);
        logger.addAppender(appender);

        filePathWithFaultHeaderResponse = "src\\main\\resources\\responses\\faultResponseHeaderError.xml";
        filePathAcceptedWithOne = "src\\main\\resources\\responses\\acceptedWithOneResponse.xml";
        filePathWithTestResponse = "src\\main\\resources\\testResponses\\notRecognizedResponse.xml";
    }

    @Test
    public void translateTest() throws ParseException {
        String actualAcceptanceTranslated = mainService.translate("Aceptacion Completa");
        assertEquals("Fully accepted", actualAcceptanceTranslated);
        assertNotEquals("Accepted", actualAcceptanceTranslated);

        String actualRejectedTranslated = mainService.translate("Rechazo Completo");
        assertEquals("Rejected", actualRejectedTranslated);
        assertNotEquals("Accepted", actualRejectedTranslated);

        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("Word is not a correct status");
        String actualWrongTranslated = mainService.translate("Aceptacion");
    }

    @Test
    public void readFileTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File does not exist");
        String fileContent = mainService.readFile("file");
    }

    @Test
    public void isAcceptedTest() {
        boolean isAccepted = mainService.isAccepted(responseAccepted);
        assertEquals(true, isAccepted);

        boolean isPartiallyAccepted = mainService.isAccepted(responseRejected);
        assertEquals(false, isPartiallyAccepted);
    }

    @Test
    public void acceptedOrRejectedMessageTest() throws ParseException {

        mainService.acceptedOrRejectedMessage(responseAccepted);
        String logMsgAccepted = out.toString();
        assertNotNull(logMsgAccepted);
        assertTrue(logMsgAccepted.contains("The status is [Fully accepted]"));

        mainService.acceptedOrRejectedMessage(responseRejected);
        String logMsgRejected = out.toString();
        assertNotNull(logMsgRejected);
        assertTrue(logMsgRejected.contains("[Rejected]"));
    }

    @Test
    public void getResponseTest() throws SAXException, ParserConfigurationException, ParseException, IOException {

        Object registration = mainService.getResponse(filePathAcceptedWithOne);
        Object fault = mainService.getResponse(filePathWithFaultHeaderResponse);
        Object testObj = mainService.getResponse(filePathWithTestResponse);

        assertTrue(registration instanceof RespuestaDeclaracionType);
        assertTrue(fault instanceof  Fault);
        assertTrue(testObj.getClass().getName().contains("Object"));
    }

    @Test
    public void checkResponseTypeTest() throws ParseException {
        mainService.checkResponseType(responseAccepted);
        String logMsgRegistration = out.toString();
        assertTrue(logMsgRegistration.contains("[Fully accepted]"));

        mainService.checkResponseType(fault);
        String logMsgFault = out.toString();
        assertTrue(logMsgFault.contains("env:Client"));

        mainService.checkResponseType(null);
        String logMsgNull = out.toString();
        assertTrue(logMsgNull.contains("There is no response."));
    }

    @After
    public void destroy() {
        logger.removeAppender(appender);
    }

}
