package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-balanced-subarray-i/
public class LongestBalancedSubarray {

    // Time complexity: O(n^2)
    // Space complexity: O(n)
    class Solution {
        public int longestBalanced(int[] nums) {
            int n = nums.length;
            int longest = 0;
            for (int i = 0; i < n; i++) {
                if (n - i < longest) { // cannot find longer subarray anymore
                    break;
                }
                Set<Integer> odd = new HashSet<>();
                Set<Integer> even = new HashSet<>();
                for (int j = i; j < n; j++) {
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
