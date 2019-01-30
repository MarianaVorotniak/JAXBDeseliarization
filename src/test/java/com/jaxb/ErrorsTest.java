package com.jaxb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ErrorsTest {

    @Mock
    private Errors errors;

    @Test
    public void codeIsCorrectTest() {
        String message = errors.findMessageByCode(BigInteger.valueOf(5101));
        assertEquals(", message: Incorrect value of the Key field", message);
    }

    @Test
    public void codeDoesNotExistInMapTest() {
        String message = errors.findMessageByCode(BigInteger.valueOf(0));
        assertEquals(". Unknown error code [0]", message);
    }

    @Test
    public void findMessageByNullCode() {
        String message = errors.findMessageByCode(null);
        assertEquals(". Unknown error code [null]", message);
    }

}
