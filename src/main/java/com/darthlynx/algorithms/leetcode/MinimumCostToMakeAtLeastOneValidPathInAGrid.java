package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
public class MinimumCostToMakeAtLeastOneValidPathInAGrid {

    // Time complexity: O(n * m * log(n*m))
    // Space complexity: O(n * m)
    // where n = rows.length; m = cols.length;
    class Solution {

        class Cell {
            int cost; // cost of change. Could be 1 or 0
            int row;
            int col;

            Cell(int cost, int row, int col) {
                this.cost = cost;
                this.row = row;
                this.col = col;
            }
        }

        private final int[] dx = new int[] { 0, 0, 1, -1 };
        private final int[] dy = new int[] { 1, -1, 0, 0 };

        // Using Dijkstra algo for the shortest path
        public int minCost(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;

            PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
            pq.offer(new Cell(0, 0, 0));

            int[][] minCost = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                Arrays.fill(minCost[i], Integer.MAX_VALUE);
            }
            minCost[0][0] = 0;

            while (!pq.isEmpty()) {
                Cell curr = pq.poll();

                // skip if we have found a better path to this cell already
                if (minCost[curr.row][curr.col] != curr.cost) {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int newRow = curr.row + dx[i];
                    int newCol = curr.col + dy[i];

                    if (isValidCell(newRow, newCol, rows, cols)) {
                        // delta is 1 if we need to change direction and 0 if not
                        int delta = i != (grid[curr.row][curr.col] - 1) ? 1 : 0;
                        int newCost = curr.cost + delta;

                        if (minCost[newRow][newCol] > newCost) {
                            minCost[newRow][newCol] = newCost;
                            pq.offer(new Cell(newCost, newRow, newCol));
                        }
                    }
                }
            }

            return minCost[rows - 1][cols - 1];
        }

        private boolean isValidCell(int x, int y, int rows, int cols) {
            return x >= 0 && x < rows && y >= 0 && y < cols;
        }
    }
}
