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
import java.io.ByteArrayOutputStream;
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
        fault.setFaultstring("Codigo[4105].Error en la cabecera. El NIF del declarante es inválido. NIF:B98156129. NOMBRE_RAZON:HomeAway");

        lineResponse = new ArrayList<>();
        RespuestaOperacionesType firstElemOfLineResponseList = new RespuestaOperacionesType();
        firstElemOfLineResponseList.setEstadoRegistro(EstadoRegistroType.RECHAZADO);
        firstElemOfLineResponseList.setIdRegistroDeclarado("000009");
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
    public void readFileTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File does not exist");
        mainService.readFile("file");
    }

    @Test
    public void getResponseTest() throws ParseException {

        Object registration = mainService.getResponse(filePathAcceptedWithOne);
        Object fault = mainService.getResponse(filePathWithFaultHeaderResponse);

        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("Error in file");
        mainService.getResponse(filePathWithTestResponse);

        assertTrue(registration instanceof RespuestaDeclaracionType);
        assertTrue(fault instanceof Fault);
    }

    @After
    public void destroy() {
        logger.removeAppender(appender);
    }

}
