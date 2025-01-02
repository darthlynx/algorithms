package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/count-vowel-strings-in-ranges/
public class CountVowelStringsInRanges {

    // Time complexity: O(N + M)
    // Space complexity: O(N)
    // where N = words.length; M = queries.length;
    class Solution {
        public int[] vowelStrings(String[] words, int[][] queries) {
            
            int[] prefix = new int[words.length + 1];
    
            for (int i = 0; i < words.length; i++) {
                int append = isVowelString(words[i]) ? 1 : 0;
                prefix[i+1] = prefix[i] + append;
            }
    
            int[] res = new int[queries.length];
    
            for (int i = 0; i < queries.length; i++) {
                int start = queries[i][0];
                int end = queries[i][1];
    
                res[i] = prefix[end+1] - prefix[start];
            }
    
            return res;
        }
    
        private boolean isVowelString(String s) {
            return isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1));
        }
    
        // private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        private boolean isVowel(char ch) {
            // return vowels.contains(ch);
            return "aeiou".indexOf(ch) != -1;
        }
    }
}
