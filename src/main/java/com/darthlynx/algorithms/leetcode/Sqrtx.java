package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/sqrtx/
public class Sqrtx {

    // Time complexity: O(logX)
    // Space complexity: O(1)
    class Solution {
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }

            long good = 1L;
            long bad = (long) x;

            while (bad - good > 1) {
                long mid = good + (bad - good) / 2;

                if (mid * mid <= (long) x) {
                    good = mid;
                } else {
                    bad = mid;
                }
            }
            return (int) good;
        }
    }
}
