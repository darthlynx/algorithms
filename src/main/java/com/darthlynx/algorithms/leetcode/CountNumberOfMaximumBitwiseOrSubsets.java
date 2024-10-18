package com.darthlynx.algorithms.leetcode;


// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
public class CountNumberOfMaximumBitwiseOrSubsets {

    // without memoization
    class Solution {
        public int countMaxOrSubsets(int[] nums) {
            
            int maxOr = 0;
    
            // max OR is the one calculated for entire array
            for (int num : nums) {
                maxOr |= num;
            }
    
            return countSubsetWithTargetOr(nums, 0, 0, maxOr);        
        }
    
        private int countSubsetWithTargetOr(int[] nums, int index, int currentOr, int maxOr) {
            if (index >= nums.length) {
                return currentOr == maxOr ? 1 : 0;
            }
    
            // including current number
            int include = countSubsetWithTargetOr(nums, index + 1, currentOr | nums[index], maxOr);
    
            // not including current number
            int exclude = countSubsetWithTargetOr(nums, index + 1, currentOr, maxOr);
    
            return include + exclude;
        }
    }

    // with memoization
    class Solution2 {
        public int countMaxOrSubsets(int[] nums) {
            
            int maxOr = 0;
    
            // max OR is the one calculated for entire array
            for (int num : nums) {
                maxOr |= num;
            }
    
            Integer[][] memo = new Integer[nums.length][maxOr + 1];
    
            return countSubsetWithTargetOr(nums, 0, 0, maxOr, memo);        
        }
    
        private int countSubsetWithTargetOr(int[] nums, int index, int currentOr, int maxOr, Integer[][] memo) {
            if (index >= nums.length) {
                return currentOr == maxOr ? 1 : 0;
            }
    
            if (memo[index][currentOr] != null) {
                return memo[index][currentOr];
            }
    
            // including current number
            int include = countSubsetWithTargetOr(nums, index + 1, currentOr | nums[index], maxOr, memo);
    
            // not including current number
            int exclude = countSubsetWithTargetOr(nums, index + 1, currentOr, maxOr, memo);
    
            memo[index][currentOr] = include + exclude;
    
            return memo[index][currentOr];
        }
    
    }
}
