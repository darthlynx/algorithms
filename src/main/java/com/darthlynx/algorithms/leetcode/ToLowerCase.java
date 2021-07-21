package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/to-lower-case/
public class ToLowerCase {

    public String toLowerCase(String s) {

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (isCapitalLetter(chars[i])) {
                chars[i] = charToLowerCase(chars[i]);
            }
        }

        return String.valueOf(chars);
    }

    private boolean isCapitalLetter(char ch) {
        return ch >= 'A' && ch <= 'A' + 25;
    }

    private char charToLowerCase(char ch) {
        return (char) ('a' + (ch - 'A'));
    }
}
