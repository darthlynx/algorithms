package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/minimum-length-of-string-after-operations/
public class MinimumLengthOfStringAfterOperations {

    // Time complexity: O(n)
    // Space complexity: O(26) -> O(1)
    // where n = s.length()
    class Solution {
        public int minimumLength(String s) {
            int[] freq = new int[26];
            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }
    
            int res = 0;
            for (int i = 0; i < 26; i++) {
                if (freq[i] == 0) {
                    continue;
                }
                res += freq[i] % 2 == 0 ? 2 : 1;
            }
    
            return res;
        }
    }

    class Solution2 {
        public int minimumLength(String s) {
            int[] freq = new int[26];
            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }
    
            int res = 0;
            for (int i = 0; i < 26; i++) {
                if (freq[i] <= 1) {
                    res += freq[i];
                } else {
                    while (freq[i] > 2) {
                        freq[i] -= 2;
                    }
                    res += freq[i];
                }
            }
    
            return res;
        }
    }
}
