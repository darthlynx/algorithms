package com.darthlynx.algorithms.leetcode;

import java.util.Set;

// https://leetcode.com/problems/valid-word/
public class ValidWord {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {

        private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        public boolean isValid(String word) {
            if (word.length() < 3) {
                return false;
            }

            int vowelsCount = 0;
            int consonantCount = 0;

            for (char ch : word.toCharArray()) {
                if (Character.isDigit(ch)) {
                    continue;
                }
                if (Character.isLetter(ch)) {
                    if (isVowel(ch)) {
                        vowelsCount++;
                    } else {
                        consonantCount++;
                    }
                } else { // not letter or digit
                    return false;
                }
            }

            return vowelsCount >= 1 && consonantCount >= 1;
        }

        private boolean isVowel(char ch) {
            return vowels.contains(ch);
        }
    }
}
