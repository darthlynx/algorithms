package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {

    // Time complexity: O(n*2^n)
    // Space complexity: O(n)
    class Solution {
        public int maxUniqueSplit(String s) {
            Set<String> checked = new HashSet<>();
            return backtrack(s, 0, checked);
        }
    
        private int backtrack(String s, int start, Set<String> checked) {
            if (start == s.length()) {
                return 0;
            }
    
            int maxCount = 0;
    
            for (int end = start + 1; end <= s.length(); end++) {
                String substring = s.substring(start, end);
                if (!checked.contains(substring)) {
                    // add to checked
                    checked.add(substring);
                    // recursively check all unique substrings from the next position
                    // +1 is required to include the current substring
                    maxCount = Math.max(maxCount, 1 + backtrack(s, end, checked));
                    // remove from checked (backtracking)
                    checked.remove(substring);
                }
            }
    
            return maxCount;
        }
    }

}
