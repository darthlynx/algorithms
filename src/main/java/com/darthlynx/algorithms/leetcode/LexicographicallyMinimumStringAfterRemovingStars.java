package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/
public class LexicographicallyMinimumStringAfterRemovingStars {

    // Time complexity: O(N*logN)
    // Space complexity: O(N)
    class Solution {

        class Pair {
            private char ch;
            private int pos; // position in the string

            Pair(char ch, int pos) {
                this.ch = ch;
                this.pos = pos;
            }
        }

        public String clearStars(String s) {
            Set<Integer> removed = new HashSet<>();

            PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> {
                // if chars are the same, we remove the one with higher position first
                // to keep the lexicographically smallest string
                if (p1.ch == p2.ch) {
                    return Integer.compare(p2.pos, p1.pos);
                }
                return Character.compare(p1.ch, p2.ch);
            });

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '*' && !minHeap.isEmpty()) {
                    removed.add(i); // removing '*'
                    Pair p = minHeap.poll();
                    removed.add(p.pos); // removing the smallest on the left
                    continue;
                }
                minHeap.offer(new Pair(ch, i));
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (removed.contains(i)) {
                    continue;
                }
                result.append(s.charAt(i));
            }

            return result.toString();
        }
    }
}
