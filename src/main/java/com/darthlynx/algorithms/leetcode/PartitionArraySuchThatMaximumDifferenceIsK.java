package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/
public class PartitionArraySuchThatMaximumDifferenceIsK {

    // Time complexity: O(N*logN)
    // Space complexity: O(logN) <- because of sorting
    class Solution {
        public int partitionArray(int[] nums, int k) {
            Arrays.sort(nums);

            int count = 0;
            int left = 0;
            int right = 0;

            while (left < nums.length) {
                int min = nums[left];
                while (right < nums.length && nums[right] - min <= k) {
                    right++;
                }
                count++;
                left = right;
            }

            return count;
        }
    }
}
