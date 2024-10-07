package com.darthlynx.algorithms.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/minimum-string-length-after-removing-substrings/
public class MinimumStringLengthAfterRemovingSubstrings {

    // Time complexity: O(n^2); space complexity: O(n)
    class Solution {
        private static final String AB = "AB";
        private static final String CD = "CD";
    
        public int minLength(String s) {
            StringBuilder res = removeSubstring(new StringBuilder(s));
    
            return res.length();
        }
    
        private StringBuilder removeSubstring(StringBuilder s) {
            if (s.indexOf(AB) < 0 && s.indexOf(CD) < 0) {
                return s;
            }
    
            if (s.indexOf(AB) >= 0) {
                int start = s.indexOf(AB);
                int end = start + AB.length();
                s.delete(start, end);
                return removeSubstring(s);
            } else {
                int start = s.indexOf(CD);
                int end = start + CD.length();
                s.delete(start, end);
                return removeSubstring(s);
            }
        }
    }

    // Time complexity: O(n^2); space complexity: O(n)
    class Solution2 {
        private static final String AB = "AB";
        private static final String CD = "CD";
    
        public int minLength(String s) {
    
            StringBuilder res = new StringBuilder(s);
    
            while (res.indexOf(AB) >= 0 || res.indexOf(CD) >= 0) {
                if (res.indexOf(AB) >= 0) {
                    int start = res.indexOf(AB);
                    int end = start + AB.length();
                    res.delete(start, end);
                } else if (res.indexOf(CD) >= 0) {
                    int start = res.indexOf(CD);
                    int end = start + CD.length();
                    res.delete(start, end);
                }
            }
    
            return res.length();
        }
    }

    // Time complexity: O(n); space complexity: O(n)
    class Solution3 {

        public int minLength(String s) {
            Stack<Character> stack = new Stack<>();

            for (char ch : s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else if (ch == 'B' && stack.peek() == 'A') { // check for AB
                    stack.pop();
                } else if (ch == 'D' && stack.peek() == 'C') { // check for CD
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }

            return stack.size();
        }
    }
}
