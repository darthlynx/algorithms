package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/
public class FindTheNumberOfDistinctColorsAmongTheBalls {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public int[] queryResults(int limit, int[][] queries) {
            int[] result = new int[queries.length];
            Map<Integer, Integer> balls = new HashMap<>(); // ball, color
            Map<Integer, Integer> colors = new HashMap<>(); // color, count

            for (int i = 0; i < queries.length; i++) {
                int ball = queries[i][0];
                int color = queries[i][1];

                if (balls.containsKey(ball)) {
                    int oldColor = balls.get(ball);
                    colors.put(oldColor, colors.get(oldColor) - 1);
                    if (colors.get(oldColor) == 0) {
                        colors.remove(oldColor);
                    }
                }
                balls.put(ball, color);
                colors.put(color, colors.getOrDefault(color, 0) + 1);

                result[i] = colors.size();
            }

            return result;
        }
    }
}
