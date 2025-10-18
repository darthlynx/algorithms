package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/
public class MaximumNumberOfDistinctElementsAfterOperations {

    // Time complexity: O(N*logN)
    // Space complexity: O(logN)
    class Solution {
        public int maxDistinctElements(int[] nums, int k) {
            Arrays.sort(nums);
            int distinctNum = 0;

            int prev = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int current = Math.min(
                        Math.max(nums[i] - k, prev + 1),
                        nums[i] + k);
                if (current > prev) {
                    distinctNum++;
                    prev = current;
                }
            }

            return distinctNum;
        }
    }
}
