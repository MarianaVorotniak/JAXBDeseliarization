package com.jaxb;

import com.jaxb.exceptions.ParseException;
import com.jaxb.services.MainService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class MainServiceTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void translateTest() throws ParseException {
        String actualAcceptanceTranslated = MainService.translate("Aceptacion Completa");
        assertEquals("Fully accepted", actualAcceptanceTranslated);
        assertNotEquals("Accepted", actualAcceptanceTranslated);

        String actualRejectedTranslated = MainService.translate("Rechazo Completo");
        assertEquals("Rejected", actualRejectedTranslated);
        assertNotEquals("Accepted", actualRejectedTranslated);

        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("Word is not a correct status");
        String actualWrongTranslated = MainService.translate("Aceptacion");
    }

    @Test
    public void readFileTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File does not exist");
        String fileContent = MainService.readFile("file");
    }


}
