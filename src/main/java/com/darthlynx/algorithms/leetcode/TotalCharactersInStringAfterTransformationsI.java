package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/total-characters-in-string-after-transformations-i/
public class TotalCharactersInStringAfterTransformationsI {

    // Time complexity: O(n + t), where n = s.length()
    // Space complexity: O(1)
    class Solution {
        public static final int MODULO = 1_000_000_007;

        public int lengthAfterTransformations(String s, int t) {
            // calculate frequencies of each character
            int[] currentState = new int[26];
            for (char ch : s.toCharArray()) {
                currentState[ch - 'a']++;
            }

            // perform t transformations
            for (int round = 0; round < t; round++) {
                int[] nextState = new int[26];

                // z become a and b
                nextState[0] = currentState[25]; // z becomes a
                nextState[1] = (currentState[25] + currentState[0]) % MODULO; // a becomes b && z contributes to b
                for (int i = 2; i < 26; i++) {
                    nextState[i] = currentState[i - 1];
                }
                currentState = nextState;
            }

            int result = 0;
            for (int count : currentState) {
                result = (result + count) % MODULO;
            }
            return result;
        }
    }
}
