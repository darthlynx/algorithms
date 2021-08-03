package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindFirstAndLastPositionOfElementInSortedArray {

    // TC: O(log n)
    // SC: O(1)
    public int[] searchRange(int[] nums, int target) {

        return new int[]{searchLeft(nums, target), searchRight(nums, target)};
    }

    private int searchLeft(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length-1;
        int pivot;
        while (left < right) {
            pivot = (left + right) / 2;
            if (target <= nums[pivot]) {
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }

        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int searchRight(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int pivot;
        while (left < right) {
            pivot = (left + right + 1)/2;

            if (target >= nums[pivot]) {
                left = pivot;
            } else {
                right = pivot - 1;
            }
        }

        if (nums[right] == target) {
            return right;
        }

        return -1;
    }
}
