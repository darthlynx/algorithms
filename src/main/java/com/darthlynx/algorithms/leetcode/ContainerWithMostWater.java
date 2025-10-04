package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

	// Time complexity: O(n)
	// Space complexity: O(1)
	class Solution {
	    public int maxArea(int[] height) {
	        int n = height.length;
	        int maxArea = 0;
	        int left = 0, right = n - 1;

	        while (right > left) {
	            int hl = height[left];
	            int hr = height[right];
	            int area = Math.min(hl, hr) * (right - left);
	            maxArea = Math.max(maxArea, area);
	            if (hl > hr) {
	                right--;
	            } else {
	                left++;
	            }
	        }

	        return maxArea;
	    }
	}
}
