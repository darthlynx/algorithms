package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/find-missing-and-repeated-values/
public class FindMissingAndRepeatedValues {

    // Time complexity: O(n^2)
    // Time complexity: O(n^2)
    class Solution {
        public int[] findMissingAndRepeatedValues(int[][] grid) {
            int n = grid.length;
            int a = 0; // repeated
            int b = 0; // missing

            Set<Integer> nums = new HashSet<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (nums.contains(grid[i][j])) {
                        a = grid[i][j];
                    }
                    nums.add(grid[i][j]);
                }
            }

            for (int i = 1; i <= n * n; i++) {
                if (!nums.contains(i)) {
                    b = i;
                    break;
                }
            }

            return new int[] { a, b };
        }
    }
}
