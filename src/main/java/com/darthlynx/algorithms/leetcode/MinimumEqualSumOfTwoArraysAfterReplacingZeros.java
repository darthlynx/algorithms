package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/
public class MinimumEqualSumOfTwoArraysAfterReplacingZeros {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public long minSum(int[] nums1, int[] nums2) {
            long zero1 = 0;
            long sum1 = 0;
            for (int num : nums1) {
                sum1 += num;
                if (num == 0) {
                    zero1++;
                }
            }

            long zero2 = 0;
            long sum2 = 0;
            for (int num : nums2) {
                sum2 += num;
                if (num == 0) {
                    zero2++;
                }
            }

            long first = sum1 + zero1;
            long second = sum2 + zero2;

            if (zero2 == 0 && first > second || zero1 == 0 && second > first) {
                return -1;
            }

            return Math.max(first, second);
        }
    }
}
