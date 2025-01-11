package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/construct-k-palindrome-strings/
public class ConstructKPalindromeStrings {

    // Time complexity: O(n)
    // Space complexity: O(26) -> O(1),
    // where n = s.length()
    class Solution {
        public boolean canConstruct(String s, int k) {
            if (s.length() < k) {
                return false;
            }
            
            int[] chars = new int[26];
            for (char ch : s.toCharArray()) {
                chars[ch - 'a']++;
            }
    
            int oddCount = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] % 2 != 0) {
                    oddCount++;
                }
            }
            return oddCount <= k;
        }
    }
}
