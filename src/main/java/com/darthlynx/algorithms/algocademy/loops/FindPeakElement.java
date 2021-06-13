package com.darthlynx.algorithms.algocademy.loops;

// https://algocademy.com/app/#problem/find-peak-element/
public class FindPeakElement {

    // O(n)
    public int findPeakElement(int[] nums) {
        for (int i = 0; i <= nums.length-1; i++) {
            if (isPeak(nums, i)) {
                return i;
            }
        }
        return 0;
    }

    private boolean isPeak(int[]nums, int i) {
        if (i == 0) {
            return nums[i] > nums[i+1];
        }
        if (i == nums.length-1) {
            return nums[i] > nums[i-1];
        }
        return nums[i] > nums[i-1] && nums[i] > nums[i+1];
    }
}
