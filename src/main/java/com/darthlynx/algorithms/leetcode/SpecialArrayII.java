package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/special-array-ii/
public class SpecialArrayII {

    // Time complexity: O(n + m), where n = nums.length; m = queries.length;
    // Space complexity: O(n + m), where n = badCounts.length; m = ans.length = queries.length;
    class Solution {
        public boolean[] isArraySpecial(int[] nums, int[][] queries) {
            // count bad pairs
            int badCount = 0;
            int[] badCounts = new int[nums.length + 1];
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] % 2 == nums[i + 1] % 2) {
                    badCount++;
                }
                badCounts[i + 1] = badCount;
            }

            boolean[] ans = new boolean[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int start = queries[i][0];
                int end = queries[i][1];

                ans[i] = badCounts[end] - badCounts[start] == 0;
            }

            return ans;
        }
    }
}
