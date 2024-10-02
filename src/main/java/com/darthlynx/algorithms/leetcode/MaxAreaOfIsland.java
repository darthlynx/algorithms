package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/max-area-of-island/
public class MaxAreaOfIsland {

    class Solution {
        private int[] dx = new int[]{0, 0, -1, 1};
        private int[] dy = new int[]{-1, 1, 0, 0};
    
        public int maxAreaOfIsland(int[][] grid) {
            int maxArea = 0;
    
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        int count = dfs(i, j, grid);
                        maxArea = Math.max(maxArea, count);
                    }
                }
            }
    
            return maxArea;
        }
    
        private int dfs(int i, int j, int[][] grid) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
                return 0;
            }
            grid[i][j] = 2; // mark as visited
            int count = 0;
    
            for (int k = 0; k < 4; k++) {
                count += dfs(i + dx[k], j + dy[k], grid);
            }
    
            return 1 + count;
        }
    }
}
