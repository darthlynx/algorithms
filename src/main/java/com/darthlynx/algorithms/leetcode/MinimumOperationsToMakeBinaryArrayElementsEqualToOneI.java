package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/
public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {

    // Time complexity: O(N)
    // Space complexity: O(1)
    class Solution {
        public int minOperations(int[] nums) {
            int ops = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    continue;
                }
                if (i + 2 >= nums.length) {
                    return -1;
                }
                // using XOR to swap numbers 
                nums[i] = nums[i] ^ 1;
                nums[i+1] = nums[i+1] ^ 1;
                nums[i+2] = nums[i+2] ^ 1;
                ops++;
            }
            return ops;
        }
    }
}
