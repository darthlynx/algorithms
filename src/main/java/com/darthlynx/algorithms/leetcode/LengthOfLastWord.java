package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/length-of-last-word/
public class LengthOfLastWord {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution1 {
        public int lengthOfLastWord(String s) {
            String[] words = s.split(" ");
            return words[words.length - 1].length();
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution2 {
        public int lengthOfLastWord(String s) {
            int n = s.length();
            // find position of first non space character (trimming the string)
            int firstNonSpace = n - 1;
            while (firstNonSpace >= 0) {
                if (s.charAt(firstNonSpace) != ' ') {
                    break;
                }
                firstNonSpace--;
            }

            for (int i = firstNonSpace; i >= 0; i--) {
                if (s.charAt(i) == ' ') {
                    return firstNonSpace - i;
                }
            }
            return firstNonSpace + 1;
        }
    }
}
