package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-square-streak-in-an-array/
public class LongestSquareStreakInAnArray {

    // Time complexity: O(N*logN)
    // Space complexity: O(N)
    class Solution {
        public int longestSquareStreak(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
    
            int maxStreak = 1;
    
            int biggestPossibleSquare = (int) Math.sqrt(Integer.MAX_VALUE);
    
            for (int num : nums) {
                int currStreak = 1;
                int c = num;
                while (c <= biggestPossibleSquare && set.contains(c * c)) {
                    currStreak++;
                    c = c * c;
                }
                maxStreak = Math.max(maxStreak, currStreak);
            }
    
            return maxStreak >= 2 ? maxStreak : -1;
        }
    }

}
