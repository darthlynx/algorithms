package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i
public class FindThePowerOfKSizeSubarraysI {

    // Time complexity: O(N * K)
    // Space complexity: O(N * K)
    static class Solution {
        public int[] resultsArray(int[] nums, int k) {
            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < nums.length - k + 1; i++) {
                result.add(calculatePower(i, nums, k));
            }

            int[] res = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }

            return res;
        }

        private int calculatePower(int idx, int[] nums, int k) {
            int max = nums[idx];
            Set<Integer> checked = new HashSet<>();
            checked.add(nums[idx]);

            // [1,3,4] , k = 2
            //    ^
            for (int i = idx + 1; i < idx + k; i++) {
                if (checked.contains(nums[i]) || nums[i] - nums[i - 1] != 1) {
                    return -1;
                } else {
                    checked.add(nums[i]);
                    max = Math.max(max, nums[i]);
                }
            }

            return max;
        }
    }
}
