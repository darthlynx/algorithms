package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/maximum-score-after-splitting-a-string/
public class MaximumScoreAfterSplittingAString {

    // Time complexity: O(N)
    // Space complexity: O(1)
    class Solution {
        public int maxScore(String s) {
            int totalOnes = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1') {
                    totalOnes++;
                }
            }
    
            int maxScore = 0;
            int zeroes = 0;
            int ones = totalOnes;
    
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == '0') {
                    zeroes++;
                } else {
                    ones--;
                }
                maxScore = Math.max(maxScore, zeroes + ones);
            }
    
            return maxScore;
        }
    }
}
