package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/
public class DivisibleAndNonDivisibleSumsDifference {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public int differenceOfSums(int n, int m) {
            int divisible = 0;
            int nonDivisible = 0;

            for (int i = 1; i <= n; i++) {
                if (i % m == 0) {
                    divisible += i;
                } else {
                    nonDivisible += i;
                }
            }

            return nonDivisible - divisible;
        }
    }
}
