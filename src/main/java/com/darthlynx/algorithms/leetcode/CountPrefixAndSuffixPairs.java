package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/
public class CountPrefixAndSuffixPairs {

    // Time complexity: O(n^2 * m)
    // Space complexity: O(1)
    // where m - average length of the word, n - number of words
    class Solution {
        public int countPrefixSuffixPairs(String[] words) {
            int count = 0;
            for (int i = 0; i < words.length - 1; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (isPrefixAndSuffix(words[i], words[j])) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean isPrefixAndSuffix(String s1, String s2) {
            return s2.startsWith(s1) && s2.endsWith(s1);
        }
    }

    // Time complexity: O(n^2 * m)
    // Space complexity: O(n * m)
    class Solution2 {

        class Trie {
            class Node {
                private Node[] links = new Node[26];
    
                boolean contains(char ch) {
                    return links[ch - 'a'] != null;
                }
    
                void put(char ch, Node node) {
                    links[ch - 'a'] = node;
                }
    
                Node next(char ch) {
                    return links[ch - 'a'];
                }
            }
    
            private Node root;
    
            Trie() {
                root = new Node();
            }
    
            public void insert(String word) {
                Node node = root;
                for (char ch : word.toCharArray()) {
                    if (!node.contains(ch)) {
                        node.put(ch, new Node());
                    }
                    node = node.next(ch);
                }
            }
    
            public boolean startsWith(String prefix) {
                Node node = root;
                for (char ch : prefix.toCharArray()) {
                    if (!node.contains(ch)) {
                        return false;
                    }
                    node = node.next(ch);
                }
                return true;
            }
        }
    
        public int countPrefixSuffixPairs(String[] words) {
            int count = 0;
    
            for (int i = 0; i < words.length; i++) {
                Trie prefixTrie = new Trie();
                Trie suffixTrie = new Trie();
    
                prefixTrie.insert(words[i]);
    
                String reversed = new StringBuilder(words[i]).reverse().toString();
                suffixTrie.insert(reversed);
    
                for (int j = 0; j < i; j++) {
                    String reversedPrefix = new StringBuilder(words[j]).reverse().toString();
    
                    if (prefixTrie.startsWith(words[j])
                            && suffixTrie.startsWith(reversedPrefix)) {
                        count++;
                    }
                }
            }
    
            return count;
        }
    }
}
