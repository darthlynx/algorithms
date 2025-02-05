package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
public class CheckIfOneStringSwapCanMakeStringsEqual {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution1 {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }

            int notMatch = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    notMatch++;
                }
                if (notMatch > 2) {
                    return false;
                }
            }

            int[] chars1 = countChars(s1);
            int[] chars2 = countChars(s2);

            return Arrays.equals(chars1, chars2);
        }

        private int[] countChars(String s) {
            int[] chars = new int[26];
            for (int i = 0; i < s.length(); i++) {
                chars[s.charAt(i) - 'a']++;
            }
            return chars;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution2 {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }

            int[] chars1 = new int[26];
            int[] chars2 = new int[26];
            int notMatch = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    notMatch++;
                }
                if (notMatch > 2) {
                    return false;
                }
                chars1[s1.charAt(i) - 'a']++;
                chars2[s2.charAt(i) - 'a']++;
            }

            return Arrays.equals(chars1, chars2);
        }
    }
}
