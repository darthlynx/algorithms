package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/largest-3-same-digit-number-in-string/
public class LargestThreeSameDigitNumberInString {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public String largestGoodInteger(String num) {
            String result = "";
            for (int i = 0; i < num.length() - 2; i++) {
                if (num.charAt(i) == num.charAt(i + 1)
                        && num.charAt(i) == num.charAt(i + 2)) {
                    result = getMax(result, num.substring(i, i + 3));
                }
            }
            return result;
        }

        private String getMax(String first, String second) {
            if (first.isEmpty()) {
                return second;
            }
            return Integer.valueOf(first) >= Integer.valueOf(second) ? first : second;
        }
    }
}
