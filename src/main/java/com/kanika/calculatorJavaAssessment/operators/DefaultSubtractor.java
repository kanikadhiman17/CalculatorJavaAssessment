package com.kanika.calculatorJavaAssessment.operators;

public class DefaultSubtractor implements Subtractor {
    @Override
    public Integer subtract(Integer a, Integer b) {
        // Subtracting the two integers a-b
    	if(a==null || b==null)
    		throw new IllegalStateException() ;
    	Integer sub;
    	sub=a-b;
    	return sub;
        //return null;
    }
}
