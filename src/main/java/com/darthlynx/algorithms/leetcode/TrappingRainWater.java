package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {

        public int trap(int[] height) {
            int left = 0;
            int right = height.length - 1;

            int maxRight = height[right];
            int maxLeft = height[left];

            int result = 0;

            while (left < right) {
                if (maxLeft < maxRight) {
                    left++;
                    maxLeft = Math.max(maxLeft, height[left]);
                    result += maxLeft - height[left];
                } else {
                    right--;
                    maxRight = Math.max(maxRight, height[right]);
                    result += maxRight - height[right];
                }
            }

            return result;
        }
    }
}
