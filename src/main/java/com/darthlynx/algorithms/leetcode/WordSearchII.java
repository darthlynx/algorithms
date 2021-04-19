package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/word-search-ii/
public class WordSearchII {

    static class TrieNode {
        private TrieNode[] children;
        private String word;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> foundWords = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return foundWords;
        }

        TrieNode root = new TrieNode();
        addWordsToTrie(root, words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j ++) {
                char ch = board[i][j];
                if (root.children[ch - 'a'] != null) {
                    dfs(board, i, j, root, foundWords);
                }
            }
        }

        return foundWords;
    }

    private void dfs(char[][] board, int i, int j, TrieNode currentNode, List<String> foundWords) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        char ch = board[i][j];
        char checked = '!';
        if (ch == checked || currentNode.children[ch - 'a'] == null) {
            return;
        }
        currentNode = currentNode.children[ch - 'a'];
        if (currentNode.word != null) {
            foundWords.add(currentNode.word);
            currentNode.word = null; // set to null to avoid words duplication
        }
        board[i][j] = checked;

        dfs(board, i-1, j, currentNode, foundWords); // left
        dfs(board, i+1, j, currentNode, foundWords); // right
        dfs(board, i, j-1, currentNode, foundWords); // top
        dfs(board, i, j+1, currentNode, foundWords); // bottom

        board[i][j] = ch;
    }

    private void addWordsToTrie(TrieNode root, String[] words) {
        for (String word: words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = (word.charAt(i) - 'a');
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
    }

}
