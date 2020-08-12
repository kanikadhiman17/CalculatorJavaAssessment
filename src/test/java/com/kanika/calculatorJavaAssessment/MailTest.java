package com.kanika.calculatorJavaAssessment;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kanika.calculatorJavaAssessment.logging.OperationsLogger;

public class MailTest {
	
	@Mock
    OperationsLogger operationsLogger;

    @InjectMocks
    Calculator calculator;

    @Test
    public void basicMailTest() {

    	// Logging Strategy to be given to send the mail
        LoggingStrategy loggingStrategy = new LoggingStrategy("xyz@gmail.com", FileFormat.docx);
        Calculator calculator = Calculator.builder().loggingStrategy(loggingStrategy).build();  

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 5, -9);

        // Mail should be sent
        try {
        	calculator.add(listOfNumbers);
            calculator.sendResults();
            assertTrue("Mail sent successfully", true);

        } catch (Exception e) {
            fail("Mail not sent");
        }
    }
    
    @Test
    public void noLoggingStrategyTest() {

    	// Logging Strategy is not given
        Calculator calculator = Calculator.builder().build();  

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 5, -9);
        
        // Should throw exception for the test to pass
        try {
        	calculator.add(listOfNumbers);
        	calculator.sendResults();
        	fail("Calling the sendResults should throw exception");
        } catch (Exception e) {
        	assertTrue("Calling the sendResults threw exception as expected due to absence of LoggingStrategy",true);
        }
    }
}
