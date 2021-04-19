package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordSearchIITest {

    @Test
    public void testFindWords() {
        char[][] board = {{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        List<String> expectedResult = Arrays.asList("oath", "eat");

        WordSearchII searcher = new WordSearchII();
        List<String> actualResult = searcher.findWords(board, words);

        assertNotNull(actualResult);
        assertTrue(actualResult.containsAll(expectedResult));
    }

}