package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/delete-characters-to-make-fancy-string/
public class DeleteCharactersToMakeFancyString {

    // Time complexity: O(n), where n - number of chars in the string
    // Space complexity: O(n), where n - number of chars in the string
    class Solution {
        public String makeFancyString(String s) {
            StringBuilder sb = new StringBuilder();
    
            for (char ch : s.toCharArray()) {
                if (sb.length() >= 2 &&
                    sb.charAt(sb.length()-1) == ch && 
                    sb.charAt(sb.length()-2) == ch) {
                    continue;
                } else {
                    sb.append(ch);
                }
            }
    
            return sb.toString();
        }
    }
}
