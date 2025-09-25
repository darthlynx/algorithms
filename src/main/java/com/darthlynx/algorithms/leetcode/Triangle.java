package com.darthlynx.algorithms.leetcode;

import java.util.List;

// https://leetcode.com/problems/triangle/
public class Triangle {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int h = triangle.size();
            int[][] dp = new int[h][];
            for (int i = 0; i < h; i++) {
                dp[i] = new int[i + 1];
            }

            // add last line without changes
            List<Integer> lastLine = triangle.get(triangle.size() - 1);
            for (int i = 0; i < lastLine.size(); i++) {
                dp[h - 1][i] = lastLine.get(i);
            }

            // skipping first line
            for (int i = h - 2; i >= 0; i--) {
                List<Integer> line = triangle.get(i);
                for (int j = 0; j < line.size(); j++) {
                    int min = Math.min(
                            dp[i + 1][j] + line.get(j),
                            dp[i + 1][j + 1] + line.get(j));
                    dp[i][j] = min;
                }
            }

            return dp[0][0];
        }
    }
}
