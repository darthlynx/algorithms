package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
public class MinimumTimeToMakeRopeColorful {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {
        public int minCost(String colors, int[] neededTime) {
            int result = 0;
            int max = neededTime[0];
            int currentSum = max;

            for (int i = 1; i < neededTime.length; i++) {
                if (colors.charAt(i) == colors.charAt(i - 1)) {
                    currentSum += neededTime[i];
                    max = Math.max(max, neededTime[i]);
                } else {
                    // updating result when color changes
                    result += currentSum - max;
                    // reset currentSum and max
                    max = neededTime[i];
                    currentSum = max;
                }
            }
            // updating result for the last group
            result += currentSum - max;

            return result;
        }
    }
}
