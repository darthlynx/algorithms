package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/shuffle-the-array/
public class ShuffleTheArray {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public int[] shuffle(int[] nums, int n) {
            int[] res = new int[2 * n];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                res[idx] = nums[i];
                idx += 2;
            }
            idx = 1;
            for (int i = n; i < 2 * n; i++) {
                res[idx] = nums[i];
                idx += 2;
            }
            return res;
        }
    }
}
