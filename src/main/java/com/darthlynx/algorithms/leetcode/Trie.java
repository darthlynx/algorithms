package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (node.containsKey(currentChar)) {
                node = node.get(currentChar);
            } else {
                return null;
            }
        }
        return node;
    }

    private static class TrieNode {
        private TrieNode[] children;
        boolean isEnd;

        private TrieNode() {
            children = new TrieNode[26];
        }

        private void put(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }

        private TrieNode get(char ch) {
            return children[ch - 'a'];
        }

        private boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }
    }
}
