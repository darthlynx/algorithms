package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
public class UniqueLengthThreePalindromicSubsequences {

    // Time complexity: O(N)
    // Space complexity: O(26) ~> O(1)
    class Solution {
        public int countPalindromicSubsequence(String s) {
            Set<Character> letters = new HashSet<>();
            for (char ch : s.toCharArray()) {
                letters.add(ch);
            }
    
            int result = 0;
    
            for (char letter : letters) {
                int start = -1;
                int end = 0;
    
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == letter) {
                        if (start < 0) {
                            start = i;
                        }
                        end = i;
                    }
                }
                
                Set<Character> between = new HashSet<>();
                for (int i = start + 1; i < end; i++) {
                    between.add(s.charAt(i));
                }
                result += between.size();
            }
    
            return result;
        }
    }
}
