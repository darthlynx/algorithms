package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/
public class FindTheMinimumAreaToCoverAllOnes {

    // Time complexity: O(n*m)
    // Space complexity: O(1)
    class Solution {
        public int minimumArea(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int minX = n, maxX = 0;
            int minY = m, maxY = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        minX = Math.min(minX, j);
                        maxX = Math.max(maxX, j);
                        minY = Math.min(minY, i);
                        maxY = Math.max(maxY, i);
                    }
                }
            }

            int x = maxX - minX + 1;
            int y = maxY - minY + 1;

            return x * y;
        }
    }
}
