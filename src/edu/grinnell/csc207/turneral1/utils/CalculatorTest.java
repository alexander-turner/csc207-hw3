package edu.grinnell.csc207.turneral1.utils;

import static org.junit.Assert.*;

import org.junit.Test;
import java.math.BigInteger;

public class CalculatorTest {

    @Test
    public void test() {
	assertEquals(BigInteger.valueOf(0), Calculator.eval0("0"));
	assertEquals(BigInteger.valueOf(9005), Calculator.eval0("1 + 2 + 2 + 9000"));
	assertEquals(BigInteger.valueOf(10), Calculator.eval0("1 + 2 + 7"));
	assertEquals(BigInteger.valueOf(4), Calculator.eval0("1 + 2 * 3 - 5"));
	assertEquals(BigInteger.valueOf(2), Calculator.eval0("10 / 5"));
	// Test a very big number!
	BigInteger bigNum = BigInteger.valueOf((long) Math.pow(2,62));
	bigNum = bigNum.multiply(BigInteger.valueOf(4));
	assertEquals(bigNum, Calculator.eval0("2 ^ 64"));
    } // test
}
