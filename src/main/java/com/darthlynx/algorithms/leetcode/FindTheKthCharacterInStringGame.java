package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/
public class FindTheKthCharacterInStringGame {

    // Time complexity: O(k)
    // Space complexity: O(k)
    class Solution {
        public char kthCharacter(int k) {
            String word = "a";
            while (word.length() < k) {
                word += transform(word);
            }
            return word.charAt(k - 1);
        }

        private String transform(String word) {
            StringBuilder builder = new StringBuilder();
            for (char ch : word.toCharArray()) {
                if (ch == 'z') {
                    builder.append('a');
                } else {
                    builder.append((char) (ch + 1));
                }
            }
            return builder.toString();
        }
    }
}
