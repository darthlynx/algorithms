package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/string-matching-in-an-array/
public class StringMatchingInAnArray {

    // Time complexity: O(m * n^2)
    // Space complexity: O(n * m)
    // where m is the length of the longest word
    class Solution {
        public List<String> stringMatching(String[] words) {
            List<String> result = new ArrayList<>();

            for (String word : words) {
                for (String otherWord : words) {
                    if (otherWord.equals(word)) {
                        continue;
                    }
                    if (otherWord.contains(word)) {
                        result.add(word);
                        break;
                    }
                }
            }

            return result;
        }
    }
}
