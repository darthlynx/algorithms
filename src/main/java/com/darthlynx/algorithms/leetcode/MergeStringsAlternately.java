package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/merge-strings-alternately/
public class MergeStringsAlternately {

    // Time complexity: O(n + m)
    // Space complexity: O(n + m)
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();
            int i1 = 0;
            int i2 = 0;

            StringBuilder result = new StringBuilder();

            while (i1 < len1 || i2 < len2) {
                if (i1 < len1) {
                    result.append(word1.charAt(i1));
                    i1++;
                }
                if (i2 < len2) {
                    result.append(word2.charAt(i2));
                    i2++;
                }
            }

            return result.toString();
        }
    }
}
