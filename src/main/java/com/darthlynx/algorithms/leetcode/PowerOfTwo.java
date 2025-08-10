package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/power-of-two/
public class PowerOfTwo {

    // Time complexity: O(logN)
    // Space complexity: O(1)
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n < 1) {
                return false;
            }
            while (n > 1) {
                if (n % 2 != 0) {
                    return false;
                }
                n = n >> 1;
            }
            return true;
        }
    }
}
