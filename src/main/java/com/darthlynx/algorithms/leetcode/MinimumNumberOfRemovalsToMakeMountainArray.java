package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/
public class MinimumNumberOfRemovalsToMakeMountainArray {

    // Time complexity: O(n^2)
    // Space complexity: O(n)
    class Solution {
        public int minimumMountainRemovals(int[] nums) {
            int n = nums.length;
    
            int[] lisLength = longestIncreasingSubsequence(nums);
            int[] ldsLength = longestDecreasingSubsequence(nums);
            
            int minRemovals = Integer.MAX_VALUE;
    
            for (int i = 0; i < n; i++) {
                if (lisLength[i] > 1 && ldsLength[i] > 1) {
                    // total number of numbers (n) is equals to sum of longest increasing subsequence,
                    // longest decreasing subsequence, current element (+1) and elements which we need to remove (minRemovals) 
                    minRemovals = Math.min(minRemovals, n - lisLength[i] - ldsLength[i] + 1);
                }
            }
    
            return minRemovals;
        }
    
        private int[] longestIncreasingSubsequence(int[] nums) {
            int[] lisLength = new int[nums.length];
    
            Arrays.fill(lisLength, 1);
    
            for (int i = 0; i < nums.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        lisLength[i] = Math.max(lisLength[i], lisLength[j] + 1);
                    }
                }
            }
    
            return lisLength;
        }
    
        private int[] longestDecreasingSubsequence(int[] nums) {
            int[] ldsLength = new int[nums.length];
    
            Arrays.fill(ldsLength, 1);
    
            for (int i = nums.length - 1; i >= 0; i--) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        ldsLength[i] = Math.max(ldsLength[i], ldsLength[j] + 1);
                    }
                }
            }
    
            return ldsLength;
        }
    }
}
