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
            for (int i = x - 1; i >=0 ; i--) {
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

}
