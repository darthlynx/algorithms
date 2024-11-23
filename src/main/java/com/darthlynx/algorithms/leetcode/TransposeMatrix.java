package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/transpose-matrix/
public class TransposeMatrix {

    // Time complexity: O(m*n)
    // Space complexity: O(m*n)
    class Solution {
        public int[][] transpose(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
    
            int[][] transposed = new int[n][m];
    
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    transposed[i][j] = matrix[j][i];
                }
            }
    
            return transposed;
        }
    }
}
