package com.kanika.calculatorJavaAssessment.operators;

import java.util.concurrent.atomic.AtomicReference;

public class DefaultSubtractor implements Subtractor {
    @Override
    public Integer subtract(Integer a, Integer b) {
        // Subtracting the two integers a-b
    	if(a==null || b==null)
    		throw new IllegalStateException() ;
    	return a-b;
    }
}
