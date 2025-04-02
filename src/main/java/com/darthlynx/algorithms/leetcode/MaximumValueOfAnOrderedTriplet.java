package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/
public class MaximumValueOfAnOrderedTriplet {

    // Time complexity: O(n^3)
    // Space complexity: O(1)
    class Solution1 {
        public long maximumTripletValue(int[] nums) {
            long maxTriplet = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        long triplet = (long) (nums[i] - nums[j]) * nums[k];
                        maxTriplet = Math.max(maxTriplet, triplet);
                    }
                }
            }
            return maxTriplet;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution2 {
        public long maximumTripletValue(int[] nums) {
            int n = nums.length;

            long biggest = 0;
            long biggestDiff = 0;
            long maxTriplet = 0;

            for (int i = 0; i < n; i++) {
                maxTriplet = Math.max(maxTriplet, biggestDiff * nums[i]);
                biggest = Math.max(biggest, nums[i]);
                biggestDiff = Math.max(biggestDiff, biggest - nums[i]);
            }

            return maxTriplet;
        }
    }
}
