package com.kanika.calculatorJavaAssessment.operators;

import java.util.List;

public class DefaultAdder implements Adder{
    @Override
    public Integer add(List<Integer> numbers) {
    	// Adding the numbers in the list
    	
    	if(numbers.isEmpty())
    		throw new IllegalStateException();
    		
    	Integer sum=0;
    	for(int i=0; i<numbers.size(); i++)
    		sum+=numbers.get(i);
    	return sum;
    }
}
