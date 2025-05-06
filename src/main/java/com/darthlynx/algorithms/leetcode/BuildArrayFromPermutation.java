package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/build-array-from-permutation/
public class BuildArrayFromPermutation {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }
}
