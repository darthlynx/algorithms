package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/number-of-ways-to-split-array/
public class NumberOfWaysToSplitArray {

    // Time complexity: O(N)
    // Space complexity: O(1)
    class Solution {
        public int waysToSplitArray(int[] nums) {
            long total = 0L; 
            for (int num : nums) {
                total += num;
            }
    
            int waysToSplit = 0;
            long currSum = 0L;
            for (int i = 0; i < nums.length - 1; i++) {
                currSum += nums[i];
                if (currSum >= total - currSum) {
                    waysToSplit++;
                }
            }
    
            return waysToSplit;
        }
    }

}
