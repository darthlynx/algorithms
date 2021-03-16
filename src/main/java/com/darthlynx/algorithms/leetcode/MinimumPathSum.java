package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};

        new MinimumPathSum().minPathSum(grid);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] prefixes = new int[m][n];

        prefixes[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            prefixes[0][i] = prefixes[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            prefixes[i][0] = prefixes[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prefixes[i][j] = Math.min(prefixes[i][j-1] + grid[i][j], prefixes[i-1][j] + grid[i][j]);
            }
        }

        return prefixes[m-1][n-1];
    }
}
