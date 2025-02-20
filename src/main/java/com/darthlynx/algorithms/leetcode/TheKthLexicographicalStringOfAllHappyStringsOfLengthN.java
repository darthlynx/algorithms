package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

    // Time complexity: O(n * 2^n)
    // Space complexity: O(n * 2^n)
    class Solution {
        private static final char[] CHARS = new char[] { 'a', 'b', 'c' };

        public String getHappyString(int n, int k) {
            List<String> happyStrings = new ArrayList<>();
            generateStrings(n, "", happyStrings);
            if (happyStrings.size() < k) {
                return "";
            }
            Collections.sort(happyStrings);
            return happyStrings.get(k - 1);
        }

        private void generateStrings(int n, String current, List<String> happyStrings) {
            if (current.length() == n) {
                happyStrings.add(current);
                return;
            }
            for (char ch : CHARS) {
                if (current.length() > 0 && current.charAt(current.length() - 1) == ch) {
                    continue;
                }
                generateStrings(n, current + ch, happyStrings);
            }
        }
    }
}
