package com.darthlynx.algorithms.algocademy.loops;

import java.util.HashSet;
import java.util.Set;

public class LongestSubarrayWithoutRepeatingII {

    // Given an input array of integers,
    // find the length of the longest subarray without repeating integers.
    // O(n^2)
    public int longestSubarrayWithoutRepeating(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> uniqueNumbers = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                int currentValue = nums[j];
                if (uniqueNumbers.contains(currentValue)) {
                    break;
                } else {
                    uniqueNumbers.add(currentValue);
                    result = Math.max(result, (j-i+1));
                }
            }
        }

        return result;
    }
}
