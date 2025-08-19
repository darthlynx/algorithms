package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/number-of-zero-filled-subarrays/
public class NumberOfZeroFilledSubarrays {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public long zeroFilledSubarray(int[] nums) {
            long zeros = 0;
            long res = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeros++;
                    res += zeros;
                } else {
                    zeros = 0;
                }
            }
            return res;
        }
    }
}
