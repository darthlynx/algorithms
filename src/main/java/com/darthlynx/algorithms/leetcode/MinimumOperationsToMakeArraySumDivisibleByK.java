package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/
public class MinimumOperationsToMakeArraySumDivisibleByK {

    // Time complexity: O(n + m)
    // Space complexity: O(1)
    class Solution1 {
        public int minOperations(int[] nums, int k) {
            int sum = 0;
            for (int n : nums) {
                sum += n;
            }

            int ops = 0;
            while (sum % k != 0) {
                sum--;
                ops++;
            }
            return ops;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution2 {
        public int minOperations(int[] nums, int k) {
            int sum = 0;
            for (int n : nums) {
                sum += n;
            }

            return sum % k;
        }
    }
}
