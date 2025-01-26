package com.darthlynx.algorithms.bytopic.binarysearch;

import java.util.Arrays;

// https://leetcode.com/problems/search-a-2d-matrix/
public class MatrixSearch {

    public static void main(String[] args) {
        int [][] matrix = new int[][] {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(matrix, 44));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] list : matrix) {
            int position = Arrays.binarySearch(list, target);
            if (position >= 0) {
                return true;
            }
        }
        return false;
    }
}
