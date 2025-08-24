package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
public class LongestSubarrayOfOnesAfterDeletingOneElement {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public int longestSubarray(int[] nums) {
            int res = 0;
            int left = 0;
            int zero = 0;
            
            for (int right = 0; right < nums.length; right++) {
                if (nums[right] == 0) {
                    zero++;
                }

                // move left border
                while (zero > 1 && left <= right) {
                    if (nums[left] == 0) {
                        zero--;
                    }
                    left++;
                }

                res = Math.max(res, right - left);
            }

            return res;
        }
    }
}
