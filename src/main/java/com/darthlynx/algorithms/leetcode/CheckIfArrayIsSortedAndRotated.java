package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
public class CheckIfArrayIsSortedAndRotated {

    // Time complexity: O(n * logn)
    // Space complexity: O(1)
    class Solution {
        public boolean check(int[] nums) {
            int n = nums.length;
            int[] sorted = Arrays.copyOf(nums, n);
            Arrays.sort(sorted);

            // find first element
            int firstIndex = 0;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    firstIndex = i + 1;
                    break;
                }
            }

            for (int i = 0; i < n; i++) {
                if (nums[(i + firstIndex) % n] != sorted[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
