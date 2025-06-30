package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-harmonious-subsequence/
public class LongestHarmoniousSubsequence {

    // Time complexity: O(N)
    // Space complexity: O(N)
    class Solution {
        public int findLHS(int[] nums) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            int max = 0;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (freq.containsKey(entry.getKey() + 1)) {
                    max = Math.max(max, freq.get(entry.getKey() + 1) + entry.getValue());
                }
            }
            return max;
        }

    }
}
