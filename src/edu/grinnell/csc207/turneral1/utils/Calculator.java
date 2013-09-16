package edu.grinnell.csc207.turneral1.utils;
import java.math.BigInteger;

public class Calculator {
    // Takes a string expression and calculates the value using a naive order
    //  of operations. 
    // Pre-conditions:
    //  Only the +, -, *, /, and ^ operands are supported.
    //  Only non-negative integers are supported.
    //  The numbers and operands are separated by spaces.
    // Post-conditions:
    //  Returns 
    public static BigInteger eval0 (String expr){
	BigInteger result = BigInteger.valueOf(0);
	char symbol = '+';
	
	while(expr.length() > 0) {
	    int num = 0, len;
	    
	    if (expr.indexOf(' ') != -1)
		len = expr.indexOf(' ');
	    else
		len = expr.length();
	    
	    for (int j = 0; j<len && expr.charAt(j) != ' '; j++)
		num += (expr.charAt(j)-48)*(Math.pow(10,len-j-1));
	    BigInteger bigNum = BigInteger.valueOf(num);
	    
	    switch (symbol) {
	    case '+':
		result = result.add(bigNum);
		break;
	    case '-':
		result = result.subtract(bigNum);
		break;
	    case '*':
		result = result.multiply(bigNum);
		break;
	    case '/':
		result = result.divide(bigNum);
		break;
	    case '^':
		result = result.pow(num);
		break;
	    } // switch
	    
	    if (expr.indexOf(' ') == -1)
		break;
	    
	    // store the next symbol
	    symbol = expr.charAt(expr.indexOf(' ')+1);
	    // moves to the next number
	    expr = expr.substring(expr.indexOf(' ')+3);
	} // while
	return result;
    } // eval0
} // Calculator
