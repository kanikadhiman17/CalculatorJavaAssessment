package com.kanika.calculatorJavaAssessment.operators;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultMultiplier implements Multiplier {
    @Override
    public Integer multiply(List<Integer> numbers) {
    	// Multiplying the numbers in the list
    	if(numbers.isEmpty())
    		throw new IllegalStateException() ;
    	
    	// Generalized Method
    	/*Integer mul=1;
    	for(int i=0; i<numbers.size(); i++)
    		mul.updateAndGet(v -> v * numbers.get(i));
    	return mul;*/

		// Using Lambdas
		/*AtomicReference<Integer> mul= new AtomicReference<>(1);
    	numbers.forEach(i -> mul.updateAndGet(v -> v * i));
    	return mul.get();*/

    	// Using Stream
		return numbers.stream().reduce(1, (a,b)->a*b);

	}
}
