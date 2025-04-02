package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/solving-questions-with-brainpower/description/
public class SolvingQuestionsWithBrainpower {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public long mostPoints(int[][] questions) {
            int n = questions.length;
            long[] dp = new long[n];

            for (int i = n - 1; i >= 0; i--) {
                long points = questions[i][0];
                int brainpower = questions[i][1];

                long solve = points + (i + brainpower + 1 >= n ? 0 : dp[i + brainpower + 1]);

                long skip = (i + 1 >= n ? 0 : dp[i + 1]);
                dp[i] = Math.max(solve, skip);
            }

            long res = Long.MIN_VALUE;
            // System.out.println(Arrays.toString(dp));
            for (long points : dp) {
                res = Math.max(res, points);
            }

            return res;
        }
    }
}
