package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/
public class CountSubarraysOfLengthTreeWithACondition {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public int countSubarrays(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i + 2 < nums.length
                        && nums[i + 1] % 2 == 0
                        && (nums[i] + nums[i + 2]) == nums[i + 1] / 2) {
                    count++;
                }
            }
            return count;
        }
    }
}
