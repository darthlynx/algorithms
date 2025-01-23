package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/count-servers-that-communicate/
public class CountserversThatCommunicate {

    // Time complexity: O(m * n)
    // Space complexity: O(m + n)
    class Solution {
        public int countServers(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[] rCount = new int[m];
            int[] cCount = new int[n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        rCount[i]++;
                        cCount[j]++;
                    }
                }
            }

            int result = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && (rCount[i] > 1 || cCount[j] > 1)) {
                        result++;
                    }
                }
            }

            return result;
        }
    }
}
