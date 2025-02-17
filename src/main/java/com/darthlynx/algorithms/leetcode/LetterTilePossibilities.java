package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/letter-tile-possibilities/
public class LetterTilePossibilities {

    // Time complexity: O(n * n!)
    // Space complexity: O(n * n!)
    class Solution {
        public int numTilePossibilities(String tiles) {
            Set<String> seq = new HashSet<>();
            boolean[] used = new boolean[tiles.length()];
            generateSequences("", tiles, used, seq);
            return seq.size();
        }
    
        private void generateSequences(String current, String tiles, boolean[] used, Set<String> seq) {
            if (!current.isEmpty()) {
                seq.add(current);
            }
            for (int i = 0; i < tiles.length(); i++) {
                if (!used[i]) {
                    used[i] = true;
                    generateSequences(current + tiles.charAt(i), tiles, used, seq);
                    used[i] = false;
                }
            }
        }
    }
}
