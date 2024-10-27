package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/count-square-submatrices-with-all-ones/
public class CountSquareSubmatricesWithAllOnes {

    // Time complexity: O(m*n)
    // Space complexity: O(m*n)
    class Solution {
        public int countSquares(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            
            int[][] memo = new int[m + 1][n + 1];
            int score = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1) {
                        memo[i+1][j+1] = matrix[i][j] 
                        + Math.min(memo[i+1][j],
                        + Math.min(memo[i][j+1], memo[i][j]));
                    }
                    score += memo[i+1][j+1]; 
                }
            }
    
            return score;
        }
    }
}
