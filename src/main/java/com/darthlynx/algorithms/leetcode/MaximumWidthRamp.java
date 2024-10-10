package com.darthlynx.algorithms.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/maximum-width-ramp/
public class MaximumWidthRamp {

    class Solution {
        public int maxWidthRamp(int[] nums) {
    
            int n = nums.length;
            
            Stack<Integer> monotonic = new Stack<>();
    
            // use monotonic stack to find the indexes with min smallest values
            for (int i = 0; i < n; i++) {
                if (monotonic.isEmpty() || nums[monotonic.peek()] > nums[i]) {
                    monotonic.push(i);
                }
            }
    
            int maxWidth = 0;
    
            // traverse from the end of the numbers array and compare with the values with indexes in stack
            for (int i = n-1; i >= 0; i--) {
                while (!monotonic.isEmpty() && nums[monotonic.peek()] <= nums[i]) {
                    // calculate max and pop the index since it is already processed
                    maxWidth = Math.max(maxWidth, i - monotonic.pop());
                }
            }
    
            return maxWidth;
        }
    }

}
