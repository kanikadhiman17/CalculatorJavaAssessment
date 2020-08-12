package com.kanika.calculatorJavaAssessment.operators;

public class DefaultDivider implements Divider {
    @Override
    public Integer divide(Integer a, Integer b) {
        // Dividing two numbers a/b
    	if(a==null || b==null || b==0)
    		throw new IllegalStateException();
    	
    	Integer div;
		div=a/b;
		return div;
        //return null;
    }
}
