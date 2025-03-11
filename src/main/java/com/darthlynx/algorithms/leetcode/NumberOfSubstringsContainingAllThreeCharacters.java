package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
public class NumberOfSubstringsContainingAllThreeCharacters {

    // Time complexity: O(N)
    // Space complexity: O(3) -> O(1)
    class Solution1 {
        public int numberOfSubstrings(String s) {
            Map<Character, Integer> chars = new HashMap<>();

            int result = 0;
            int left = 0;

            for (int right = 0; right < s.length(); right++) {
                char ch = s.charAt(right);
                chars.put(ch, chars.getOrDefault(ch, 0) + 1);

                while (hasAll(chars)) {
                    result += s.length() - right;

                    char leftChar = s.charAt(left);
                    remove(chars, leftChar);
                    left++;
                }
            }

            return result;
        }

        private void remove(Map<Character, Integer> chars, char ch) {
            if (chars.get(ch) == 1) {
                chars.remove(ch);
            } else {
                chars.put(ch, chars.get(ch) - 1);
            }
        }

        private boolean hasAll(Map<Character, Integer> chars) {
            return chars.containsKey('a') &&
                    chars.containsKey('b') &&
                    chars.containsKey('c');
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution2 {
        public int numberOfSubstrings(String s) {
            int[] chars = new int[3]; // a, b, c
            int result = 0;
            int left = 0;

            for (int right = 0; right < s.length(); right++) {
                char ch = s.charAt(right);
                chars[ch - 'a']++;

                while (hasAll(chars)) {
                    result += s.length() - right;

                    char leftChar = s.charAt(left);
                    chars[leftChar - 'a']--;
                    left++;
                }
            }

            return result;
        }

        private boolean hasAll(int[] chars) {
            for (int ch : chars) {
                if (ch == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
