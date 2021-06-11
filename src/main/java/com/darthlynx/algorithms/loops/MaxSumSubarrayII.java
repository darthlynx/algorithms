package com.darthlynx.algorithms.loops;


// Given a circular array, compute its maximum subarray sum in O(n) time.
// A subarray can be empty, and in this case the sum is 0.
//
// For example, given [8, -1, 3, 4], return 15 as we choose the numbers 3, 4, and 8 where the 8 is obtained from wrapping around.
// Given [-4, 5, 1, 0], return 6 as we choose the numbers 5 and 1.

public class MaxSumSubarrayII {

    public int maxSumSubarray(int[] nums) {
        int maxSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = maxSum + nums[i];
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}
