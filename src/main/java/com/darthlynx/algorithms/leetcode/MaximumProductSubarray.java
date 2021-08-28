package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int curProduct = 1;
        int backProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            curProduct *= nums[i];
            backProduct *= nums[nums.length-1-i];

            maxProduct = Math.max(maxProduct, Math.max(curProduct, backProduct));

            if (curProduct == 0) {
                curProduct = 1;
            }
            if (backProduct == 0) {
                backProduct = 1;
            }
        }

        return maxProduct;
    }
}
