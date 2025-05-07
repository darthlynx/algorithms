package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/
public class FindMinimumTimeToReachLastRoom {

    // Time complexity: O((n*m)*log(n*m))
    // Space complexity: O(n*m)
    class Solution {

        private static int[] dx = new int[] { -1, 1, 0, 0 };
        private static int[] dy = new int[] { 0, 0, -1, 1 };

        public int minTimeToReach(int[][] moveTime) {
            int n = moveTime.length;
            int m = moveTime[0].length;
            boolean[][] visited = new boolean[n][m];

            int[][] distances = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(distances[i], Integer.MAX_VALUE);
            }
            distances[0][0] = 0;

            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

            // int[]{time, i, j}
            queue.add(new int[] { moveTime[0][0], 0, 0 });

            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[1];
                int y = cell[2];

                visited[x][y] = true;

                // add neighbours
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];

                    if (isValid(newX, newY, n, m, visited)) {
                        int newTime = Math.max(distances[x][y], moveTime[newX][newY]) + 1;
                        if (distances[newX][newY] > newTime) {
                            distances[newX][newY] = newTime;
                            queue.offer(new int[] { newTime, newX, newY });
                        }
                    }
                }
            }

            return distances[n - 1][m - 1];
        }

        private boolean isValid(int x, int y, int n, int m, boolean[][] visited) {
            return x >= 0 && x < n && y >= 0 && y < m && !visited[x][y];
        }
    }
}
