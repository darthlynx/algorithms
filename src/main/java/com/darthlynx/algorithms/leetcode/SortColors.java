package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/sort-colors/
public class SortColors {

    // Time complexity: O(n)
    // Space complexity: O(1)
    // Count sort approach
    class Solution {
        public void sortColors(int[] nums) {
            int[] count = new int[3];

            for (int num : nums) {
                count[num]++;
            }

            int i = 0;
            while (i < count[0]) {
                nums[i] = 0;
                i++;
            }
            while (i < count[0] + count[1]) {
                nums[i] = 1;
                i++;
            }
            while (i < nums.length) {
                nums[i] = 2;
                i++;
            }
        }
    }
}
