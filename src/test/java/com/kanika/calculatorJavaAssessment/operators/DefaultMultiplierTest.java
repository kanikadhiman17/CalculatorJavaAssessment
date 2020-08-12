package com.kanika.calculatorJavaAssessment.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DefaultMultiplierTest {
	
	DefaultMultiplier defaultMultiplier;

    @Before
    public void init() {
    	defaultMultiplier = new DefaultMultiplier();
    }

    @Test
    public void basicTest() {
    	
    	// Basic Test
        List<Integer> numbersToBeMultiplied = Arrays.asList(5, 10, -6, 1);
        Integer sum = defaultMultiplier.multiply(numbersToBeMultiplied);
        assertEquals("The multiplication should be -300", -300, (int)sum);
    }

    @Test
    public void notEnoughNumbersShouldThrowExceptionTest() {
    	
    	// Empty list should throw exception
        List<Integer> emptyList = new ArrayList<>();
        try {
        	defaultMultiplier.multiply(emptyList);
            fail("Multiplying an empty list should throw exception");
        } catch (Exception e) {
            assertTrue("Passing an emptyList to defaultMultiplier threw exception as expected", true);
        }
    }

}
