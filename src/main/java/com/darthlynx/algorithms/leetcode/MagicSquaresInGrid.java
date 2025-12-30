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

            // check if all digits unique
            int[] digits = new int[10];
            for (int r = i; r < i + 3; r++) {
                for (int c = j; c < j + 3; c++) {
                    if (grid[r][c] > 9 || digits[grid[r][c]] != 0) {
                        return false;
                    }
                    digits[grid[r][c]]++;
                }
            }

            // check columns
            for (int k = 0; k < 3; k++) {
                if (grid[i][j + k] + grid[i + 1][j + k] + grid[i + 2][j + k] != 15) {
                    return false;
                }
            }

            // check rows
            for (int k = 0; k < 3; k++) {
                if (grid[i + k][j] + grid[i + k][j + 1] + grid[i + k][j + 2] != 15) {
                    return false;
                }
            }

            return grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] == 15
                    && grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2] == 15;
        }
    }
}
