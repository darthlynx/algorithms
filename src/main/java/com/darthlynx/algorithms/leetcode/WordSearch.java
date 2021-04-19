package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/word-search/
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int charPosition) {

        if (charPosition == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(charPosition)) {
            return false;
        }

        char checked = '!';
        char temp = board[i][j];
        board[i][j] = checked;
        boolean result = dfs(board, word, i-1, j, charPosition+1) ||
                dfs(board, word, i+1, j, charPosition+1) ||
                dfs(board, word, i, j-1, charPosition+1) ||
                dfs(board, word, i, j+1, charPosition+1);
        // Loop is easier to understand, but works slower than unrolled loop
//        int[][] mask = {{0,1}, {0,-1}, {-1,0}, {1,0}};
//        for (int[] m : mask) {
//            int dx = i + m[0];
//            int dy = j + m[1];
//            if (dfs(board, word, dx, dy, charPosition+1)) {
//                return true;
//            }
//        }
        board[i][j] = temp;
        return result;
    }

}
