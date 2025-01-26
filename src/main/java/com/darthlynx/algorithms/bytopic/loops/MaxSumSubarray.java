package com.darthlynx.algorithms.bytopic.loops;

public class MaxSumSubarray {

    public int maxSumSubarray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}
