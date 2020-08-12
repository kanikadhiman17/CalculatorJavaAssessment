package com.kanika.calculatorJavaAssessment.operators;

import java.util.List;

public class DefaultMultiplier implements Multiplier {
    @Override
    public Integer multiply(List<Integer> numbers) {
    	// Multiplying the numbers in the list
    	if(numbers.isEmpty())
    		throw new IllegalStateException() ;
    	
    	Integer mul=1;
    	for(int i=0; i<numbers.size(); i++)
    		mul*=numbers.get(i);
    	return mul;
    }
}
