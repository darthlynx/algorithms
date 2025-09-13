package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/
public class FindMostFrequentVowelAndConsonant {

    // Time complexity: O(N), where N = s.length()
    // Space complexity: O(1)
    class Solution {
        public int maxFreqSum(String s) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                freq[ch - 'a']++;
            }

            int vowelFreq = 0;
            int consonantFreq = 0;
            for (int i = 0; i < freq.length; i++) {
                char ch = (char) (i + 'a');
                if (isVowel(ch)) {
                    vowelFreq = Math.max(vowelFreq, freq[i]);
                } else {
                    consonantFreq = Math.max(consonantFreq, freq[i]);
                }
            }

            return vowelFreq + consonantFreq;
        }

        private boolean isVowel(char ch) {
            return "aeiou".indexOf(ch) != -1;
        }
    }
}
