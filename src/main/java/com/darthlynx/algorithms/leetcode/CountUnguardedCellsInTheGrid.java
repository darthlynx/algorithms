package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/count-unguarded-cells-in-the-grid/
public class CountUnguardedCellsInTheGrid {

    // Time complexity: O(m*n + g*(m+n)), where g - number of guards
    // Space complexity: O(m*n)
    class Solution {
        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
            int[][] grid = new int[m][n];

            // mark all guards
            for (int[] guard : guards) {
                int x = guard[0];
                int y = guard[1];
                grid[x][y] = 1;
            }
            // mark all walls
            for (int[] wall : walls) {
                int x = wall[0];
                int y = wall[1];
                grid[x][y] = 3;
            }

            // mark guarded cells
            for (int[] guard : guards) {
                markGuardedCells(guard[0], guard[1], grid);
            }

            // count all unmarked
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        count++;
                    }
                }
            }

            return count;
        }

        private void markGuardedCells(int x, int y, int[][] grid) {
            // look down
            for (int i = x + 1; i < grid.length; i++) {
                if (isNotValid(i, y, grid)) {
                    break;
                }
                grid[i][y] = 2;
            }
            // look up
            for (int i = x - 1; i >= 0; i--) {
                if (isNotValid(i, y, grid)) {
                    break;
                }
                grid[i][y] = 2;
            }
            // look right
            for (int i = y + 1; i < grid[0].length; i++) {
                if (isNotValid(x, i, grid)) {
                    break;
                }
                grid[x][i] = 2;
            }

            // look left
            for (int i = y - 1; i >= 0; i--) {
                if (isNotValid(x, i, grid)) {
                    break;
                }
                grid[x][i] = 2;
            }
        }

        private boolean isNotValid(int x, int y, int[][] grid) {
            return grid[x][y] == 3 || grid[x][y] == 1;
        }
    }

    // Time complexity: O(m*n + g*(m+n)), where g - number of guards
    // Space complexity: O(m*n)
    class Solution2 {

        public static final int WALL = 1;
        public static final int GUARD = 2;
        public static final int GUARDED = 3;
        public static final int NOT_GUARDED = 0;

        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

            int[][] grid = new int[m][n];

            // insert walls
            for (int[] wall : walls) {
                grid[wall[0]][wall[1]] = WALL;
            }

            // mark guards
            for (int[] guard : guards) {
                int gRow = guard[0];
                int gCol = guard[1];
                grid[gRow][gCol] = GUARD;
            }

            // mark the cells visible by guards
            for (int[] guard : guards) {
                int gRow = guard[0];
                int gCol = guard[1];
                markGuardedCells(grid, gRow, gCol);
            }

            int notGuarded = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == NOT_GUARDED) {
                        notGuarded++;
                    }
                }
            }

            return notGuarded;
        }

        private void markGuardedCells(int[][] grid, int x, int y) {
            // check up
            for (int i = x - 1; i >= 0; i--) {
                if (isNotValid(grid, i, y)) {
                    break;
                }
                grid[i][y] = GUARDED;
            }
            // check down
            for (int i = x + 1; i < grid.length; i++) {
                if (isNotValid(grid, i, y)) {
                    break;
                }
                grid[i][y] = GUARDED;
            }
            // check left
            for (int j = y - 1; j >= 0; j--) {
                if (isNotValid(grid, x, j)) {
                    break;
                }
                grid[x][j] = GUARDED;
            }
            // check right
            for (int j = y + 1; j < grid[0].length; j++) {
                if (isNotValid(grid, x, j)) {
                    break;
                }
                grid[x][j] = GUARDED;
            }
        }

        private boolean isNotValid(int[][] grid, int x, int y) {
            return grid[x][y] == WALL || grid[x][y] == GUARD;
        }
    }

}
