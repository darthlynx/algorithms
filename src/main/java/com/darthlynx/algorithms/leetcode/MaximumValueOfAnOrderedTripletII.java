package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/
public class MaximumValueOfAnOrderedTripletII {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public long maximumTripletValue(int[] nums) {
            long max = 0;
            long maxDiff = 0;
            long maxTriplet = 0;

            for (int i = 0; i < nums.length; i++) {
                maxTriplet = Math.max(maxTriplet, maxDiff * nums[i]);
                max = Math.max(max, nums[i]);
                maxDiff = Math.max(maxDiff, max - nums[i]);
            }

            return maxTriplet;
        }
    }
}
