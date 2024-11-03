package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/rotate-string/
public class RotateString {

    // Time complexity: O(n)
    // Space complexity: O(n), where n - number of chars in string s
    class Solution {
        public boolean rotateString(String s, String goal) {
            if (s.length() > goal.length()) {
                return false;
            }
            String doubled = s + s;
    
            return doubled.contains(goal);
        }
    }

}
