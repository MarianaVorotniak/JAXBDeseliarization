package com.jaxb.services;

import com.jaxb.exceptions.ParseException;
import com.jaxb.POJOs.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class ParseServiceTest {

    @InjectMocks
    private ParseService parseService;

    @InjectMocks
    private Envelope expectedEnvelope;
    @Mock
    private CabeceraDI.IDDeclarante idDeclarante;
    @Mock
    private CabeceraDI.Periodo period;
    @Mock
    private CabeceraDI head;
    @Mock
    private List<RespuestaOperacionesType> lineResponses;
    @Mock
    private RespuestaDeclaracionType declarationResponse;
    @Mock
    private Body body;
    @Mock
    private Header header;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    private String filePath;
    private String filePathFault;
    private String incorrectFile;
    private String wrongXml;

    @Before
    public void init() {

        idDeclarante = new CabeceraDI.IDDeclarante();
        idDeclarante.setNif("B98156128");
        idDeclarante.setNombreRazon("HomeAway");

        period = new CabeceraDI.Periodo();
        period.setEjercicio("2018");
        period.setPeriodo("0A");

        head = new CabeceraDI();
        head.setTipoComunicacion(ClaveTipoComunicacionType.A_0);
        head.setIdDeclarante(idDeclarante);
        head.setModelo("179");
        head.setIdVersionModelo("1.0");
        head.setPeriodo(period);

        lineResponses =  new ArrayList<>();
        lineResponses.add(new RespuestaOperacionesType());
        lineResponses.get(0).setDescripcionErrorRegistro("El NIF no esta identificado. NIF: 77780619R. NOMBRE_RAZON: SunSea Costa Brava. ");
        lineResponses.get(0).setCodigoErrorRegistro(BigInteger.valueOf(1106));
        lineResponses.get(0).setIdRegistroDeclarado("000009");
        lineResponses.get(0).setEstadoRegistro(EstadoRegistroType.RECHAZADO);

        declarationResponse = new RespuestaDeclaracionType();
        declarationResponse.setCabecera(head);
        declarationResponse.getRespuestaLinea().add(lineResponses.get(0));
        declarationResponse.setEstadoEnvio(EstadoEnvioType.RECHAZO_COMPLETO);

        body = new Body();
        body.setRespuestaDeclaracionType(declarationResponse);
        body.setId("Body");

        header = new Header();

        expectedEnvelope.setHeader(header);
        expectedEnvelope.setBody(body);

        filePath = "src\\main\\resources\\responses\\rejectedResponse.xml";
        filePathFault = "src\\main\\resources\\responses\\faultResponseHeaderError.xml";
        incorrectFile = "src\\main\\resources\\testResponses\\wrongResponse.xml";
        wrongXml = "src\\main\\resources\\testResponses\\wrongXml.xml";
    }

    @Test
    public void parseResponseTest() {

        Body actualBody = expectedEnvelope.getBody();
        RespuestaDeclaracionType actualResponse = actualBody.getRespuestaDeclaracionType();

        assertEquals(body, actualBody);

        assertEquals(declarationResponse, actualResponse);
        assertEquals(declarationResponse.getEstadoEnvio(), actualResponse.getEstadoEnvio());
        assertEquals(declarationResponse.getCabecera(), actualResponse.getCabecera());
        assertEquals(declarationResponse.getRespuestaLinea(), actualResponse.getRespuestaLinea());

    }

    @Test
    public void parseFaultResponseTest() throws ParseException {
        String fileContent = MainService.readFile(filePathFault);

        Fault fault = parseService.parseFaultResponse(fileContent);

        assertEquals("env:Client", fault.getFaultcode());
        assertTrue(fault.getFaultstring().contains("Codigo[4105].Error en la cabecera."));
    }

    @Test
    public void parseResponseWithIncorrectFileContentTest() throws ParseException {
        String fileContent = MainService.readFile(incorrectFile);
        RespuestaDeclaracionType respuestaDeclaracion = parseService.parseResponse(fileContent);
        assertThat(declarationResponse, is(not(respuestaDeclaracion)));
    }

    @Test
    public void parseResponseWithWrongXmlTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("Wrong xml");
        String fileContent = MainService.readFile(wrongXml);
        RespuestaDeclaracionType respuestaDeclaracion = parseService.parseResponse(fileContent);
    }

    @Test
    public void parseResponseWithEmptyContentTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File content is empty");
        RespuestaDeclaracionType respuestaDeclaracion = parseService.parseResponse("");
    }

    @Test
    public void parseResponseWithNullPathTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File content is null");
        RespuestaDeclaracionType respuestaDeclaracion = parseService.parseResponse(null);
    }

}
