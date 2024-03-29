package com.darthlynx.algorithms.loops;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSumSubarrayIITest {

    @Test
    public void testMaxSumSubarray() {
        int[] arr = {-4, 5, 1, 0};
        int target = 6;

        int actualResult = new MaxSumSubarrayII().maxSumSubarray(arr);
        assertEquals(target, actualResult);
    }

    @Test
    public void testMaxSumSubarray2() {
        int[] arr = {8, -1, 3, 4};
        int target = 15;

        int actualResult = new MaxSumSubarrayII().maxSumSubarray(arr);
        assertEquals(target, actualResult);
    }

}