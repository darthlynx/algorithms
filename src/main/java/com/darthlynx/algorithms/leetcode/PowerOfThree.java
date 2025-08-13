package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/power-of-three/
public class PowerOfThree {

    // Time complexity: O(logn)
    // Space complexity: O(1)
    class Solution {
        public boolean isPowerOfThree(int n) {
            long res = 1;
            while (res < n) {
                res *= 3;
            }
            return res == n;
        }
    }
}
