package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/
public class FindMinimumTimeToReachLastRoomII {

    // Time complexity: O((n*m)*log(n*m))
    // Space complexity: O(n*m)
    class Solution {

        private static int[] dx = new int[] { -1, 1, 0, 0 };
        private static int[] dy = new int[] { 0, 0, -1, 1 };

        public int minTimeToReach(int[][] moveTime) {
            int n = moveTime.length;
            int m = moveTime[0].length;

            boolean[][] visited = new boolean[n][m];

            int[][] times = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(times[i], Integer.MAX_VALUE);
            }
            times[0][0] = 0;

            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
            queue.add(new int[] { moveTime[0][0], 0, 0 });

            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[1];
                int y = cell[2];

                visited[x][y] = true;

                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];

                    if (isValid(newX, newY, n, m, visited)) {
                        int delta = (x + y) % 2 + 1; // takes 1 or 2 second
                        int newTime = Math.max(moveTime[newX][newY], times[x][y]) + delta;
                        if (times[newX][newY] > newTime) {
                            times[newX][newY] = newTime;
                            queue.add(new int[] { newTime, newX, newY });
                        }
                    }
                }
            }

            return times[n - 1][m - 1];
        }

        private boolean isValid(int x, int y, int n, int m, boolean[][] visited) {
            return x >= 0 && x < n && y >= 0 && y < m && !visited[x][y];
        }
    }
}
