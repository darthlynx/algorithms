package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/largest-perimeter-triangle/
public class LargestPerimeterTriangle {

    // Time complexity: O(n*logn)
    // Space complexity: O(1)
    class Solution {
        public int largestPerimeter(int[] nums) {
            Arrays.sort(nums);
            for (int i = nums.length - 1; i >= 2; i--) {
                if (nums[i - 2] + nums[i - 1] > nums[i]) {
                    return nums[i - 2] + nums[i - 1] + nums[i];
                }
            }
            return 0;
        }
    }
}
