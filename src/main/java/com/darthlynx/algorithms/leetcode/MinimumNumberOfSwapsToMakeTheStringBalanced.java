package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
public class MinimumNumberOfSwapsToMakeTheStringBalanced {

    class Solution {
        public int minSwaps(String s) {
            // we don't need to do actual swaps, just calculate them
            // we calculating the opened square braces
            int opened = 0;
    
            for (char ch : s.toCharArray()) {
                if (ch == '[') {
                    opened++;
                } else {
                    // if opened not empty, we decrease it (forming a pair)
                    // otherwise we keep it 0
                    // therefore, when the opening brace appear in the string later
                    // it won't make a pair and will show the number of braces need to swap
                    if (opened > 0) {
                        opened--;
                    }
                }
            }
            
            return (opened + 1) / 2;
        }
    }

}
