package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {

    // Time complexity: O(n^2) ~> O(9^2) ~> O(1)
    // Space complexity: O(1)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int n = board.length;

            // check rows
            for (int i = 0; i < n; i++) {
                int[] map = new int[10];
                for (int j = 0; j < n; j++) {
                    if (Character.isDigit(board[i][j])) {
                        int num = board[i][j] - '0';
                        if (map[num] != 0) {
                            return false;
                        }
                        map[num]++;
                    }
                }
            }

            // check columns
            for (int j = 0; j < n; j++) {
                int[] map = new int[10];
                for (int i = 0; i < n; i++) {
                    if (Character.isDigit(board[i][j])) {
                        int num = board[i][j] - '0';
                        if (map[num] != 0) {
                            return false;
                        }
                        map[num]++;
                    }
                }
            }

            // check small squares
            for (int i = 0; i < n; i += 3) {
                for (int j = 0; j < n; j += 3) {
                    int[] map = new int[10];
                    for (int a = i; a < i + 3; a++) {
                        for (int b = j; b < j + 3; b++) {
                            if (Character.isDigit(board[a][b])) {
                                int num = board[a][b] - '0';
                                if (map[num] != 0) {
                                    return false;
                                }
                                map[num]++;
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
