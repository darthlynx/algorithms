package com.darthlynx.algorithms.leetcode;


// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
public class MaximumNestingDepthOfTheParentheses {

    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    public int maxDepth(String s) {

        if (s == null || s.isEmpty() || s.length() == 1) {
            return 0;
        }
        int maxDepth = 0;
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == OPEN) {
                counter++;
                maxDepth = Math.max(maxDepth, counter);
            } else if (s.charAt(i) == CLOSE) {
                counter--;
            }
        }

        return maxDepth;
    }
}
