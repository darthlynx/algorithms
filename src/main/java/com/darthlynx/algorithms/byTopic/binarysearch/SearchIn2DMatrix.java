package com.darthlynx.algorithms.bytopic.binarysearch;

// https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };
        int target = 5;

        boolean res = new SearchIn2DMatrix().new Solution().searchMatrix(matrix, target);
        System.out.println(res);
    }

    // Time complexity: O(m * logN)
    // Space complexity: O(1)
    class Solution {

        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
    
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] > target) {
                    break;
                }
                int good = -1;
                int bad = n;
                while (bad - good > 1) {
                    int mid = good + (bad - good) / 2;
                    if (matrix[i][mid] <= target) {
                        good = mid;
                    } else {
                        bad = mid;
                    }
                }
                if (good != -1 && matrix[i][good] == target) {
                    return true;
                }
            }
    
            return false;
        }
    }
}
