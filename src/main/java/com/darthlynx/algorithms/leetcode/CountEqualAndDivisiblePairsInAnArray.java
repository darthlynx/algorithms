package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/
public class CountEqualAndDivisiblePairsInAnArray {

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    class Solution {
        public int countPairs(int[] nums, int k) {
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j] && (i * j) % k == 0) {
                        count++;
                    }
                }
            }

            return count;
        }
    }
}
