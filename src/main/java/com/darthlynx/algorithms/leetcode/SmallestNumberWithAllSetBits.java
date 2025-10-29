package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/smallest-number-with-all-set-bits/
public class SmallestNumberWithAllSetBits {

    // Time complexity: O(log n)
    // Space complexity: O(1)
    class Solution {
        // all power of two numbers have only one leading bit set to 1
        // if we take away 1 from the next power of two number,
        // we will get a number with all bits set to 1
        public int smallestNumber(int n) {
            int k = 2;
            int pow = 0;
            for (int i = 0; i < 100; i++) {
                pow = (int) (Math.pow(k, i));
                if (pow > n) {
                    break;
                }
            }
            return pow - 1;
        }
    }
}
