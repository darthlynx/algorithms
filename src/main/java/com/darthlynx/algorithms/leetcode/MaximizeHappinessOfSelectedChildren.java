package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/maximize-happiness-of-selected-children/
public class MaximizeHappinessOfSelectedChildren {

    // Time complexity: O(n log n)
    // Space complexity: O(1)
    class Solution {
        public long maximumHappinessSum(int[] happiness, int k) {
            Arrays.sort(happiness);
            int n = happiness.length;
            long result = 0l;
            int j = 0; // to represent happiness decrement on each step
            for (int i = n - 1; i >= n - k; i--) {
                int h = happiness[i] - j;
                if (h <= 0) {
                    break;
                }
                result += h;
                j++;
            }
            return result;
        }
    }
}
