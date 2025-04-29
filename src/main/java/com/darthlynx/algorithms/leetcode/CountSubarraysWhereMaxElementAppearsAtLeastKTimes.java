package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public long countSubarrays(int[] nums, int k) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            long result = 0;
            int maxCount = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                if (nums[right] == max) {
                    maxCount++;
                }
                while (maxCount >= k) {
                    result += nums.length - right;
                    if (nums[left] == max) {
                        maxCount--;
                    }
                    left++;
                }

            }
            return result;
        }
    }
}
