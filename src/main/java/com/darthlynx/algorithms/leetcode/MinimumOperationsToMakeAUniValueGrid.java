package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/
public class MinimumOperationsToMakeAUniValueGrid {

    // Time complexity: O(m*n*log(m*n))
    // Space complexity: O(m*n)
    class Solution {
        public int minOperations(int[][] grid, int x) {
            int m = grid.length;
            int n = grid[0].length;

            // flatten grid to the line
            int[] line = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    line[i * n + j] = grid[i][j];
                }
            }
            Arrays.sort(line);

            int median = findMedian(line);

            int count = 0;
            for (int i = 0; i < line.length; i++) {
                if (line[i] % x != median % x) {
                    return -1;
                }
                count += Math.abs(line[i] - median) / x;
            }

            return count;
        }

        private int findMedian(int[] arr) {
            int n = arr.length;
            return arr[n / 2];
        }
    }
}
