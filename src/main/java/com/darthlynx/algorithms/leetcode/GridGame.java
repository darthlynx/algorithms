package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/grid-game/
public class GridGame {

    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {

        public long gridGame(int[][] grid) {
            long firstRowTotalSum = 0L;
            for (int num : grid[0]) {
                firstRowTotalSum += num;
            }
    
            long firstRowSum = 0;
            long secondRowSum = 0;
    
            long result = Long.MAX_VALUE;
            for (int i = 0; i < grid[0].length; i++) {
                firstRowSum += grid[0][i];
                secondRowSum += grid[1][i];
                long second = Math.max(
                        firstRowTotalSum - firstRowSum,
                        secondRowSum - grid[1][i]);
                result = Math.min(result, second);
            }
    
            return result;
        }
    }
}
