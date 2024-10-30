package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {

    // Space complexity: O(n)
    // Time complexity: O(n^2)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
    
            int[] lisLength = new int[n];
            Arrays.fill(lisLength, 1);
    
            for (int i = 0; i < n; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        lisLength[i] = Math.max(lisLength[i], lisLength[j] + 1);
                    }
                }
            }
    
            int longest = 0;
    
            for (int i = 0; i < n; i++) {
                longest = Math.max(longest, lisLength[i]);
            }
    
            return longest;
        }
    }

}
