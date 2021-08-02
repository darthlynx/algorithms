package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplyStringsTest {

    private MultiplyStrings test = new MultiplyStrings();

    @Test
    public void test1() {
        String num1 = "2";
        String num2 = "3";
        String expectedResult = "6";

        String actualResult = test.multiply(num1, num2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test2() {
        String num1 = String.valueOf(Integer.MAX_VALUE);
        String num2 = "2";
        String expectedResult = "4294967294";

        String actualResult = test.multiply(num1, num2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test3() {
        String num1 = "0";
        String num2 = "2";
        String expectedResult = "0";

        String actualResult = test.multiply(num1, num2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test4() {
        String num1 = "123";
        String num2 = "456";
        String expectedResult = "56088";

        String actualResult = test.multiply(num1, num2);

        assertEquals(expectedResult, actualResult);
    }

}