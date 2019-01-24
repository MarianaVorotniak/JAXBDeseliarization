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
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MainServiceTest {

    @InjectMocks
    private MainService mainService;
    @Mock
    private RespuestaDeclaracion responseAccepted;
    @Mock
    private RespuestaDeclaracion responseRejected;
    @Mock
    private Fault fault;
    @Mock
    private RespuestaBajaDI cancelationResponse;
    @Mock
    private RespuestaConsultaDI consultationResponse;
    @Mock
    private List<RespuestaLinea> lineResponse;
    @Mock
    private Appender mockAppender;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    private static Logger logger;
    private static ByteArrayOutputStream out;
    private static Appender appender;

    private static String filePathWithFaultHeaderResponse;
    private static String filePathAcceptedWithOne;
    private static String filePathConsultationResponse;
    private static String filePathCancelationResponse;
    private static String filePathWithTestResponse;

    @Before
    public void init() {
        responseAccepted = new RespuestaDeclaracion();
        responseAccepted.setSendStatus("Aceptacion Completa");

        responseRejected= new RespuestaDeclaracion();
        responseRejected.setSendStatus("Rechazo Completo");

        fault = new Fault();
        fault.setFaultcode("env:Client");

        cancelationResponse = new RespuestaBajaDI();
        cancelationResponse.setSendStatus("Aceptacion Completa");

        consultationResponse = new RespuestaConsultaDI();
        consultationResponse.setConsultationResult("ConDatos");

        lineResponse = new ArrayList<>();
        RespuestaLinea firstElemOfLineResponseList = new RespuestaLinea();
        firstElemOfLineResponseList.setRecordStatus("Rechazado");
        firstElemOfLineResponseList.setRecordID("000009");
        firstElemOfLineResponseList.setRecordCode(1106);
        firstElemOfLineResponseList.setErrorDescription("El NIF no esta identificado. NIF: 77780619R. NOMBRE_RAZON: SunSea Costa Brava. ");
        lineResponse.add(firstElemOfLineResponseList);

        responseRejected.setLineResponse(lineResponse);

        LogManager.getRootLogger().addAppender(mockAppender);

        Layout layout = new SimpleLayout();

        logger = Logger.getLogger(MainService.class);
        out = new ByteArrayOutputStream();
        appender = new WriterAppender(layout, out);
        logger.addAppender(appender);

        filePathWithFaultHeaderResponse = "src\\main\\resources\\realResponses\\registration\\rejected\\faultResponseHeaderError.xml";
        filePathAcceptedWithOne = "src\\main\\resources\\realResponses\\registration\\accepted\\acceptedWithOneResponse.xml";
        filePathConsultationResponse = "src\\main\\resources\\realResponses\\consultation\\consultationResponse.xml";
        filePathCancelationResponse = "src\\main\\resources\\realResponses\\cancelation\\cancelationResponse.xml";
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
        Object consultation = mainService.getResponse(filePathConsultationResponse);
        Object cancelation = mainService.getResponse(filePathCancelationResponse);
        Object testObj = mainService.getResponse(filePathWithTestResponse);

        assertTrue(registration instanceof RespuestaDeclaracion);
        assertTrue(fault instanceof  Fault);
        assertTrue(consultation instanceof RespuestaConsultaDI);
        assertTrue(cancelation instanceof RespuestaBajaDI);
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

        mainService.checkResponseType(cancelationResponse);
        String logMsgCancelation = out.toString();
        assertTrue(logMsgCancelation.contains("The response is"));

        mainService.checkResponseType(consultationResponse);
        String logMsgConsultation = out.toString();
        assertTrue(logMsgConsultation.contains("The consultation result is"));

        mainService.checkResponseType(null);
        String logMsgNull = out.toString();
        assertTrue(logMsgNull.contains("There is no response."));
    }

    @After
    public void destroy() {
        logger.removeAppender(appender);
    }

}
