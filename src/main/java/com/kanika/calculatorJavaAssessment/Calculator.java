package com.kanika.calculatorJavaAssessment;

import com.kanika.calculatorJavaAssessment.logging.OperationsLogger;
import com.kanika.calculatorJavaAssessment.operators.Adder;
import com.kanika.calculatorJavaAssessment.operators.DefaultAdder;
import com.kanika.calculatorJavaAssessment.operators.DefaultDivider;
import com.kanika.calculatorJavaAssessment.operators.DefaultMultiplier;
import com.kanika.calculatorJavaAssessment.operators.DefaultSubtractor;
import com.kanika.calculatorJavaAssessment.operators.Divider;
import com.kanika.calculatorJavaAssessment.operators.ExpressionCalculator;
import com.kanika.calculatorJavaAssessment.operators.Multiplier;
import com.kanika.calculatorJavaAssessment.operators.Subtractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Calculator {

    private Adder adder;
    private Subtractor subtractor;
    private Multiplier multiplier;
    private Divider divider;
    private LoggingStrategy loggingStrategy;
    private CalculationMode calculationMode;
    private List<Operation> operations;
    private OperationsLogger operationsLogger;

    public static class Builder {

        private Calculator calculator = new Calculator();

        public Calculator build() {   	
            return calculator;
        }

        public Builder adder(Adder adder) {
        	calculator.adder = adder;
            return this;
        }

        public Builder subtractor(Subtractor subtractor) {
            calculator.subtractor = subtractor;
            return this;
        }

        public Builder multiplier(Multiplier multiplier) {
            calculator.multiplier = multiplier;
            return this;
        }

        public Builder divider(Divider divider) {
            calculator.divider = divider;
            return this;
        }

        public Builder calculationMode(CalculationMode calculationMode) {
            calculator.calculationMode = calculationMode;
            return this;
        }

        public Builder loggingStrategy(LoggingStrategy loggingStrategy) {
            calculator.loggingStrategy = loggingStrategy;
            return this;
        }      
    }

    public Integer add(List<Integer> numbers) 
    {    	
    	// Check Mode and assign operation name, instantiate Default adder
		String operationName = null;
		if(calculationMode==null || adder==null) {
			operationName = "ADD";
			DefaultAdder defaultAdder = new DefaultAdder();
			this.adder = defaultAdder;
		}
		else if(calculationMode==CalculationMode.CUSTOM && adder!=null)
			operationName = "CUSTOM ADD";
		
		// Get Summation
		Integer sum = adder.add(numbers);
    	
    	// Instantiate the list operations if not done yet
		if(operations==null) {
			List<Operation> operations = new ArrayList<Operation>();
			this.operations = operations;
		}
		
		// Add to Operations
		for(int i=0;i<numbers.size()-1;i++)	{
			int currsum = adder.add(numbers.subList(0,i+1));
			Operation op=new Operation(currsum, adder.add(Arrays.asList(numbers.get(i+1))),operationName);			
			operations.add(op);
		}
		if(numbers.size()==1) {
			// Add 0 in operations if size of numbers is 1
			Operation op=new Operation(adder.add(Arrays.asList(numbers.get(0))),0,operationName);			
			operations.add(op); 
		}
		
		return sum;
    }

    public Integer subtract(Integer a, Integer b) {
    	
    	// Check Mode and assign operation name, instantiate Default subtractor
		String operationName = null;
		if(calculationMode==null || subtractor==null) {
			operationName = "SUB";
			DefaultSubtractor defaultSubtractor = new DefaultSubtractor();
			this.subtractor = defaultSubtractor;
		}
		else if(calculationMode==CalculationMode.CUSTOM && subtractor!=null)
			operationName = "CUSTOM SUB";
    	
    	// Get Subtraction
    	Integer sub = subtractor.subtract(a, b);
    	
    	// Instantiate the list operations if not done yet
    	if(operations==null) {
			List<Operation> operations = new ArrayList<Operation>();
			this.operations = operations;
		}
    	
		// Add to operations
		Operation op=new Operation(a,b,operationName);			
		operations.add(op); 			
		
    	return sub;
    }

    public Integer multiply(List<Integer> numbers) {
    	
    	// Check Mode and assign operation name, instantiate Default multiplier
		String operationName = null;
		if(calculationMode==null || multiplier==null) {
			operationName = "MUL";
			DefaultMultiplier defaultMultiplier = new DefaultMultiplier();
			this.multiplier = defaultMultiplier;
		}
		else if(calculationMode==CalculationMode.CUSTOM && multiplier!=null)
			operationName = "CUSTOM MUL";

    	// Get Multiplication
    	Integer mul = multiplier.multiply(numbers);

    	// Instantiate the list operations if not done yet
    	if(operations==null) {
			List<Operation> operations = new ArrayList<Operation>();
			this.operations = operations;
		}
    	
    	// Add to operations
		for(int i=0;i<numbers.size()-1;i++)	{
			int currmul = multiplier.multiply(numbers.subList(0,i+1));
			Operation op=new Operation(currmul, multiplier.multiply(Arrays.asList(numbers.get(i+1))),operationName);			
			operations.add(op);
		}
		if(numbers.size()==1) {
			Operation op=new Operation(multiplier.multiply(Arrays.asList(numbers.get(0))),1,operationName);			
			operations.add(op); 
		}	
    	
    	return mul;
    }

    public Integer divide(Integer a, Integer b) {
    	
    	// Check Mode and assign operation name, instantiate Default divider
		String operationName = null;
		if(calculationMode==null || divider==null) {
			operationName = "DIV";
			DefaultDivider defaultDivider = new DefaultDivider();
			this.divider = defaultDivider;
		}
		else if(calculationMode==CalculationMode.CUSTOM && divider!=null)
			operationName = "CUSTOM DIV";

    	// Get Division
    	Integer div = divider.divide(a, b);
    	
    	// Instantiate the list operations if not done yet
    	if(operations==null) {
			List<Operation> operations = new ArrayList<Operation>();
			this.operations = operations;
		}    	
    	
    	// Add to operations
		Operation op=new Operation(a, b, operationName);
		operations.add(op);
    	
    	return div;
    }

    public void sendResults() {
    	if(loggingStrategy == null)
    		throw new NullPointerException();
 
    	// Instantiate operationsLogger and call operationsLogger 
    	if(operationsLogger==null) {
    		OperationsLogger operationsLogger = new OperationsLogger();
    		this.operationsLogger = operationsLogger;
    	}    	
        operationsLogger.logOperations(operations, loggingStrategy);
    }


    public Integer calculate(String expression, Calculator calculator) {	
    	// Call function calculateExpression to calculate the expression
    	ExpressionCalculator expCalculator = new ExpressionCalculator();
    	return expCalculator.calculateExpression(expression, calculator);
    }

	public static Builder builder() {
        return new Builder();
    }     
}