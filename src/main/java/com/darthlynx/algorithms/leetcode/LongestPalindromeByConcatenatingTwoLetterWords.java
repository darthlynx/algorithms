package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
public class LongestPalindromeByConcatenatingTwoLetterWords {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution1 {
        public int longestPalindrome(String[] words) {
            Map<String, Integer> freq = new HashMap<>();

            for (String word : words) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }

            int maxPalindrome = 0;
            boolean allowed = true;
            for (String word : freq.keySet()) {
                String palindrome = getPalindrome(word);
                if (word.equals(palindrome) && freq.containsKey(word)) {
                    int count = freq.get(word);
                    // allow pairs
                    maxPalindrome += (count / 2) * 4;
                    // also allow only one single palindromic word
                    if (count % 2 == 1 && allowed) {
                        allowed = false;
                        maxPalindrome += 2;
                    }
                    freq.put(word, 0); // mark as used
                } else if (freq.containsKey(word) && freq.containsKey(palindrome)) {
                    int pairs = Math.min(freq.get(word), freq.get(palindrome));
                    maxPalindrome += 4 * pairs;

                    // mark both as used
                    freq.put(word, 0);
                    freq.put(palindrome, 0);
                }
            }

            return maxPalindrome;
        }

        private String getPalindrome(String w) {
            return "" + w.charAt(1) + w.charAt(0);
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution2 {
        public int longestPalindrome(String[] words) {
            Map<String, Integer> freq = new HashMap<>();

            for (String word : words) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }

            int maxPalindrome = 0;
            boolean allowed = true;
            for (String word : words) {
                if (isPalindrome(word) && freq.containsKey(word)) {
                    int count = freq.get(word);
                    maxPalindrome += (count / 2) * 4;
                    if (count % 2 == 1 && allowed) {
                        allowed = false;
                        maxPalindrome += 2;
                    }
                    freq.remove(word);
                } else {
                    String palindrome = getPalindrome(word);
                    if (freq.containsKey(word) && freq.containsKey(palindrome)) {
                        maxPalindrome += 4;
                        freq.put(word, freq.get(word) - 1);
                        if (freq.get(word) == 0) {
                            freq.remove(word);
                        }
                        freq.put(palindrome, freq.get(palindrome) - 1);
                        if (freq.get(palindrome) == 0) {
                            freq.remove(palindrome);
                        }
                    }
                }
            }

            return maxPalindrome;
        }

        private boolean isPalindrome(String w) {
            return w.charAt(0) == w.charAt(1);
        }

        private String getPalindrome(String w) {
            return "" + w.charAt(1) + w.charAt(0);
        }
    }
}
