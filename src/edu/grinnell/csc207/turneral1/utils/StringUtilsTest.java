package edu.grinnell.csc207.turneral1.utils;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void fewestCoinsTest() {
	assertArrayEquals(new int[]{}, StringUtils.fewestCoins(0));
	System.out.println(Arrays.toString(StringUtils.fewestCoins(28)));
	assertArrayEquals(new int[]{7,7,7,7}, StringUtils.fewestCoins(28));
    } // fewestCoinsTest

}
