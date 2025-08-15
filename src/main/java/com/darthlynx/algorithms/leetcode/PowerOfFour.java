package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/power-of-four/
public class PowerOfFour {

    // Time complexity: O(logn)
    // Space complexity: O(1)
    class Solution {
        public boolean isPowerOfFour(int n) {
            long res = 1;
            while (res < n) {
                res *= 4;
            }
            return res == n;
        }
    }
}
