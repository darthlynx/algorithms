package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/zero-array-transformation-i/
public class ZeroArrayTransformation {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public boolean isZeroArray(int[] nums, int[][] queries) {
            int n = nums.length;
            int[] diff = new int[n + 1];

            // apply queries to difference array
            for (int[] query : queries) {
                int left = query[0];
                int right = query[1];
                diff[left] -= 1;
                diff[right + 1] += 1;
            }

            // calculate prefix sum on the diff array
            int[] prefixSum = new int[n + 1];
            prefixSum[0] = diff[0];
            for (int i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i - 1] + diff[i];
            }

            // calculate the sum of nums[i] and prefixSum[i]
            // if value is higher than 0, we cannot form the zero value array
            for (int i = 0; i < n; i++) {
                if (prefixSum[i] + nums[i] > 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
