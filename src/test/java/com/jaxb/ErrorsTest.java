package com.jaxb;

import com.jaxb.exceptions.ParseException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ErrorsTest {

    @Mock
    private Errors errors;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void codeIsCorrectTest() throws ParseException {
        String message = errors.findMessageByCode(BigInteger.valueOf(5101));
        assertEquals("Incorrect value of the Key field", message);
    }

    @Test
    public void codeDoesNotExistInMapTest() throws ParseException {
        expectedEx.expect(ParseException.class);
        expectedEx.expectMessage("Can't find code");
        errors.findMessageByCode(BigInteger.valueOf(0));
    }

}
