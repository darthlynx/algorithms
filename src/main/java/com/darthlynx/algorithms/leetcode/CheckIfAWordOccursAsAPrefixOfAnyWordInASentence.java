package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {

    // Time complexity: O(N*w), where N - number of words in sentence, w - length of the searchWord
    // Space complexity: O(N)
    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] words = sentence.split(" ");
    
            for (int i = 0; i < words.length; i++) {
                if (words[i].startsWith(searchWord)) {
                    return i+1;
                }
            }
    
            return -1;
        }
    }

}
