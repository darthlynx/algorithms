package com.darthlynx.algorithms.trie;

// Prefix tree
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Insert string into Trie
     * @param word - the string to be inserted
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.getNode(currentChar);
        }
        node.setEnd();
    }

    /**
     * Check if the provided string is in the Trie
     * @param word - the string to look for
     * @return true if word is in the Trie
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (node.containsKey(currentChar)) {
                node = node.getNode(currentChar);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean hasPrefix(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private static class TrieNode {
        private final int ALPHABET_CHARS_NUM = 26;
        private final TrieNode[] childLinks;
        private boolean isEnd;

        private TrieNode() {
            childLinks = new TrieNode[ALPHABET_CHARS_NUM];
        }

        private void put(char ch, TrieNode node) {
            childLinks[ch - 'a'] = node;
        }

        private TrieNode getNode(char ch) {
            return childLinks[ch - 'a'];
        }

        private void setEnd() {
            isEnd = true;
        }

        private boolean isEnd() {
            return isEnd;
        }

        private boolean containsKey(char ch) {
            return childLinks[ch - 'a'] != null;
        }
    }
}
