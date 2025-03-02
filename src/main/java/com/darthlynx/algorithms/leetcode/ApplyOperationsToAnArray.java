package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/apply-operations-to-an-array/
public class ApplyOperationsToAnArray {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public int[] applyOperations(int[] nums) {

            // apply operation
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    nums[i] = 2 * nums[i];
                    nums[i + 1] = 0;
                }
            }

            // shift zeroes
            int[] res = new int[nums.length];
            int idx = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    res[idx] = nums[i];
                    idx++;
                }
            }

            return res;
        }
    }
}
