package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// https://leetcode.com/problems/word-search/
public class WordSearch {

    private static final int[][] MASK = {{0,1}, {0,-1}, {-1,0}, {1,0}};

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

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
        // suddenly, this structure works faster than loop through the mask
        boolean result = dfs(board, word, i-1, j, charPosition+1) ||
                dfs(board, word, i+1, j, charPosition+1) ||
                dfs(board, word, i, j-1, charPosition+1) ||
                dfs(board, word, i, j+1, charPosition+1);
//        for (int[] m : MASK) {
//            int dx = i + m[0];
//            int dy = j + m[1];
//            if (dfs(board, word, dx, dy, charPosition+1)) {
//                return true;
//            }
//        }
        board[i][j] = temp;
        return result;
    }

    @Test
    public void testWordSearch() {
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};
        String word = "ABCCED";

        WordSearch search = new WordSearch();
        assertTrue(search.exist(board, word));
    }

    @Test
    public void testWordSearchNegative() {
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};
        String word = "ABCB";

        WordSearch search = new WordSearch();
        assertFalse(search.exist(board, word));
    }
}
