package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/count-submatrices-with-all-ones/
public class CountSubmatricesWithAllOnes {

    // Time complexity: O(m^2*n)
    // Space complexity: O(m*n)
    class Solution {
        public int numSubmat(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            int[][] dp = new int[m][n];

            // This tells us the maximum width of a rectangle
            // ending at (i, j) extending leftwards
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                    }
                }
            }

            // calculate the submatrices
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        int min = Integer.MAX_VALUE;
                        for (int k = i; k >= 0; k--) {
                            if (dp[k][j] == 0) {
                                break;
                            }
                            min = Math.min(min, dp[k][j]);
                            res += min;
                        }
                    }
                }
            }

            return res;
        }
    }
}
