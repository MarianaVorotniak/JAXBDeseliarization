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
    private String filePathFaultWithoutCallstack;
    private String filePathFaultWithoutCode;
    private String filePathFaultWithoutString;

    private String rejectedContent;
    private String rejectedContentWithErrors;
    private String rejectedContentWithoutCabecera;

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
        filePathFaultWithoutCallstack = "src\\main\\resources\\testResponses\\faultWithoutCallstack.xml";
        filePathFaultWithoutCode = "src\\main\\resources\\testResponses\\faultWithoutFaultCode.xml";

        rejectedContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <env:Header/>\n" +
                "    <env:Body Id=\"Body\">\n" +
                "        <ddiiR:RespuestaDeclaracion xmlns:ddiiR=\"https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd\" xmlns:ddii=\"https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd\">\n" +
                "            <ddiiR:Cabecera>\n" +
                "                <ddii:TipoComunicacion>A0</ddii:TipoComunicacion>\n" +
                "                <ddii:Modelo>179</ddii:Modelo>\n" +
                "                <ddii:Periodo>\n" +
                "                    <ddii:Ejercicio>2018</ddii:Ejercicio>\n" +
                "                    <ddii:Periodo>0A</ddii:Periodo>\n" +
                "                </ddii:Periodo>\n" +
                "                <ddii:IDVersionModelo>1.0</ddii:IDVersionModelo>\n" +
                "                <ddii:IDDeclarante>\n" +
                "                    <ddii:NIF>B98156128</ddii:NIF>\n" +
                "                    <ddii:NombreRazon>HomeAway</ddii:NombreRazon>\n" +
                "                </ddii:IDDeclarante>\n" +
                "            </ddiiR:Cabecera>\n" +
                "            <ddiiR:EstadoEnvio>Rechazo Completo</ddiiR:EstadoEnvio>\n" +
                "            <ddiiR:RespuestaLinea>\n" +
                "                <ddiiR:IDRegistroDeclarado>000009</ddiiR:IDRegistroDeclarado>\n" +
                "                <ddiiR:EstadoRegistro>Rechazado</ddiiR:EstadoRegistro>\n" +
                "                <ddiiR:CodigoErrorRegistro>1106</ddiiR:CodigoErrorRegistro>\n" +
                "                <ddiiR:DescripcionErrorRegistro>El NIF no esta identificado. NIF: 77780619R. NOMBRE_RAZON: SunSea Costa Brava. </ddiiR:DescripcionErrorRegistro>\n" +
                "            </ddiiR:RespuestaLinea>\n" +
                "        </ddiiR:RespuestaDeclaracion>\n" +
                "    </env:Body>\n" +
                "</env:Envelope>";

        rejectedContentWithErrors = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<env:Envelope xmln:env=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <env:Header/>\n" +
                "    <env:Body Id=\"Body\">\n" +
                "        <ddiiR:RespuestaDeclaracion xmlns:ddiiR=\"https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd\" xmlns:ddii=\"https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd\">\n" +
                "            <ddiiR:Cabecera>\n" +
                "                <ddii:TipoComunicacion>A0</ddii:TipoComunicacion>\n" +
                "                <ddii:Modelo>179</ddii:Modelo>\n" +
                "                <ddii:Periodo>\n" +
                "                    <ddii:Ejercicio>2018</ddii:Ejercicio>\n" +
                "                    <ddii:Periodo>0A</ddii:Periodo>\n" +
                "                </ddii:Periodo>\n" +
                "                <ddii:IDVersionModelo>1.0</ddii:IDVersionModelo>\n" +
                "                <ddii:IDDeclarante>\n" +
                "                    <ddii:NIF>B98156128</ddii:NIF>\n" +
                "                    <ddii:NombreRazon>HomeAway</ddii:NombreRazon>\n" +
                "                </ddii:IDDeclarante>\n" +
                "            </ddiiR:Cabecera>\n" +
                "            <ddiiR:EstadoEnvio>Rechazo Completo</ddiiR:EstadoEnvio>\n" +
                "            <ddiiR:RespuestaLinea>\n" +
                "                <ddiiR:IDRegistroDeclarado>000009</ddiiR:IDRegistroDeclarado>\n" +
                "                <ddiiR:EstadoRegistro>Rechazado</ddiiR:EstadoRegistro>\n" +
                "                <ddiiR:CodigoErrorRegistro>1106</ddiiR:CodigoErrorRegistro>\n" +
                "                <ddiiR:DescripcionErrorRegistro>El NIF no esta identificado. NIF: 77780619R. NOMBRE_RAZON: SunSea Costa Brava. </ddiiR:DescripcionErrorRegistro>\n" +
                "            </ddiiR:RespuestaLinea>\n" +
                "        </ddiiR:RespuestaDeclaracion>\n" +
                "    </env:Body>\n" +
                "</env:Envelope>";

        rejectedContentWithoutCabecera = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <env:Header/>\n" +
                "    <env:Body Id=\"Body\">\n" +
                "        <ddiiR:RespuestaDeclaracion xmlns:ddiiR=\"https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd\" xmlns:ddii=\"https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd\">\n" +
                "            <ddiiR:EstadoEnvio>Rechazo Completo</ddiiR:EstadoEnvio>\n" +
                "            <ddiiR:RespuestaLinea>\n" +
                "                <ddiiR:IDRegistroDeclarado>000009</ddiiR:IDRegistroDeclarado>\n" +
                "                <ddiiR:EstadoRegistro>Rechazado</ddiiR:EstadoRegistro>\n" +
                "                <ddiiR:CodigoErrorRegistro>1106</ddiiR:CodigoErrorRegistro>\n" +
                "                <ddiiR:DescripcionErrorRegistro>El NIF no esta identificado. NIF: 77780619R. NOMBRE_RAZON: SunSea Costa Brava. </ddiiR:DescripcionErrorRegistro>\n" +
                "            </ddiiR:RespuestaLinea>\n" +
                "        </ddiiR:RespuestaDeclaracion>\n" +
                "    </env:Body>\n" +
                "</env:Envelope>";
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
        assertNotNull(fault.getDetail().getCallstack());
    }

    @Test
    public void parseFaultResponseWithoutCallstackTest() throws ParseException {
        String fileContent2 = MainService.readFile(filePathFaultWithoutCallstack);
        Fault fault = parseService.parseFaultResponse(fileContent2);
        assertEquals(fault.getDetail().getCallstack(), null);
    }

    public void parseFaultResponseWithoutCode() throws ParseException {
        String fileContent3 = MainService.readFile(filePathFaultWithoutCode);
        Fault fault = parseService.parseFaultResponse(fileContent3);
        assertEquals(fault.getFaultcode(), "");
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

    @Test
    public void checkFileContentTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File content is null");
        parseService.checkFileContent(null);

        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File content is is not [RespuestaDeclaracion] or [Fault] type: <Test>This is a test</Test>");
        parseService.checkFileContent("<Test>This is a test</Test>");

        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File content is empty");
        parseService.checkFileContent("");
    }

    @Test
    public void unmarshalTest() throws ParseException {
        Envelope envelope = parseService.unmarshal(rejectedContent);

        assertEquals(envelope.getBody().getFault(), null);
        System.out.println();
        assertTrue(envelope.getBody().getRespuestaDeclaracionType().getDatosPresentacion() == declarationResponse.getDatosPresentacion());
        assertEquals(envelope.getBody().getRespuestaDeclaracionType().getCsv(), null);
        assertEquals(envelope.getBody().getRespuestaDeclaracionType().getCabecera().getPeriodo().getPeriodo(), head.getPeriodo().getPeriodo());
        assertEquals(envelope.getBody().getRespuestaDeclaracionType().getCabecera().getModelo(), "179");

        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("Wrong xml. Can't unmarshal file.");
        envelope = parseService.unmarshal(rejectedContentWithErrors);

        envelope = parseService.unmarshal(rejectedContentWithoutCabecera);
        assertEquals(envelope.getBody().getRespuestaDeclaracionType().getCabecera().getModelo(), null);

    }

    @Test
    public void getResponseBodyTest() throws ParseException {
        Body body = parseService.getResponseBody(rejectedContent);

        assertEquals(body.getFault(), null);
        assertEquals(body.getRespuestaDeclaracionType().getEstadoEnvio().value(), "Rechazo Completo");

        body = parseService.getResponseBody(rejectedContentWithoutCabecera);
        assertNull(body.getRespuestaDeclaracionType().getCabecera());

        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("Wrong xml. Can't unmarshal file.");
        body = parseService.getResponseBody(rejectedContentWithErrors);
    }

}
