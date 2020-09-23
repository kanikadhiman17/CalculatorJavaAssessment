package com.kanika.calculatorJavaAssessment.operators;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultAdder implements Adder{
    @Override
    public Integer add(List<Integer> numbers) {
    	// Adding the numbers in the list
    	
    	if(numbers.isEmpty())
    		throw new IllegalStateException();

    	// Generalized Method
		/*Integer sum=0;
		for(int i=0; i<numbers.size(); i++)
    		sum+=numbers.get(i);

    	return sum;*/

		// Using Lambdas
    	AtomicReference<Integer> sum = new AtomicReference<>(0);
    	numbers.forEach(i -> sum.updateAndGet(v -> v + i));

    	return sum.get();
    }
}
