package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/partition-equal-subset-sum/
public class PartitionEqualSubsetSum {

    // Time complexity: O(n * target)
    // Space complexity: O(target)
    class Solution {

        public boolean canPartition(int[] nums) {
            int totalSum = 0;
            for (int num : nums) {
                totalSum += num;
            }
            if (totalSum % 2 != 0) {
                return false;
            }

            int target = totalSum / 2;
            // dp[i] will be true if a subset with sum i can be formed
            // using elements seen so far
            boolean[] dp = new boolean[target + 1];
            dp[0] = true; // we can always add 0

            for (int num : nums) {
                for (int i = target; i >= num; i--) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }

            return dp[target];
        }
    }
}
