package com.darthlynx.algorithms.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchTest {

    private WordSearch search;

    @Before
    public void setUp() {
        search = new WordSearch();
    }

    @Test
    public void testWordSearch() {
        char[][] board = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCCED";

        assertTrue(search.exist(board, word));
    }

    @Test
    public void testWordSearchNegative() {
        char[][] board = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCB";

        assertFalse(search.exist(board, word));
    }

}