package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/
public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public int minChanges(String s) {
            int count = 0;
            
            for (int i = 0; i < s.length()-1; i += 2) {
                if (s.charAt(i) != s.charAt(i+1)) {
                    count++;
                }
            }
    
            return count;
        }
    }

}
