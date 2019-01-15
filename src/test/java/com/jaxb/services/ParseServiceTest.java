package com.jaxb.services;

import com.jaxb.POJOs.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public ExpectedException expectedException = ExpectedException.none();

    private String filePath;
    private String incorrectfilePath;

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
        head.setIdDeclarante(idDeclarante);
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

        filePath = "src\\main\\resources\\response.xsd";
        incorrectfilePath = "src\\main\\resources\\responses.xsd";
    }

    @Test
    public void parseResponseTest() throws JAXBException {

        RespuestaDeclaracion respuestaDeclaracion = parseService.parseResponse(filePath);

        Body actualBody = expectedEnvelope.getResponseBody();
        RespuestaDeclaracion actualResponse = actualBody.getDeclarationResponse();

        assertEquals(body, actualBody);

        assertEquals(head, respuestaDeclaracion.getCabecera());
        assertEquals(head.getCommunicationType(), respuestaDeclaracion.getCabecera().getCommunicationType());

        assertEquals(head.getIdDeclarante(), respuestaDeclaracion.getCabecera().getIdDeclarante());
        assertEquals(head.getIdDeclarante().getNif(), respuestaDeclaracion.getCabecera().getIdDeclarante().getNif());
        assertEquals(head.getIdDeclarante().getReasonName(), respuestaDeclaracion.getCabecera().getIdDeclarante().getReasonName());

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

        assertTrue(head instanceof Cabecera);
    }

    @Test
    public void unmarshalTest() throws JAXBException {
        Envelope envelope = parseService.unmarshal(filePath);
        assertEquals(expectedEnvelope, envelope);
    }

    @Test(expected = UnmarshalException.class)
    public void unmarshalWithIncorrectPathTest() throws JAXBException {
        Envelope envelope = parseService.unmarshal(incorrectfilePath);
    }

    @Test(expected = UnmarshalException.class)
    public void parseResponseWithIncorrectPathTest() throws JAXBException {
        RespuestaDeclaracion envelope = parseService.parseResponse(incorrectfilePath);
    }

}
