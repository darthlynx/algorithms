package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/longest-nice-subarray/
public class LongestNiceSubarray {

    // Time complexity: O(N)
    // Space complexity: O(1)
    class Solution {
        public int longestNiceSubarray(int[] nums) {
            int bitmask = 0;
            int longest = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                // reducing the size of the window until we don't have bits conflict
                while ((bitmask & nums[right]) != 0) {
                    bitmask = bitmask ^ nums[left];
                    left++;
                }
                // add current number to the window
                bitmask = bitmask | nums[right];
                longest = Math.max(longest, right - left + 1);
            }
            return longest;
        }
    }
}
