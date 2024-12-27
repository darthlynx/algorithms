package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/best-sightseeing-pair/
public class BestSightseeingPair {

    // Time complexity: O(N)
    // Space complexity: O(1)
    class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int maxValue = 0;
            int maxLeftValue = values[0];

            for (int i = 1; i < values.length; i++) {
                // calculating current right pair value and recalculate the maxValue based on it
                int currentRightValue = values[i] - i;
                maxValue = Math.max(maxValue, maxLeftValue + currentRightValue);

                // calculate the current left pair and check if it is bigger than existing one
                int currentLeftValue = values[i] + i;
                maxLeftValue = Math.max(maxLeftValue, currentLeftValue);
            }

            return maxValue;
        }
    }
}
