package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
public class MinimumAddToMakeParenthesesValid {

    class Solution {
        public int minAddToMakeValid(String s) {
            int closed = 0;
            int opened = 0;
    
            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    opened++;
                } else {
                    if (opened == 0) {
                        closed++;
                    } else {
                        opened--;
                    }
                }
            }
    
            return closed + opened;
        }
    }
}
