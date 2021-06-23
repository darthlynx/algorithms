package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/remove-element/
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
