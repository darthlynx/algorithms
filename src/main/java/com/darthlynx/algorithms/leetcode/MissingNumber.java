package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/missing-number/
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;

        // There is a formula which shows the sum of all the numbers in sequence:
        // Sn = n * (n + 1) / 2

        // thus, if we subtract the exact sum from the value of that formula
        // we will get the missed number
        return n * (n + 1) / 2  - getSum(nums);
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

}
