package com.darthlynx.algorithms.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/map-of-highest-peak/
public class MapOfHighestPeak {

    // Time complexity: O(m * n)
    // Space complexity: O(m * n)
    class Solution {

        class Cell {
            int x;
            int y;

            Cell(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        private final int[] dx = new int[] { -1, 1, 0, 0 };
        private final int[] dy = new int[] { 0, 0, -1, 1 };

        public int[][] highestPeak(int[][] isWater) {
            int m = isWater.length;
            int n = isWater[0].length;
            Queue<Cell> q = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isWater[i][j] == 1) {
                        q.offer(new Cell(i, j));
                    }
                }
            }

            boolean[][] visited = new boolean[m][n];
            int[][] height = new int[m][n];

            int level = 0;
            while (!q.isEmpty()) {
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    Cell current = q.poll();
                    height[current.x][current.y] = level;

                    for (int dir = 0; dir < 4; dir++) {
                        int newX = current.x + dx[dir];
                        int newY = current.y + dy[dir];

                        if (isValidCell(newX, newY, isWater, visited)) {
                            q.offer(new Cell(newX, newY));
                            visited[newX][newY] = true;
                        }
                    }
                }

                level++;
            }

            return height;
        }

        private boolean isValidCell(int x, int y, int[][] isWater, boolean[][] visited) {
            return x >= 0 && x < isWater.length &&
                    y >= 0 && y < isWater[0].length &&
                    !visited[x][y] &&
                    isWater[x][y] != 1;
        }
    }
}
