package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/number-of-segments-in-a-string/
public class NumberOfSegmentsInAString {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {

        public int countSegments(String s) {
            int segments = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                    segments++;
                }
            }
            return segments;
        }
    }
}
