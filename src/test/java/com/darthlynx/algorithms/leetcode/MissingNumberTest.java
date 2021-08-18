package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MissingNumberTest {

    private static final MissingNumber test = new MissingNumber();

    @Test
    public void test1() {
        int[] nums = {3,0,1};
        int expectedResult = 2;

        assertEquals(expectedResult, test.missingNumber(nums));
    }

    @Test
    public void test2() {
        int[] nums = {0,1};
        int expectedResult = 2;

        assertEquals(expectedResult, test.missingNumber(nums));
    }

    @Test
    public void test3() {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int expectedResult = 8;

        assertEquals(expectedResult, test.missingNumber(nums));
    }

}