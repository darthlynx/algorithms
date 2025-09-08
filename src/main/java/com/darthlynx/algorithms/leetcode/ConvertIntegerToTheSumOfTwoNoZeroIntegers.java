package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

    // Time complexity: O(n*logn)
    // Space complexity: O(1)
    class Solution {
        public int[] getNoZeroIntegers(int n) {
            int a = 1;
            int b = n - 1;

            while (hasZeros(a) || hasZeros(b)) {
                b--;
                a++;
            }

            return new int[] { a, b };
        }

        private boolean hasZeros(int x) {
            while (x > 0) {
                if (x % 10 == 0) {
                    return true;
                }
                x = x / 10;
            }
            return false;
        }
    }
}
