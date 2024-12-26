package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/target-sum/
public class TargetSum {

    // Time complexity: O(2 ^ n)
    // Space complexity: O(n)
    class Solution {
        private int sumWays = 0;
    
        public int findTargetSumWays(int[] nums, int target) {
            backtrack(0, 0, nums, target);
            return sumWays;
        }
    
        private void backtrack(int currentSum, int idx, int[] nums, int target) {
            if (idx == nums.length) {
                if (currentSum == target) {
                    sumWays++;
                }
                return;
            }
    
            int substructSum = currentSum + (-1) * nums[idx];
            backtrack(substructSum, idx + 1, nums, target);
            int addSum = currentSum + nums[idx];
            backtrack(addSum, idx + 1, nums, target);
        }
    }

}
