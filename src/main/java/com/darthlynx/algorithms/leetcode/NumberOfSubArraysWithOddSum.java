package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
public class NumberOfSubArraysWithOddSum {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {

        private static final int MOD = 1_000_000_007;

        public int numOfSubarrays(int[] arr) {
            int currSum = 0;
            int oddCount = 0;
            int evenCount = 0;
            int res = 0;

            for (int num : arr) {
                currSum += num;

                if (currSum % 2 == 0) { // even
                    res = (res + oddCount) % MOD;
                    evenCount++;
                } else { // odd
                    // +1 to add current odd sum to the result
                    // + all even sums because odd + even == odd
                    res = (res + 1 + evenCount) % MOD;
                    oddCount++;
                }
            }

            return res;
        }
    }
}
