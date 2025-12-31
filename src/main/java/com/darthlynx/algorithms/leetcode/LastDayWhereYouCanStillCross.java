package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/last-day-where-you-can-still-cross/
public class LastDayWhereYouCanStillCross {

    // Time complexity: O((r * c) * log d)
    // Space complexity: O(r * c)
    // where d = number of days, r = number of rows, c = number of columns
    class Solution {
        public int latestDayToCross(int row, int col, int[][] cells) {
            int days = cells.length; // number of days
            int good = -1;
            int bad = days;

            while (bad - good > 1) {
                int mid = good + (bad - good) / 2;
                if (canCross(mid, row, col, cells)) {
                    good = mid;
                } else {
                    bad = mid;
                }
            }

            return good;
        }

        private boolean canCross(int day, int row, int col, int[][] cells) {
            int[][] matrix = new int[row][col];
            for (int i = 0; i < day; i++) {
                int r = cells[i][0] - 1;
                int c = cells[i][1] - 1;
                matrix[r][c] = 1;
            }

            boolean[][] visited = new boolean[row][col];
            for (int j = 0; j < col; j++) {
                if (dfs(0, j, matrix, visited)) {
                    return true;
                }
            }

            return false;
        }

        private static final int[] dx = { -1, 1, 0, 0 };
        private static final int[] dy = { 0, 0, -1, 1 };

        private boolean dfs(int r, int c, int[][] matrix, boolean[][] visited) {
            if (r >= matrix.length || r < 0 || c >= matrix[0].length || c < 0 || visited[r][c] || matrix[r][c] == 1) {
                return false;
            }
            if (r == matrix.length - 1) {
                return true;
            }
            visited[r][c] = true;
            for (int i = 0; i < 4; i++) {
                if (dfs(r + dx[i], c + dy[i], matrix, visited)) {
                    return true;
                }
            }
            return false;
        }
    }
}
