package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.com/problems/sort-vowels-in-a-string/
public class SortVowelsInAString {

    // Time complexity: O(N*logN)
    // Space complexity: O(N)
    class Solution {

        private Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        public String sortVowels(String s) {

            char[] chars = s.toCharArray();
            List<Integer> positions = new ArrayList<>();
            PriorityQueue<Character> vows = new PriorityQueue<>();

            for (int i = 0; i < chars.length; i++) {
                if (isVowel(chars[i])) {
                    positions.add(i);
                    vows.offer(chars[i]);
                }
            }

            for (int pos : positions) {
                chars[pos] = vows.poll();
            }

            return new String(chars);
        }

        private boolean isVowel(char ch) {
            return vowels.contains(ch);
        }
    }

    // Time complexity: O(N*logN)
    // Space complexity: O(N)
    class Solution2 {

        public String sortVowels(String s) {

            char[] chars = s.toCharArray();
            List<Character> vows = new ArrayList<>();

            for (int i = 0; i < chars.length; i++) {
                if (isVowel(chars[i])) {
                    vows.add(chars[i]);
                }
            }
            Collections.sort(vows);

            int vp = 0;
            for (int i = 0; i < chars.length; i++) {
                if (isVowel(chars[i])) {
                    chars[i] = vows.get(vp);
                    vp++;
                }
            }

            return new String(chars);
        }

        private boolean isVowel(char ch) {
            return "aeiouAEIOU".indexOf(ch) >= 0;
        }
    }
}
