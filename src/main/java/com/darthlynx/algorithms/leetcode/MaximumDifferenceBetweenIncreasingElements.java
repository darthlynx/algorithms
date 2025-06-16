package com.darthlynx.algorithms.leetcode;

//
public class MaximumDifferenceBetweenIncreasingElements {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public int maximumDifference(int[] nums) {
            int max = -1;
            int localMin = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < localMin) {
                    localMin = nums[i];
                }
                if (nums[i] == localMin) {
                    continue;
                } else {
                    max = Math.max(max, nums[i] - localMin);
                }
            }

            return max;
        }
    }
}
