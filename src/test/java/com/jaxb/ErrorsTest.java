package com.jaxb;

import com.jaxb.exceptions.ParseException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ErrorsTest {

    @Mock
    private Errors errors;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void codeIsCorrectTest() throws ParseException {
        String message = errors.findMessageByCode(5101);
        assertEquals("Incorrect value of the Key field", message);
    }

    @Test
    public void codeDoesNotExistInMapTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("Incorrect code");
        errors.findMessageByCode(0);
    }

}
