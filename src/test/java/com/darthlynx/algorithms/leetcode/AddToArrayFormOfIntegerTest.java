package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AddToArrayFormOfIntegerTest {

    private final AddToArrayFormOfInteger test = new AddToArrayFormOfInteger();

    @Test
    public void testSimpleExample() {
        int[] num = {1,2,0,0}; // representation of 1200
        int k = 34;

        List<Integer> expectedResult = Arrays.asList(1,2,3,4); // representation of 1234
        List<Integer> actualResult = test.addToArrayForm(num, k);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddIfNumIsNull() {
        int[] num = null;
        int k = 34;

        List<Integer> expectedResult = Arrays.asList(3,4);
        List<Integer> actualResult = test.addToArrayForm(num, k);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddIfNumIsEmpty() {
        int[] num = new int[0];
        int k = 34;

        List<Integer> expectedResult = Arrays.asList(3,4);
        List<Integer> actualResult = test.addToArrayForm(num, k);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddMoreDigit() {
        int[] num = {9,9};
        int k = 1;

        List<Integer> expectedResult = Arrays.asList(1,0,0);
        List<Integer> actualResult = test.addToArrayForm(num, k);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddNumberBiggerThanArrayLength() {
        int[] num = {0};
        int k = 23;

        List<Integer> expectedResult = Arrays.asList(2,3);
        List<Integer> actualResult = test.addToArrayForm(num, k);

        assertEquals(expectedResult, actualResult);
    }


}