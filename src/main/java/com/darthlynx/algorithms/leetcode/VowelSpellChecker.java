package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/vowel-spellchecker/
public class VowelSpellChecker {

    // Time complexity: O(N + M)
    // Space complexity: O(n)
    // where N - total content of wordlist
    // M - total content of queries
    // n = wordlist.length;
    class Solution {
        public String[] spellchecker(String[] wordlist, String[] queries) {
            Set<String> exactMatch = new HashSet<>();
            Map<String, String> lowerMatch = new HashMap<>();
            Map<String, String> spellCheckMatch = new HashMap<>();

            for (String word : wordlist) {
                exactMatch.add(word);
                String w = word.toLowerCase();
                lowerMatch.putIfAbsent(w, word);
                spellCheckMatch.putIfAbsent(replaceVowels(w), word);
            }

            String[] result = new String[queries.length];
            for (int i = 0; i < queries.length; i++) {
                result[i] = getMatch(queries[i], exactMatch, lowerMatch, spellCheckMatch);
            }

            return result;
        }

        private String getMatch(String word, Set<String> exactMatch, Map<String, String> lowerMatch,
                Map<String, String> spellCheckMatch) {
            if (exactMatch.contains(word)) {
                return word;
            }
            String lowerCase = word.toLowerCase();
            if (lowerMatch.containsKey(lowerCase)) {
                return lowerMatch.get(lowerCase);
            }
            String upd = replaceVowels(lowerCase);
            if (spellCheckMatch.containsKey(upd)) {
                return spellCheckMatch.get(upd);
            }
            return "";
        }

        private String replaceVowels(String word) {
            StringBuilder builder = new StringBuilder();
            for (char ch : word.toCharArray()) {
                if (isVowel(ch)) {
                    builder.append("*");
                } else {
                    builder.append(ch);
                }
            }
            return builder.toString();
        }

        private boolean isVowel(char ch) {
            return "aeiou".indexOf(ch) != -1;
        }
    }
}
