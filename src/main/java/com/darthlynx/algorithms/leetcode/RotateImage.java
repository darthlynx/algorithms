package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/rotate-image/
public class RotateImage {

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    // transpose the matrix (replace rows with columns)
    // e.g.
    // given a matrix
    // 1 2 3
    // 4 5 6
    // 7 8 9
    //
    // imagine you draw the line from 1 to 9 in the initial matrix
    // and then swap the values
    // e.g. 4 -> 2, 2 -> 4; 7 -> 3, 3 -> 7, etc.
    //
    // the output will be the next
    // 1 4 7
    // 2 5 8
    // 3 6 9
    private void transpose(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            // NOTE: we need to start from the i, as we are looking at the diagonal
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    // replace values column by column
    // e.g. given the next matrix
    // 1 4 7
    // 2 5 8
    // 3 6 9
    // ^   ^
    // we need to replace firs column with the last
    // result:
    // 7 4 1
    // 8 5 2
    // 9 6 3
    private void reflect(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            // it is enough to check only half of the row
            for (int j = 0; j < n/2; j++) {
                int tmp = matrix[i][n-j-1];
                matrix[i][n-j-1] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}
