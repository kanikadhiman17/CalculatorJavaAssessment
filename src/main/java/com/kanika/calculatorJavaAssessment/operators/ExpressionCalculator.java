package com.kanika.calculatorJavaAssessment.operators;

import java.util.Arrays;
import java.util.Stack;

import com.kanika.calculatorJavaAssessment.Calculator;

public class ExpressionCalculator {
	
	public Integer calculateExpression(String expression, Calculator calculator)
	{
		try 
    	{
	        //TODO
	    	char[] tokens = expression.toCharArray(); 
	    	  
	        // Stack for numbers: 'values' 
	        Stack<Integer> values = new Stack<Integer>(); 
	 
	        // Stack for Operators: 'ops' 
	        Stack<Character> ops = new Stack<Character>(); 
	 
	        for (int i = 0; i < tokens.length; i++) 
	        { 
	            // Current token is a whitespace, skip it 
	            if (tokens[i] == ' ') 
	                continue; 
	 
	            // Current token is a number, push it to stack for numbers 
	            if (tokens[i] >= '0' && tokens[i] <= '9') 
	            { 
	                StringBuffer sbuf = new StringBuffer(); 
	                // There may be more than one digits in number 
	                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') 
	                    sbuf.append(tokens[i++]); 
	                values.push(Integer.parseInt(sbuf.toString())); 
	            } 
	 
	            // Current token is an opening brace, push it to 'ops' 
	            else if (tokens[i] == '(') 
	                ops.push(tokens[i]); 
	 
	            // Closing brace encountered, solve entire brace 
	            else if (tokens[i] == ')') 
	            { 
	                while (ops.peek() != '(') 
	                	values.push(applyOp(ops.pop(), values.pop(), values.pop(), calculator)); 

	                ops.pop(); 
	            } 
	 
	            // Current token is an operator. 
	            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') 
	            { 
	                // While top of 'ops' has same or greater precedence to current token, which is an operator. 
	            	// Apply operator on top of 'ops' to top two elements in values stack 
	                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) 
	                	values.push(applyOp(ops.pop(), values.pop(), values.pop(), calculator)); 

	                // Push current token to 'ops'. 
	                ops.push(tokens[i]); 
	            } 
	        } 
	 
	        // Entire expression has been parsed at this point, apply remaining ops to remaining values 
	        while (!ops.empty()) 
	            values.push(applyOp(ops.pop(), values.pop(), values.pop(), calculator)); 
	        
	        
	        // Top of 'values' contains result, return it 
	        int result = values.pop();
	        return result;
	       
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.toString());
    		throw new IllegalStateException();
    	}
	}
	
	public boolean hasPrecedence(char op1, char op2) 
    { 
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
            return false; 
        else
            return true; 
    } 
    
    public int applyOp(char op, int b, int a, Calculator calculator) 
    { 
        switch (op) 
        { 
        case '+': 
            return calculator.add(Arrays.asList(a,b)); 
        case '-': 
            return calculator.subtract(a,b); 
        case '*': 
            return calculator.multiply(Arrays.asList(a,b)); 
        case '/': 
            return calculator.divide(a,b); 
        } 
        return 0; 
    } 

}
