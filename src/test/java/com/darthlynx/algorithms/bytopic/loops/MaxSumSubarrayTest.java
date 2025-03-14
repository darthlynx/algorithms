package com.darthlynx.algorithms.bytopic.loops;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.darthlynx.algorithms.bytopic.loops.MaxSumSubarray;

public class MaxSumSubarrayTest {

    @Test
    public void testMaxSumSubarray() {
        int[] nums = {-2, -5, 6, -2, -3, 1, 5, -6};
        int expectedResult = 7;

        int actualResult = new MaxSumSubarray().maxSumSubarray(nums);
        assertEquals(expectedResult, actualResult);
    }

}