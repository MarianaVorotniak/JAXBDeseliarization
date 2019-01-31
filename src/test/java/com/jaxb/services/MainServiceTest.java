package com.jaxb.services;

import com.jaxb.POJOs.*;
import com.jaxb.exceptions.ParseException;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
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

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

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

        filePathWithFaultHeaderResponse = "src\\main\\resources\\responses\\faultResponseHeaderError.xml";
        filePathAcceptedWithOne = "src\\main\\resources\\responses\\acceptedWithOneResponse.xml";
        filePathWithTestResponse = "src\\main\\resources\\testResponses\\notRecognizedResponse.xml";
    }

    @Test
    public void readFileEmptyTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File path is empty");
        mainService.readFile("");
    }

    @Test
    public void readFileNullTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File path is null");
        mainService.readFile(null);
    }

    @Test
    public void readFileNotExistsTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File does not exist");
        mainService.readFile("file");
    }

    @Test
    public void getResponseTest() throws ParseException {
        expectedEx.expect(ParseException.class);

        Object registration = mainService.getResponse(filePathAcceptedWithOne);
        Object faultObj = mainService.getResponse(filePathWithFaultHeaderResponse);

        expectedEx.expectMessage("Error in file src\\main\\resources\\testResponses\\notRecognizedResponse.xml");
        mainService.getResponse(filePathWithTestResponse);

        assertTrue(registration instanceof RespuestaDeclaracionType);
        assertTrue(faultObj instanceof Fault);

        Fault faultNotObj = (Fault) faultObj;

        assertEquals(faultNotObj.getFaultcode(), fault.getFaultcode());
        assertEquals(faultNotObj.getFaultstring(), fault.getFaultstring());
        assertEquals(faultNotObj.getDetail().getCallstack(), fault.getDetail().getCallstack());

        RespuestaDeclaracionType registrationNotObj = (RespuestaDeclaracionType) registration;

        assertEquals(registrationNotObj.getCabecera().getModelo(), responseAccepted.getCabecera().getModelo());
        assertEquals(registrationNotObj.getRespuestaLinea().size(), responseAccepted.getRespuestaLinea().size());

        expectedEx.expectMessage("IOException: src\\main\\resources\\testResponses");
        mainService.getResponse("src\\main\\resources\\testResponses");
    }

}
