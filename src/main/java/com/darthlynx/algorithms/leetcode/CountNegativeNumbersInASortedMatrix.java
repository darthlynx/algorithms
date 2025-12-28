package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
public class CountNegativeNumbersInASortedMatrix {

    // Time complexity: O(m * n)
    // Space complexity: O(1)
    class Solution {
        public int countNegatives(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] < 0) {
                        count += n - j;
                        break;
                    }
                }
            }
            return count;
        }
    }

    // Time complexity: O(m * log n)
    // Space complexity: O(1)
    class Solution2 {
        public int countNegatives(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int count = 0;
            for (int i = 0; i < m; i++) {
                int negativePos = binarySearch(grid, i);
                count += (n - negativePos);
            }

            return count;
        }

        private int binarySearch(int[][] grid, int i) {
            int good = -1;
            int bad = grid[0].length;
            while (bad - good > 1) {
                int mid = good + (bad - good) / 2;
                if (grid[i][mid] < 0) {
                    bad = mid;
                } else {
                    good = mid;
                }
            }
            return bad;
        }
    }
}
