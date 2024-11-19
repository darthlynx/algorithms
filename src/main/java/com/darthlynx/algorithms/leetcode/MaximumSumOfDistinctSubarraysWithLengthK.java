package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
public class MaximumSumOfDistinctSubarraysWithLengthK {

    // Time complexity: O(N)
    // Space complexity: O(N)
    class Solution {
        
        public long maximumSubarraySum(int[] nums, int k) { 
            Map<Integer, Integer> map = new HashMap<>();
            int left = 0;
            long maxSum = 0;
            long curSum = 0;
    
            for (int right = 0; right < nums.length; right++) {
                curSum += nums[right];
                while (right - left + 1 > k) {
                    curSum -= nums[left];
                    int freq = map.get(nums[left]) - 1;
                    if (freq >= 1) {
                        map.put(nums[left], freq);
                    } else {
                        map.remove(nums[left]);
                    }
                    left++;
                }
    
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
    
                if (right - left + 1 == k && map.size() == k) {
                    maxSum = Math.max(maxSum, curSum);
                }
            }
    
            return maxSum;
        }
    }
}
