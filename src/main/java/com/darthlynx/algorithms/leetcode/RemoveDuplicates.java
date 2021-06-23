package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }
}
