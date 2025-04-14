package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/count-good-triplets/
public class CountGoodTriplets {

    // Time complexity: O(n^3)
    // Space complexity: O(1)
    class Solution {
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int n = arr.length;
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (isGood(arr, a, b, c, i, j, k)) {
                            count++;
                        }
                    }
                }
            }
            return count;
        }

        private boolean isGood(int[] arr, int a, int b, int c, int i, int j, int k) {
            return Math.abs(arr[i] - arr[j]) <= a
                    && Math.abs(arr[j] - arr[k]) <= b
                    && Math.abs(arr[i] - arr[k]) <= c;
        }
    }

}
