package com.darthlynx.algorithms.bytopic.binarysearch;

// https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };


    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int[] initials = new int[matrix.length];
        for (int i=0; i < matrix.length; i++) {
            initials[i] = matrix[i][0];
        }
        return false;
    }
}
