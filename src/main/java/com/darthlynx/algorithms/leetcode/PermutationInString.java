package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/permutation-in-string/
public class PermutationInString {

    class Solution {
        // one string will be permutation of another only if both of them
        // contain the same chars the same number of times
        // Therefore, x is permutation fo y if sorted(x) == sorted(y)
        public boolean checkInclusion(String s1, String s2) {
            s1 = sort(s1);

            int l1 = s1.length();
            int l2 = s2.length();

            String sortedSubString;
            // checking all substrings of the s2 and sort them
            // if sorted substring matches with sorted s1, it means it contains permutation
            for (int i = 0; i <= l2 - l1; i++) {
                sortedSubString = sort(s2.substring(i, i+l1));
                if (s1.equals(sortedSubString)) {
                    return true;
                }
            }

            return false;
        }

        private String sort(String s) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }
    }

    class Solution2 {

        // in this interpreteation we check the frequencies of the characters in substrings of s2
        // if frequencies of that substring match with frequencies of s1, it means that it contains the permutations
        public boolean checkInclusion(String s1, String s2) {
    
            int l1 = s1.length();
            int l2 = s2.length();
    
            int[] s1Freq = buildFrequencyMap(s1, 0, l1);
    
            for (int i = 0; i <= l2 - l1; i++) {
                if (matches(s1Freq, buildFrequencyMap(s2, i, i+l1))) {
                    return true;
                }
            }
    
            return false;
        }
    
        private boolean matches(int[] s1, int[] s2) {
            for (int i = 0; i < 26; i++) {
                if (s1[i] != s2[i]) {
                    return false;
                }
            }
            return true;
        }
    
        private int[] buildFrequencyMap(String s, int start, int end) {
            int[] freq = new int[26];
            for (int i = start; i < end; i++) {
                char ch = s.charAt(i);
                freq[ch - 'a']++;
            }
            return freq;
        }
    }

}
