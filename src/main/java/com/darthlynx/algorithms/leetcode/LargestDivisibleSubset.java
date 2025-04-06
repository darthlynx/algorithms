package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/largest-divisible-subset/
public class LargestDivisibleSubset {

    // Time complexity: O(n*log(n) + n^2)
    // Space complexity: O(n)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);

            int[] dp = new int[nums.length]; // size of the subset
            int[] prevIdx = new int[nums.length]; // previous valid index
            Arrays.fill(dp, 1); // each element is a valid subset itself
            Arrays.fill(prevIdx, -1);

            int maxIndex = 0;

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prevIdx[i] = j;
                    }
                }
                if (dp[i] > dp[maxIndex]) {
                    maxIndex = i;
                }
            }

            // reconstruct the subset based on the previous index array
            List<Integer> result = new ArrayList<>();
            while (maxIndex >= 0) {
                result.add(nums[maxIndex]);
                maxIndex = prevIdx[maxIndex];
            }

            return result;
        }
    }
}
