package com.jaxb.services;

import com.jaxb.POJOs.RespuestaDeclaracion;
import com.jaxb.exceptions.ParseException;
import org.apache.log4j.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MainServiceTest {

    @InjectMocks
    private MainService mainService;
    @Mock
    private RespuestaDeclaracion response;
    @Mock
    private Appender mockAppender;

    @Captor
    private ArgumentCaptor captorLoggingEvent;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    private static Logger logger;
    private static ByteArrayOutputStream out;
    private static Appender appender;

    @Before
    public void init() {
        response = new RespuestaDeclaracion();
        response.setSendStatus("Aceptacion Completa");

        LogManager.getRootLogger().addAppender(mockAppender);

        logger = Logger.getLogger(MainService.class);
        out = new ByteArrayOutputStream();
        Layout layout = new SimpleLayout();
        appender = new WriterAppender(layout, out);
        logger.addAppender(appender);
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
        boolean isAccepted = mainService.isAccepted(response);
        assertEquals(true, isAccepted);

        response.setSendStatus("Aceptacion Parcial");
        boolean isPartiallyAccepted = mainService.isAccepted(response);
        assertEquals(false, isPartiallyAccepted);
    }

    @Test
    public void acceptedOrRejectedMessageTest() throws ParseException {

        mainService.acceptedOrRejectedMessage(response, response.getSendStatus());

        String logMsg = out.toString();

        assertNotNull(logMsg);
        assertTrue(logMsg.contains("The status is [Aceptacion Completa]"));
    }

    @Test
    public void getResponseTest() {

    }

    @After
    public void destroy() {
        logger.removeAppender(appender);
    }


}
