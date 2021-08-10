package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumSubarrayTest {

    private MaximumSubarray test = new MaximumSubarray();

    @Test
    public void test1() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int expectedMaxSum = 6;

        int actualMaxSum = test.maxSubArray(nums);
        assertEquals(expectedMaxSum, actualMaxSum);
    }

    @Test
    public void test2() {
        int[] nums = {1};
        int expectedMaxSum = 1;

        int actualMaxSum = test.maxSubArray(nums);
        assertEquals(expectedMaxSum, actualMaxSum);
    }

    @Test
    public void test3() {
        int[] nums = {5,4,-1,7,8};
        int expectedMaxSum = 23;

        int actualMaxSum = test.maxSubArray(nums);
        assertEquals(expectedMaxSum, actualMaxSum);
    }

}