package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/house-robber-iv/
public class HouseRobberIV {

    // Time complexity: O(N*logM)
    // Space complexity: O(1)
    // where N = nums.length; M = max(nums) - min(nums)
    class Solution {
        public int minCapability(int[] nums, int k) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            int good = min - 1;
            int bad = max + 1;

            while (bad - good > 1) {
                int mid = good + (bad - good) / 2;
                if (isPossible(nums, k, mid)) {
                    bad = mid;
                } else {
                    good = mid;
                }
            }

            return good;
        }

        private boolean isPossible(int[] nums, int k, int mid) {
            int n = 0;
            int i = 0;
            while (i < nums.length) {
                if (nums[i] < mid) {
                    n++;
                    i++;
                }
                i++;
            }
            return n >= k;
        }
    }
}
