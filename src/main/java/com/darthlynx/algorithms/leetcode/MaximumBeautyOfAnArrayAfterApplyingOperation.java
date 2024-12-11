package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/
public class MaximumBeautyOfAnArrayAfterApplyingOperation {

    // Time complexity: O(N * logN)
    // Space complexity: O(logN), because sorting requires additional memory
    class Solution {
        public int maximumBeauty(int[] nums, int k) {
            Arrays.sort(nums);

            int length = 0;
            for (int i = 0; i < nums.length; i++) {
                int j = binarySearch(i, nums, k);
                length = Math.max(length, j - i + 1);
            }

            return length;
        }

        private int binarySearch(int i, int[] nums, int k) {
            int good = i - 1;
            int bad = nums.length;

            while (bad - good > 1) {
                int mid = good + (bad - good) / 2;
                if (isBeautiful(i, mid, nums, k)) {
                    good = mid;
                } else {
                    bad = mid;
                }
            }
            return good;
        }

        private boolean isBeautiful(int i, int j, int[] nums, int k) {
            return nums[j] - nums[i] <= 2 * k;
        }
    }

    // Time complexity: O(N * logN)
    // Space complexity: O(logN)
    class Solution2 {
        public int maximumBeauty(int[] nums, int k) {
            Arrays.sort(nums);
    
            int right = 0;
            int length = 0;
    
            for (int left = 0; left < nums.length; left++) {
                while (right < nums.length && nums[right] - nums[left] <= 2 * k) {
                    right++;
                }
                // we do not add +1 here because right pointer already looking at position after the subset
                length = Math.max(length, right - left);
            }
    
            return length;
        }
    }
}
