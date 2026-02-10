package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-balanced-subarray-i/
public class LongestBalancedSubarray {

    // Time complexity: O(n^2)
    // Space complexity: O(n)
    class Solution {
        public int longestBalanced(int[] nums) {
            int longest = 0;
            for (int i = 0; i < nums.length; i++) {
                Set<Integer> odd = new HashSet<>();
                Set<Integer> even = new HashSet<>();
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] % 2 == 0) {
                        even.add(nums[j]);
                    } else {
                        odd.add(nums[j]);
                    }

                    if (odd.size() == even.size()) {
                        longest = Math.max(longest, j - i + 1);
                    }
                }
            }
            return longest;
        }
    }
}
