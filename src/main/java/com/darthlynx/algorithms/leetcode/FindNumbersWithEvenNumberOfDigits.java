package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class FindNumbersWithEvenNumberOfDigits {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public int findNumbers(int[] nums) {
            int count = 0;
            for (int num : nums) {
                if (hasEvenNumberOfDigits(num)) {
                    count++;
                }
            }
            return count;
        }

        private boolean hasEvenNumberOfDigits(int num) {
            int count = 0;
            while (num > 0) {
                count++;
                num /= 10;
            }
            return count % 2 == 0;
        }
    }
}
