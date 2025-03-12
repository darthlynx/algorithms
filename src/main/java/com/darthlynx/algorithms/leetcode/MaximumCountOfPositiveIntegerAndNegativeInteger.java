package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/
public class MaximumCountOfPositiveIntegerAndNegativeInteger {

    // Time complexity: O(logN)
    // Space complexity: O(1)
    class Solution {
        public int maximumCount(int[] nums) {
            int neg = 0;
            int pos = 0;

            int negPos = findLastNegative(nums);
            neg = negPos + 1;
            int firstPos = findFirstPositive(nums);
            pos = nums.length - firstPos;

            return Math.max(pos, neg);
        }

        private int findLastNegative(int[] nums) {
            int bad = -1;
            int good = nums.length;

            while (good - bad > 1) {
                int mid = bad + (good - bad) / 2;
                if (nums[mid] >= 0) {
                    good = mid;
                } else {
                    bad = mid;
                }
            }

            return bad;
        }

        private int findFirstPositive(int[] nums) {
            int bad = -1;
            int good = nums.length;

            while (good - bad > 1) {
                int mid = bad + (good - bad) / 2;
                if (nums[mid] > 0) {
                    good = mid;
                } else {
                    bad = mid;
                }
            }

            return good;
        }
    }
}
