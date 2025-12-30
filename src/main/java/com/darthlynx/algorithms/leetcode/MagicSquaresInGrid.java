package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/magic-squares-in-grid/
public class MagicSquaresInGrid {

    // Time complexity: O(m * n)
    // Space complexity: O(1)
    class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int count = 0;
            for (int i = 0; i < m - 2; i++) {
                for (int j = 0; j < n - 2; j++) {
                    if (isMagic(i, j, grid)) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean isMagic(int i, int j, int[][] grid) {
            if (grid[i + 1][j + 1] != 5) {
                return false;
            }
            if (grid[i][j] % 2 != 0
                    || grid[i + 2][j] % 2 != 0
                    || grid[i][j + 2] % 2 != 0
                    || grid[i + 2][j + 2] % 2 != 0) {
                return false;
            }

            boolean isSameCol = grid[i][j] + grid[i + 1][j] + grid[i + 2][j] == 15
                    && grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] == 15
                    && grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] == 15;
            if (!isSameCol) {
                return false;
            }

            boolean isSameRow = grid[i][j] + grid[i][j + 1] + grid[i][j + 2] == 15
                    && grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] == 15
                    && grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] == 15;
            if (!isSameRow) {
                return false;
            }

            boolean isSameDiagonal = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] == 15
                    && grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2] == 15;
            if (!isSameDiagonal) {
                return false;
            }

            return true;
        }
    }
}
