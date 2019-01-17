package com.jaxb;

import com.jaxb.exceptions.ParseException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class MainTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void translateTest() throws ParseException {
        String actualCorrectTranslated = Main.translate("Aceptacion Completa");
        assertEquals("Fully accepted", actualCorrectTranslated);
        assertNotEquals("Accepted", actualCorrectTranslated);

        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("Word is not a correct status");
        String actualWrongTranslated = Main.translate("Aceptacion");
    }

    @Test
    public void readFileTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("File does not exist");
        String fileContent = Main.readFile("file");
    }


}
