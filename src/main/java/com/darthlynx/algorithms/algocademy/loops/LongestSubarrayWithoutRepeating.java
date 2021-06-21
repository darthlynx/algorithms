package com.darthlynx.algorithms.algocademy.loops;

import java.util.Arrays;

public class LongestSubarrayWithoutRepeating {

    // Given an input array of integers,
    // find the length of the longest subarray without repeating integers.
    // O(n^3)
    public int longestSubarrayWithoutRepeating(int[] nums) {

        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int currentElem = nums[j];

                int[] subArray = Arrays.copyOfRange(nums, i, j);
                if (Arrays.stream(subArray).anyMatch(elem -> elem == currentElem)) {
                    break;
                }
                result = Math.max(result, (j-i+1));
            }
        }
        return result;
    }

}
