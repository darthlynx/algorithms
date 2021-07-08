package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReversedIntegerTest {

    @Test
    public void testPositiveInt() {
        int x = 123;
        int expectedResult = 321;

        int actualResult = new ReversedInteger().reverse(x);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNegativeInt() {
        int x = -123;
        int expectedResult = -321;

        int actualResult = new ReversedInteger().reverse(x);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testBigPositiveInt() {
        int x = Integer.MAX_VALUE;
        int expectedResult = 0;

        int actualResult = new ReversedInteger().reverse(x);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testBigNegativeInt() {
        int x = Integer.MIN_VALUE;
        int expectedResult = 0;

        int actualResult = new ReversedInteger().reverse(x);

        assertEquals(expectedResult, actualResult);
    }

}