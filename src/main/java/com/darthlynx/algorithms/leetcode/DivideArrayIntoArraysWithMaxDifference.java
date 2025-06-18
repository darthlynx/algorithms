package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/
public class DivideArrayIntoArraysWithMaxDifference {

    // Time complexity: O(n*logn)
    // Space complexity: O(n)
    class Solution {
        public int[][] divideArray(int[] nums, int k) {
            int n = nums.length;
            int m = n / 3;
            int[][] result = new int[m][];

            Arrays.sort(nums);
            int j = 0;
            for (int i = 0; i <= n - 3;) {
                if (nums[i + 2] - nums[i] > k) {
                    return new int[][] {};
                }
                result[j] = new int[] { nums[i], nums[i + 1], nums[i + 2] };
                j++;
                i += 3;
            }

            return result;
        }
    }
}
