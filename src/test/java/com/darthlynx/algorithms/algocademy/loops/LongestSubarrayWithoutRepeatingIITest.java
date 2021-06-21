package com.darthlynx.algorithms.algocademy.loops;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubarrayWithoutRepeatingIITest {

    @Test
    public void testLongestSubarray() {
        int[] nums = {2, 5, 6, 2, 3, 1, 5, 6};
        int targetLength = 5;

        int actualLength = new LongestSubarrayWithoutRepeatingII().longestSubarrayWithoutRepeating(nums);
        assertEquals(targetLength, actualLength);
    }

}