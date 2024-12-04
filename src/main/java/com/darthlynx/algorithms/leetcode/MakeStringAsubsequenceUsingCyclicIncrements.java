package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/
public class MakeStringAsubsequenceUsingCyclicIncrements {

    // Time complexity: O(n + m), where n = str1.length(); m = str2.length()
    // Space complexity: O(1)
    class Solution {
        public boolean canMakeSubsequence(String str1, String str2) {

            int j = 0;

            for (int i = 0; i < str1.length(); i++) {
                if (j < str2.length()
                        && (str1.charAt(i) == str2.charAt(j) || getNextChar(str1.charAt(i)) == str2.charAt(j))) {
                    j++;
                }
            }

            return j == str2.length();
        }

        private char getNextChar(char ch) {
            if (ch == 'z') {
                return 'a';
            } else {
                return (char) (ch + 1);
            }
        }
    }
}
