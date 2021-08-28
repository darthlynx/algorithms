package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumProductSubarrayTest {

    private MaximumProductSubarray test = new MaximumProductSubarray();

    @Test
    public void test1() {
        int[] nums = {-3,0,2,-2};
        int expectedResult = 2;

        int actualResult = test.maxProduct(nums);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test2() {
        int[] nums = {-1,-1,0};
        int expectedResult = 1;

        int actualResult = test.maxProduct(nums);

        assertEquals(expectedResult, actualResult);
    }

}