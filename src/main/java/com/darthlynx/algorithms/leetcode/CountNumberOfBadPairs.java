package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-number-of-bad-pairs/
public class CountNumberOfBadPairs {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public long countBadPairs(int[] nums) {
            int n = nums.length;

            // count good pairs first
            // j - i = nums[j] - nums[i]
            // j - nums[j] = i - nums[i]

            Map<Integer, Integer> diff = new HashMap<>(); // <res, goodPairs>

            long badPairs = 0;
            for (int i = 0; i < n; i++) {
                int currDiff = i - nums[i];
                int goodPairs = diff.getOrDefault(currDiff, 0);
                // count of all possible pairs up to current position is i
                // therefore, number of bad pairs == total number - good pairs
                badPairs += i - goodPairs;
                diff.put(currDiff, goodPairs + 1);
            }

            return badPairs;
        }
    }
}
