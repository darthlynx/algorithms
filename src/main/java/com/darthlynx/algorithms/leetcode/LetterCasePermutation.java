package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/letter-case-permutation/
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();

        traverse("", s, 0, result);
        return result;
    }

    // this function should build a tree-like structure, where each node will include either capital or lower letter
    // NOTE: if letter is digit, we don't need to make two "branches"
    // e.g.
    // given a string "a1b2"
    // in that case, if we start from the empty string, the tree of possible strings will be the next:
    //         ""
    //       /    \
    //      a      A
    //     /        \
    //    a1        A1
    //    / \       / \
    //  a1b a1B   A1b A1B
    //   /   \     /    \
    // a1b2 a1B2 A1b2  A1B2
    public void traverse(String current, String s, int pos, List<String> result) {
        if (current.length() == s.length()) {
            result.add(current);
            return;
        }

        traverse(current + s.charAt(pos), s, pos+1, result);

        if (!Character.isDigit(s.charAt(pos))) {
            traverse(current + swapCase(s.charAt(pos)), s, pos+1, result);
        }
    }

    private char swapCase(char ch) {
        if (isCapitalLetter(ch)) {
            return charToLowerCase(ch);
        } else {
            return charToUpperCase(ch);
        }
    }

    private boolean isCapitalLetter(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    private char charToLowerCase(char ch) {
        return (char) ('a' + (ch - 'A'));
    }

    private char charToUpperCase(char ch) {
        return (char) ('A' + (ch - 'a'));
    }
}
