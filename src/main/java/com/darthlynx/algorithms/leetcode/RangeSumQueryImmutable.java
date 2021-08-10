package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/range-sum-query-immutable/
public class RangeSumQueryImmutable {

    private final int[] nums;
    private final int[] sums;

    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
        this.sums = calculateSums(nums);
    }

    // TC: O(n)
    // SC: O(n)
    public int sumRange(int left, int right) {
        if (left == 0) {
            return sums[right];
        }
        return sums[right] - sums[left-1];
    }

    private int[] calculateSums(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
        return sums;
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
