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
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
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
    private IDDeclarante idDeclarante;
    @Mock
    private Periodo period;
    @Mock
    private Cabecera head;
    @Mock
    private List<RespuestaLinea> lineResponses;
    @Mock
    private RespuestaDeclaracion declarationResponse;
    @Mock
    private Body body;
    @Mock
    private Header header;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    private String filePath;
    private String filePathForConsultation;
    private String filePathForCancelation;
    private String filePathFault;
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

        lineResponses =  new ArrayList<>();
        lineResponses.add(new RespuestaLinea());
        lineResponses.get(0).setErrorDescription("El NIF no esta identificado. NIF: 77780619R. NOMBRE_RAZON: SunSea Costa Brava. ");
        lineResponses.get(0).setRecordCode(1106);
        lineResponses.get(0).setRecordID("000009");
        lineResponses.get(0).setRecordStatus("Rechazado");

        declarationResponse = new RespuestaDeclaracion();
        declarationResponse.setCabecera(head);
        declarationResponse.setLineResponse(lineResponses);
        declarationResponse.setSendStatus("Rechazo Completo");

        body = new Body();
        body.setDeclarationResponse(declarationResponse);
        body.setId("Body");

        header = new Header();

        expectedEnvelope.setHeader(header);
        expectedEnvelope.setResponseBody(body);

        filePath = "src\\main\\resources\\realResponses\\registration\\rejected\\rejectedResponse.xml";
        filePathForConsultation = "src\\main\\resources\\realResponses\\consultation\\consultationResponse.xml";
        filePathForCancelation = "src\\main\\resources\\realResponses\\cancelation\\cancelationResponse.xml";
        filePathFault = "src\\main\\resources\\realResponses\\registration\\rejected\\faultResponseHeaderError.xml";
        incorrectFile = "src\\main\\resources\\testResponses\\wrongResponse.xml";
        wrongXml = "src\\main\\resources\\testResponses\\wrongXml.xml";
    }

    @Test
    public void parseResponseTest() throws ParseException {

        String fileContent = MainService.readFile(filePath);

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

        assertEquals(lineResponses, respuestaDeclaracion.getLineResponse());
        assertEquals(lineResponses.get(0).getErrorDescription(), respuestaDeclaracion.getLineResponse().get(0).getErrorDescription());
        assertEquals(lineResponses.get(0).getRecordCode(), respuestaDeclaracion.getLineResponse().get(0).getRecordCode());
        assertEquals(lineResponses.get(0).getRecordID(), respuestaDeclaracion.getLineResponse().get(0).getRecordID());
        assertEquals(lineResponses.get(0).getRecordStatus(), respuestaDeclaracion.getLineResponse().get(0).getRecordStatus());

    }

    @Test
    public void parseConsultationResponseTest() throws ParseException {
        String fileContent = MainService.readFile(filePathForConsultation);

        RespuestaConsultaDI respuestaConsultaDI = parseService.parseConsultationResponse(fileContent);

        assertEquals("ConDatos", respuestaConsultaDI.getConsultationResult());
        assertEquals("01010101M", respuestaConsultaDI.getDeclaration().getDetail().getIdAssignee().getNif());
    }


    @Test
    public void parseCancelationResponseTest() throws ParseException {
        String fileContent = MainService.readFile(filePathForCancelation);

        RespuestaBajaDI respuestaBajaDI = parseService.parseCancelationResponse(fileContent);

        assertEquals("DESARROLLOLOCAL0", respuestaBajaDI.getCsv());
        assertNotEquals("88888880Ks", respuestaBajaDI.getPresentationDate().getNifPresenter());
    }

    @Test
    public void parseFaultResponseTest() throws ParseException, IOException, SAXException, ParserConfigurationException {
        String fileContent = MainService.readFile(filePathFault);

        Fault fault = parseService.parseFaultResponse(fileContent);

        assertEquals("env:Client", fault.getFaultcode());
    }

    @Test
    public void parseResponseWithIncorrectFileContentTest() throws ParseException {
        String fileContent = MainService.readFile(incorrectFile);
        RespuestaDeclaracion respuestaDeclaracion = parseService.parseResponse(fileContent);
        assertThat(declarationResponse, is(not(respuestaDeclaracion)));
    }

    @Test
    public void parseResponseWithWrongXmlTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("Wrong xml");
        String fileContent = MainService.readFile(wrongXml);
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




    @Test
    public void parseResponseWithIncorrectFileContentTestForConsultation() throws ParseException {
        String fileContent = MainService.readFile(incorrectFile);
        RespuestaConsultaDI respuestaConsultaDI = parseService.parseConsultationResponse(fileContent);
        assertThat(declarationResponse, is(not(respuestaConsultaDI)));
    }

    @Test
    public void parseResponseWithWrongXmlTestForConsultation() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("Wrong xml");
        String fileContent = MainService.readFile(wrongXml);
        RespuestaConsultaDI respuestaConsultaDI = parseService.parseConsultationResponse(fileContent);
    }

    @Test
    public void parseResponseWithEmptyContentTestForConsultation() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File content is empty");
        RespuestaConsultaDI respuestaConsultaDI = parseService.parseConsultationResponse("");
    }

    @Test
    public void parseResponseWithNullPathTestForConsultation() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File content is null");
        RespuestaConsultaDI respuestaConsultaDI = parseService.parseConsultationResponse(null);
    }





    @Test
    public void parseResponseWithIncorrectFileContentTestForCancelation() throws ParseException {
        String fileContent = MainService.readFile(incorrectFile);
        RespuestaBajaDI respuestaBajaDI = parseService.parseCancelationResponse(fileContent);
        assertThat(declarationResponse, is(not(respuestaBajaDI)));
    }

    @Test
    public void parseResponseWithWrongXmlTestForCancelation() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("Wrong xml");
        String fileContent = MainService.readFile(wrongXml);
        RespuestaBajaDI respuestaBajaDI = parseService.parseCancelationResponse(fileContent);
    }

    @Test
    public void parseResponseWithEmptyContentTestForCancelation() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File content is empty");
        RespuestaBajaDI respuestaBajaDI = parseService.parseCancelationResponse("");
    }

    @Test
    public void parseResponseWithNullPathTestForCancelation() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File content is null");
        RespuestaBajaDI respuestaBajaDI = parseService.parseCancelationResponse(null);
    }
}
