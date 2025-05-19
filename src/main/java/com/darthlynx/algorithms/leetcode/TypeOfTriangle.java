package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/type-of-triangle/
public class TypeOfTriangle {

    // Time complexity: O(1)
    // Space complexity: O(1)
    class Solution {
        public String triangleType(int[] nums) {
            if (canNotForm(nums)) {
                return "none";
            }
            if (nums[0] == nums[1] && nums[1] == nums[2]) {
                return "equilateral";
            }
            if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
                return "isosceles";
            }
            return "scalene";
        }

        private boolean canNotForm(int[] nums) {
            return nums[0] + nums[1] <= nums[2]
                    || nums[0] + nums[2] <= nums[1]
                    || nums[1] + nums[2] <= nums[0];
        }
    }
}
