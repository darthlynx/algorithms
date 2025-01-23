package com.darthlynx.algorithms.neetcode.arraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://neetcode.io/problems/anagram-groups
public class AnagramGroups {

    // Time complexity: O(m * n)
    // Space complexity: O(m * n)
    // where n - average size of the string
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();

            for (String s : strs) {
                String key = toKey(s);
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
            }

            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                result.add(entry.getValue());
            }

            return result;
        }

        private int[] getChars(String s) {
            int[] chars = new int[26];
            for (char ch : s.toCharArray()) {
                chars[ch - 'a']++;
            }
            return chars;
        }

        private String toKey(String s) {
            int[] chars = getChars(s);
            return Arrays.toString(chars);
        }
    }

}
