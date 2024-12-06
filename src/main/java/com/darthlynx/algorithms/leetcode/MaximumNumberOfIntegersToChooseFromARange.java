package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/
public class MaximumNumberOfIntegersToChooseFromARange {

    // Time complexity: O(m + n), where m = banned.length
    // however, with task contstrains m <= n, total complexity will be O(2*n) => O(n)
    // Space complexity: O(n)
    class Solution {
        public int maxCount(int[] banned, int n, int maxSum) {
            Set<Integer> set = new HashSet<>();
            for (int i : banned) {
                set.add(i);
            }

            int count = 0;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (sum > maxSum) {
                    break;
                }
                if (!set.contains(i) && sum + i <= maxSum) {
                    sum += i;
                    count++;
                }
            }

            return count;
        }
    }
}
