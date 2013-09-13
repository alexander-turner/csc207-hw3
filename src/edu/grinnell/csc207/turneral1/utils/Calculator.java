package edu.grinnell.csc207.turneral1.utils;
import java.math.BigInteger;

public class Calculator {
    public static BigInteger eval0 (String expr){
	BigInteger result = BigInteger.valueOf(0);
	char symbol = '+';
	
	while(expr.length() > 0 && expr.indexOf(' ') != -1) {
	    int num = 0;
	    
	    for (int j = 0; j<expr.length() && expr.charAt(j) != ' '; j++)
		num += (expr.charAt(j)-48)*(Math.pow(10,expr.indexOf(' ')-j-1));

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
	    
	    // store the next symbol
	    symbol = expr.charAt(expr.indexOf(' ')+1);
	    System.out.println(expr);
	    // moves to the next number
	    expr = expr.substring(expr.indexOf(' ')+3);
	} // while
	return result;
    } // eval0
} // Calculator
