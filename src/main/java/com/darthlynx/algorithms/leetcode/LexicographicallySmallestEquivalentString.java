package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
public class LexicographicallySmallestEquivalentString {

    // Time complexity: O(a(n) * m) ~> O(m)
    // Space complexity: O(1) + O(m) ~> O(m)
    // n = 26 (number of the chars in the alphabet)
    // a(n) - inverse ackerman function ~> const
    // m = baseStr.length()
    class Solution {

        class DisjointSet {
            private Map<Character, Character> parent;

            DisjointSet() {
                parent = new HashMap<>();
            }

            // time complexity: O(a(n))
            char find(char ch) {
                parent.putIfAbsent(ch, ch);
                if (parent.get(ch) != ch) {
                    parent.put(ch, find(parent.get(ch)));
                }
                return parent.get(ch);
            }

            // time complexity: O(a(n))
            void union(char a, char b) {
                char parentA = find(a);
                char parentB = find(b);

                if (parentA == parentB) {
                    return;
                }

                if (parentA < parentB) {
                    parent.put(parentB, parentA); // smaller is a parent
                } else {
                    parent.put(parentA, parentB);
                }
            }
        }

        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            int n = s1.length();
            DisjointSet ds = new DisjointSet();
            for (int i = 0; i < n; i++) {
                ds.union(s1.charAt(i), s2.charAt(i));
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < baseStr.length(); i++) {
                char ch = baseStr.charAt(i);
                builder.append(ds.find(ch));
            }

            return builder.toString();
        }
    }
}
