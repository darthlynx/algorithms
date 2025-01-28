package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/
public class MaximumNumberOfFishInAGrid {

    // Time complexity: O(m * n)
    // Space complexity: O(m * n)
    class Solution {

        private final int[] dx = new int[] { -1, 1, 0, 0 };
        private final int[] dy = new int[] { 0, 0, -1, 1 };

        public int findMaxFish(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int maxSum = 0;
            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 0) {
                        int sum = dfs(i, j, grid, visited);
                        maxSum = Math.max(sum, maxSum);
                    }
                }
            }

            return maxSum;
        }

        private int dfs(int i, int j, int[][] grid, boolean[][] visited) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
                return 0;
            }
            visited[i][j] = true;
            int sum = grid[i][j];
            for (int dir = 0; dir < 4; dir++) {
                sum += dfs(i + dx[dir], j + dy[dir], grid, visited);
            }
            return sum;
        }
    }

}
