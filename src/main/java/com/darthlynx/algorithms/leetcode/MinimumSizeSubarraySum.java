package com.darthlynx.algorithms.leetcode;


// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {

    // Time complexity: O(N)
    // Space complexity: O(1)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            
            int result = Integer.MAX_VALUE;
    
            int left = 0;
            int currSum = 0;
            for (int right = 0; right < nums.length; right++) {
                currSum += nums[right];
    
                while (currSum - nums[left] >= target && left <= right) {
                    currSum -= nums[left];
                    left++;
                }
    
                if (currSum >= target) {
                    result = Math.min(result, right - left + 1);
                }
            }
    
            return result == Integer.MAX_VALUE ? 0 : result;
        }
    }
}
