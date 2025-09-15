package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfWordsYouCanType {

    // Time complexity: O(n + m)
    // Space complexity: O(m)
    // where n = text.length(), m = brokenLetter.length()
    class Solution {
        public int canBeTypedWords(String text, String brokenLetters) {
            Set<Character> broken = new HashSet<>();
            for (char ch : brokenLetters.toCharArray()) {
                broken.add(ch);
            }

            int counter = 0;
            String[] words = text.split(" ");
            for (String word : words) {
                boolean addWord = true;
                for (char ch : word.toCharArray()) {
                    if (broken.contains(ch)) {
                        addWord = false;
                        break;
                    }
                }
                if (addWord) {
                    counter++;
                }
            }

            return counter;
        }
    }

    // Time complexity: O(n + m) ~> O(n)
    // Space complexity: O(m)
    // where n = text.length(), m = brokenLetter.length()
    class Solution2 {
        public int canBeTypedWords(String text, String brokenLetters) {
            boolean[] broken = new boolean[26];
            for (char ch : brokenLetters.toCharArray()) {
                broken[ch - 'a'] = true;
            }

            int counter = 0;
            boolean addWord = true;
            for (char ch : text.toCharArray()) {
                if (ch == ' ') {
                    if (addWord) {
                        counter++;
                    }
                    addWord = true;
                } else if (broken[ch - 'a']) {
                    addWord = false;
                }
            }
            if (addWord) { // last word
                counter++;
            }

            return counter;
        }
    }
}
