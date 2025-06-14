package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/
public class MaximumDifferenceByRemappingADigit {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public int minMaxDifference(int num) {
            char[] digits = Integer.toString(num).toCharArray();

            // find first non 9
            int digit = digits[0] - '0';
            for (int i = 0; i < digits.length; i++) {
                digit = digits[i] - '0';
                if (digit == 9) {
                    continue;
                }
                break;
            }
            // form max
            int max = 0;
            int min = 0;
            int firstDigit = digits[0] - '0';
            for (int i = 0; i < digits.length; i++) {
                int d = digits[i] - '0';
                max = max * 10 + (d == digit ? 9 : d);
                min = min * 10 + (d == firstDigit ? 0 : d);
            }

            return max - min;
        }
    }
}
