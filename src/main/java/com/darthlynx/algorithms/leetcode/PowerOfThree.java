package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/power-of-three/
public class PowerOfThree {

    // Time complexity: O(logn)
    // Space complexity: O(1)
    class Solution {
        public boolean isPowerOfThree(int n) {
            long res = 1;
            while (res <= n) {
                if (res == n) {
                    return true;
                }
                res *= 3;
            }
            return false;
        }
    }
}
