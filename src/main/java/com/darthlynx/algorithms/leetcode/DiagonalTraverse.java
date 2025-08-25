package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/diagonal-traverse/
public class DiagonalTraverse {

    // Time complexity: O(m * n)
    // Space complexity: O(1), assuming that we exclude the result array
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int[] res = new int[m * n];

            int k = 0; // res pointer

            int i = 0, j = 0;
            boolean moveUpRight = true;
            while (i < m && j < n) {
                int delta = moveUpRight ? 1 : -1;
                while (inGrid(i, j, m, n)) {
                    res[k] = mat[i][j];
                    i = i - delta;
                    j = j + delta;
                    k++;
                }
                if (moveUpRight) {
                    if (j == n) { // went out of right bound
                        i += 2; j--;
                    } else if (i < 0) { // went out of top bound
                        i = 0;
                    }
                } else {
                    if (i == m) { // went out of bottom bound
                        j += 2; i--;
                    } else if (j < 0) { // went out of left bound
                        j = 0;
                    }
                }

                moveUpRight = !moveUpRight; // switch direction
            }

            return res;
        }

        private boolean inGrid(int i, int j, int m, int n) {
            return i >= 0 && i < m && j >= 0 && j < n;
        }
    }
}
