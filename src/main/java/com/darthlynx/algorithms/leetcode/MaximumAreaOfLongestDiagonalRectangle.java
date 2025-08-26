package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/
public class MaximumAreaOfLongestDiagonalRectangle {

    // Time complexity: O(m)
    // Space complexity: O(1)
    // where m = dimensions.length
    class Solution {
        public int areaOfMaxDiagonal(int[][] dimensions) {
            double max = 0;
            int area = 0;
            for (int[] dim : dimensions) {
                double diagonal = Math.sqrt(dim[0] * dim[0] + dim[1] * dim[1]);

                if (diagonal > max) {
                    area = dim[0] * dim[1];
                    max = diagonal;
                } else if (diagonal == max) {
                    area = Math.max(area, dim[0] * dim[1]);
                    max = diagonal;
                }
            }
            return area;
        }
    }
}
