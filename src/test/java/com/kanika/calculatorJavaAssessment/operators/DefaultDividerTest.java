package com.kanika.calculatorJavaAssessment.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class DefaultDividerTest {
	
	DefaultDivider defaultDivider;
	
	@Before
    public void init() {
		defaultDivider = new DefaultDivider();
    }

    @Test
    public void basicTest() {
    	
    	// Basic Test
        int a=15, b=5;
        Integer div = defaultDivider.divide(a,b);
        assertEquals("The division should be 3", 3, (int)div);
    }

    @Test
    public void nullIntegerShouldThrowExceptionTest() {
    	
    	// A null integer should throw exception
        int a=5;
        try {
        	defaultDivider.divide(a,null);
            fail("Divider including null integer should throw exception");
        } catch (Exception e) {
            assertTrue("Passing a null integer to defaultDivider threw exception as expected", true);
        }
    }
    
    @Test
    public void zeroDivisorShouldThrowExceptionTest() {
    	
    	// Zero divisor should throw exception
        int a=5,b=0;
        try {
        	defaultDivider.divide(a,b);
            fail("Zero divisor should throw exception");
        } catch (Exception e) {
            assertTrue("Passing a zero divisor to defaultDivider threw exception as expected", true);
        }
    }

}
