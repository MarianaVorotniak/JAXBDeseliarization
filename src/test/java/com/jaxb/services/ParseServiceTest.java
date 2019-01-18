package com.jaxb.services;

import com.jaxb.Main;
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

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class ParseServiceTest {

    @InjectMocks
    private ParseService parseService;

    @InjectMocks
    private Envelope expectedEnvelope;
    @Mock
    private IDDeclarante idDeclarante;
    @Mock
    private Periodo period;
    @Mock
    private Cabecera head;
    @Mock
    private RespuestaLinea lineResponse;
    @Mock
    private RespuestaDeclaracion declarationResponse;
    @Mock
    private Body body;
    @Mock
    private Header header;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    private String filePath;
    private String incorrectFile;
    private String wrongXml;

    @Before
    public void init() {

        idDeclarante = new IDDeclarante();
        idDeclarante.setNif("B98156128");
        idDeclarante.setReasonName("HomeAway");

        period = new Periodo();
        period.setExerciseNumber(2018);
        period.setPeriodCode("0A");

        head = new Cabecera();
        head.setCommunicationType("A0");
        head.setIdDeclaration(idDeclarante);
        head.setModelNumber(179);
        head.setModelVersionID("1.0");
        head.setPeriod(period);

        lineResponse =  new RespuestaLinea();
        lineResponse.setErrorDescription("El NIF no esta identificado. NIF: 77780619R. NOMBRE_RAZON: SunSea Costa Brava. ");
        lineResponse.setRecordCode(1106);
        lineResponse.setRecordID("000009");
        lineResponse.setRecordStatus("Rechazado");

        declarationResponse = new RespuestaDeclaracion();
        declarationResponse.setCabecera(head);
        declarationResponse.setLineResponse(lineResponse);
        declarationResponse.setSendStatus("Rechazo Completo");

        body = new Body();
        body.setDeclarationResponse(declarationResponse);
        body.setId("Body");

        header = new Header();

        expectedEnvelope.setHeader(header);
        expectedEnvelope.setResponseBody(body);

        filePath = "src\\main\\resources\\realResponses\\registration\\rejected\\rejectedResponse.xml";
        incorrectFile = "src\\main\\resources\\testResponses\\wrongResponse.xml";
        wrongXml = "src\\main\\resources\\testResponses\\wrongXml.xml";
    }

    @Test
    public void parseResponseTest() throws ParseException {

        String fileContent = Main.readFile(filePath);

        RespuestaDeclaracion respuestaDeclaracion = parseService.parseResponse(fileContent);

        Body actualBody = expectedEnvelope.getResponseBody();
        RespuestaDeclaracion actualResponse = actualBody.getDeclarationResponse();

        assertEquals(body, actualBody);

        assertEquals(head, respuestaDeclaracion.getCabecera());
        assertEquals(head.getCommunicationType(), respuestaDeclaracion.getCabecera().getCommunicationType());

        assertEquals(head.getIdDeclaration(), respuestaDeclaracion.getCabecera().getIdDeclaration());
        assertEquals(head.getIdDeclaration().getNif(), respuestaDeclaracion.getCabecera().getIdDeclaration().getNif());
        assertEquals(head.getIdDeclaration().getReasonName(), respuestaDeclaracion.getCabecera().getIdDeclaration().getReasonName());

        assertEquals(head.getModelNumber(), respuestaDeclaracion.getCabecera().getModelNumber());
        assertEquals(head.getModelVersionID(), respuestaDeclaracion.getCabecera().getModelVersionID());

        assertEquals(head.getPeriod(), respuestaDeclaracion.getCabecera().getPeriod());
        assertEquals(head.getPeriod().getExerciseNumber(), respuestaDeclaracion.getCabecera().getPeriod().getExerciseNumber());
        assertEquals(head.getPeriod().getPeriodCode(), respuestaDeclaracion.getCabecera().getPeriod().getPeriodCode());

        assertEquals(declarationResponse, actualResponse);
        assertEquals(declarationResponse.getSendStatus(), actualResponse.getSendStatus());
        assertEquals(declarationResponse.getCabecera(), actualResponse.getCabecera());
        assertEquals(declarationResponse.getLineResponse(), actualResponse.getLineResponse());

        assertEquals(lineResponse, respuestaDeclaracion.getLineResponse());
        assertEquals(lineResponse.getErrorDescription(), respuestaDeclaracion.getLineResponse().getErrorDescription());
        assertEquals(lineResponse.getRecordCode(), respuestaDeclaracion.getLineResponse().getRecordCode());
        assertEquals(lineResponse.getRecordID(), respuestaDeclaracion.getLineResponse().getRecordID());
        assertEquals(lineResponse.getRecordStatus(), respuestaDeclaracion.getLineResponse().getRecordStatus());

    }

    @Test
    public void parseResponseWithIncorrectFileContentTest() throws ParseException {
        String fileContent = Main.readFile(incorrectFile);
        RespuestaDeclaracion respuestaDeclaracion = parseService.parseResponse(fileContent);
        assertThat(declarationResponse, is(not(respuestaDeclaracion)));
    }

    @Test
    public void parseResponseWithWrongXmlTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("Wrong xml");
        String fileContent = Main.readFile(wrongXml);
        RespuestaDeclaracion respuestaDeclaracion = parseService.parseResponse(fileContent);
    }

    @Test
    public void parseResponseWithEmptyContentTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File content is empty");
        RespuestaDeclaracion respuestaDeclaracion = parseService.parseResponse("");
    }

    @Test
    public void parseResponseWithNullPathTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File content is null");
        RespuestaDeclaracion respuestaDeclaracion = parseService.parseResponse(null);
    }

}
