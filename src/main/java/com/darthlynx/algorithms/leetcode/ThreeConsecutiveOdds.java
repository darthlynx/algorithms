package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/three-consecutive-odds/
public class ThreeConsecutiveOdds {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public boolean threeConsecutiveOdds(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 2; i++) {
                if (isOdd(arr[i]) && isOdd(arr[i+1]) && isOdd(arr[i+2])) {
                    return true;
                }
            }
            return false;
        }

        private boolean isOdd(int num) {
            return num % 2 != 0;
        }
    }
}
