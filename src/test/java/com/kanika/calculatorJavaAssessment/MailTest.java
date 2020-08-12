package com.kanika.calculatorJavaAssessment;

import static org.junit.Assert.assertEquals;
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

        LoggingStrategy loggingStrategy = new LoggingStrategy("xyz@gmail.com", FileFormat.docx);
        Calculator calculator = Calculator.builder().loggingStrategy(loggingStrategy).build();
        

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 5, -9);

        Integer sum = calculator.add(listOfNumbers);
        
        try {
            assertEquals("The calculator should return usual sum", -1, (int)sum);
            calculator.sendResults();
            assertTrue("Mail sent successfully", true);

        } catch (Exception e) {
            fail("Mail not sent");
        }
    }
}
