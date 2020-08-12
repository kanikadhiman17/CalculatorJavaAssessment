package com.kanika.calculatorJavaAssessment;

import com.kanika.calculatorJavaAssessment.logging.OperationsLogger;
import com.kanika.calculatorJavaAssessment.operators.Adder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorBasicTest {

    @Mock
    OperationsLogger operationsLogger;

    @InjectMocks
    Calculator calculator;

    @Test
    public void basicTestInDefaultMode() {

        Calculator calculator = Calculator.builder().build();
        
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 5, -9);

        Integer sum = calculator.add(listOfNumbers);
        assertEquals("The calculator should return usual sum", -1, (int)sum);
    }

    @Test
    public void customiseAdditionWhenAdderIsProvidedTest() {

        Adder myAdder = numbers -> numbers.size(); // A lambda which means that myAdder is an instance of Adder with given behavior
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 5, -9);

        Calculator calculator = Calculator.builder()
                .adder(myAdder)
                .calculationMode(CalculationMode.CUSTOM).build();

        // Addition behavior should be as specified by myAdder
        Integer sum = calculator.add(listOfNumbers);
        assertEquals("The calculator should return size of numbers passed as specified by myAdder", 4, (int)sum);

        // Multiplication behavior should remain same
        Integer product = calculator.multiply(listOfNumbers);
        assertEquals("The multiplication behavior should remain same", -90, (int)product);
        
        // Subtraction behavior should remain same
        Integer subtraction = calculator.subtract(5,10);
        assertEquals("The subtraction behavior should remain same", -5, (int)subtraction);
        
        // Multiplication behavior should remain same
        Integer division = calculator.divide(10,5);
        assertEquals("The division behavior should remain same", 2, (int)division);
    }
}
