package com.kanika.calculatorJavaAssessment.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class DefaultSubtractorTest {
	
    DefaultSubtractor defaultSubtractor;

    @Before
    public void init() {
    	defaultSubtractor = new DefaultSubtractor();
    }

    @Test
    public void basicTest() {
    	
    	// Basic test
        int a=5, b=10;
        Integer sub = defaultSubtractor.subtract(a,b);
        assertEquals("The sub should be -5", -5, (int)sub);
    }

    @Test
    public void nullIntegerShouldThrowExceptionTest() {
    	
    	// Null integer should throw exception
        int a=5;
        try {
        	defaultSubtractor.subtract(a,null);
            fail("Subtraction including null integer should throw exception");
        } catch (Exception e) {
            assertTrue("Passing a null integer to defaultSubtractor threw exception as expected", true);
        }
    }
}
