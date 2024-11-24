package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/maximum-matrix-sum/
public class MaximumMatrixSum {

    // Time complexity: O(m*n)
    // Space complexity: O(1)
    class Solution {
        public long maxMatrixSum(int[][] matrix) {
            int absoluteMin = Integer.MAX_VALUE;
            int negativeCount = 0;
            long absoluteSum = 0L;
    
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] < 0) {
                        negativeCount++;
                    }
                    absoluteMin = Math.min(absoluteMin, Math.abs(matrix[i][j]));
                    absoluteSum += Math.abs(matrix[i][j]);
                }
            }
    
            if (negativeCount % 2 == 0) {
                return absoluteSum;
            } else {
                // For an odd count of negative numbers, 
                // flipping a negative number to positive adds 
                // that number's absolute value to the total sum. 
                // For example, if we had flipped -1 to +1, 
                // it would increase the sum by +1. 
                // However, since we can't flip this number (due to the odd count of negatives), 
                // we need to "remove" this potential gain
                return absoluteSum - 2 * absoluteMin;
            }
        }
    }
}
