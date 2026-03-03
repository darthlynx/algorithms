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

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution3 {
        public int lengthOfLastWord(String s) {
            int i = s.length() - 1;

            // skip trailing spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            int size = 0;
            while (i >= 0 && s.charAt(i) != ' ') {
                size++;
                i--;
            }
            return size;
        }
    }
}
