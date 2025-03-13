package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/zero-array-transformation-ii/
public class ZeroArrayTransformationII {

    // Time complexity: O((M+N)logM)
    // Space complexity: O(N),
    // where N = nums.length; M = queries.length;
    class Solution {
        public int minZeroArray(int[] nums, int[][] queries) {
            int bad = -1;
            int good = queries.length;

            if (!canMakeZeroArray(nums, queries, good)) {
                return -1;
            }

            while (good - bad > 1) {
                int mid = bad + (good - bad) / 2;
                if (canMakeZeroArray(nums, queries, mid)) {
                    good = mid;
                } else {
                    bad = mid;
                }
            }

            return good;
        }

        private boolean canMakeZeroArray(int[] nums, int[][] queries, int k) {
            // difference array approach
            // instead of applying changes to all elements in the range
            // we are changing boundaries: left += value, right+1 -= value
            // Therefore, prefix sum will give the same result as if you would apply values one by one
            int[] diffArray = new int[nums.length + 1];

            for (int i = 0; i < k; i++) {
                int left = queries[i][0];
                int right = queries[i][1];
                int value = queries[i][2];

                diffArray[left] += value;
                diffArray[right + 1] -= value;
            }

            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += diffArray[i];
                if (sum < nums[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
