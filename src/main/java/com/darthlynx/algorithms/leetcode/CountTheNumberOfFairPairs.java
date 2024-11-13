package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/count-the-number-of-fair-pairs/
public class CountTheNumberOfFairPairs {

    // Time complexity: O(N * logN) due to sorting
    // Space complexity: O(logN) due to sorting
    class Solution {

        public long countFairPairs(int[] nums, int lower, int upper) {
            Arrays.sort(nums);
            
            // calculate the number of pairs which are lower than upper limit
            long countUpper = numOfPairsWithSumLessThanLimit(nums, upper + 1);
            // calculate the number of paris which are lower than lower limit
            long countLower = numOfPairsWithSumLessThanLimit(nums, lower);

            return countUpper - countLower;
        }

        private long numOfPairsWithSumLessThanLimit(int[] nums, int limit) {
            long count = 0;
            int left = 0;
            int right = nums.length - 1;

            while (right - left > 0) {
                int sum = nums[left] + nums[right];
                if (sum < limit) {
                    // num of pairs is calculated as:
                    // right - (left + 1) + 1 => right - left - 1 + 1 => right - left 
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }

            return count;
        }
    } 
}
