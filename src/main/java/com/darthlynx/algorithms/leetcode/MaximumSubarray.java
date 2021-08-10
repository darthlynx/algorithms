package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {

    // example
    // nums    [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    // currSum  -2  1  -2  4   3  5  6   1  5
    // maxSum   -2  1   1  4   4  5  6   6  6
    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int currentSum = nums[0];
        int num;
        for (int i = 1; i < nums.length; i++) {
            num = nums[i];
            // for each num we check if currentSum will be greater than num itself
            // if num is greater than currentSum, it means that we need to start calculating the sum from this point
            currentSum = Math.max(currentSum + num, num);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
}
