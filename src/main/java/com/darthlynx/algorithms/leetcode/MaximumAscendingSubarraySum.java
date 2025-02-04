package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/maximum-ascending-subarray-sum/
public class MaximumAscendingSubarraySum {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {

        public int maxAscendingSum(int[] nums) {
            int currSum = nums[0];
            int maxSum = currSum;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    currSum += nums[i];
                } else {
                    currSum = nums[i];
                }
                maxSum = Math.max(maxSum, currSum);
            }
            return maxSum;
        }
    }

}
