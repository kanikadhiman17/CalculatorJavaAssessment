package com.kanika.calculatorJavaAssessment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.kanika.calculatorJavaAssessment.logging.OperationsLogger;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorExpressonTest {
	
	@Mock
    OperationsLogger operationsLogger;

    @InjectMocks
    Calculator calculator;

    @Test
    public void basicTestInDefaultMode() {

        LoggingStrategy loggingStrategy = new LoggingStrategy("dhimankanika17@gmail.com", FileFormat.txt);
        Calculator calculator = Calculator.builder().loggingStrategy(loggingStrategy).build();   

        String exp = "100 * ( 2 + 12 ) / 14";
        
        // Should return the value 100
        Integer result = calculator.calculate(exp, calculator);
        assertEquals("The calculator should return usual value", 100, (int)result);
        
    }
    
    @Test
    public void invalidExpressionShouldThrowExceptionTest() {
    	
    	LoggingStrategy loggingStrategy = new LoggingStrategy("dhimankanika17@gmail.com", FileFormat.docx);
        Calculator calculator = Calculator.builder().loggingStrategy(loggingStrategy).build();
        
    	String exp = "100 * ( 2 + 12 ) / 14 )";
    	
    	// Wrong or Invalid expression should throw exception
        try {
            calculator.calculate(exp, calculator);
            fail("Adding an empty list should throw exception");
        } catch (Exception e) {
            assertTrue("Passing an emptyList to defaultAdder threw exception as expected", true);
        }
    }

}
