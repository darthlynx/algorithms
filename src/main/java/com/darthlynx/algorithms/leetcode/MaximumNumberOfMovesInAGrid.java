package com.darthlynx.algorithms.leetcode;


// https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/
public class MaximumNumberOfMovesInAGrid {

    // Space complexity: O(m*n)
    // Time complexity: O(m*n)
    class Solution {
        public int maxMoves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
    
            int[][] memo = new int[m][n];
    
    
            for (int i = 0; i < m; i++) {
                checkMoves(i, 0, 0, 0, grid, memo);
            }
    
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, memo[i][j]);
                }
            }
    
            return max;
        }
    
    
        private void checkMoves(int row, int col, int prev, int step, int[][] grid, int[][] memo) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                return;
            }
    
            // do not proceed if current number is smaller than previous
            if (grid[row][col] <= prev) {
                return;
            }
    
            // this path already checked
            if (memo[row][col] != 0) {
                return;
            }
            
            memo[row][col] = step;
    
            checkMoves(row - 1, col + 1, grid[row][col], step+1, grid, memo);
            checkMoves(row, col + 1, grid[row][col], step+1, grid, memo);
            checkMoves(row + 1, col + 1, grid[row][col], step+1, grid, memo);
        }
    }

}
