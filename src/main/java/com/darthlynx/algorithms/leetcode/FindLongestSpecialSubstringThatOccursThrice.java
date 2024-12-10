package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/
public class FindLongestSpecialSubstringThatOccursThrice {

    // Time complexity: O(n^3) - n^2 for double loop, one more n for builder.toString()
    // Space complexity: O(n^2)
    class Solution {
        public static final int REQUIRED_OCCURANCE = 3;

        public int maximumLength(String s) {
            Map<String, Integer> counter = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = i; j < s.length(); j++) {
                    if (builder.length() > 0 && builder.charAt(builder.length() - 1) != s.charAt(j)) {
                        break;
                    }
                    builder.append(s.charAt(j));
                    counter.put(builder.toString(), counter.getOrDefault(builder.toString(), 0) + 1);
                }
            }

            int longestSpecial = -1;
            for (Map.Entry<String, Integer> entry : counter.entrySet()) {
                if (entry.getValue() >= REQUIRED_OCCURANCE) {
                    longestSpecial = Math.max(longestSpecial, entry.getKey().length());
                }
            }

            return longestSpecial;
        }
    }

}
