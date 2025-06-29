package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    // Time complexity: O(N * logN)
    // Space complexity: O(N)
    class Solution {

        private static final int MODULO = 1_000_000_007;

        public int numSubseq(int[] nums, int target) {
            Arrays.sort(nums);

            // precompute power of 2
            int[] pow2 = new int[nums.length];
            pow2[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                pow2[i] = (pow2[i - 1] * 2) % MODULO;
            }

            int res = 0;
            for (int left = 0; left < nums.length; left++) {
                int right = binarySearch(nums, left, target);
                // calculate subsequences
                if (right >= left) {
                    res = (res + pow2[right - left]) % MODULO;
                }
            }

            return res;
        }

        private int binarySearch(int[] nums, int left, int target) {
            int good = left - 1;
            int bad = nums.length;

            while (bad - good > 1) {
                int mid = good + (bad - good) / 2;
                if (nums[left] + nums[mid] <= target) {
                    good = mid;
                } else {
                    bad = mid;
                }
            }

            return good;
        }
    }
}
