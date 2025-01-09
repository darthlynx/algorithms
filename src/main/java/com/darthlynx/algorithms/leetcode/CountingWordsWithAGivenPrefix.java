package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/counting-words-with-a-given-prefix/
public class CountingWordsWithAGivenPrefix {

    // Time complexity: O(m * n)
    // Space complexity: O(1)
    // where m = words.length; n - average length of the word
    class Solution {
        public int prefixCount(String[] words, String pref) {
            int count = 0;
            for (String word : words) {
                if (word.startsWith(pref)) {
                    count++;
                }
            }
            return count;
        }
    }
}
