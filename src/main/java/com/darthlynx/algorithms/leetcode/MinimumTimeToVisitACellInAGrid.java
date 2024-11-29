package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/
public class MinimumTimeToVisitACellInAGrid {

    // Time complexity: O(m*n*log(n*m))
    // Space complexity: O(m*n)
    class Solution {

        static class Node {
            int time;
            int row;
            int col;
    
            Node(int time, int row, int col) {
                this.time = time;
                this.row = row;
                this.col = col;
            }
        }
    
        private static int[] dx = new int[]{-1, 1, 0, 0};
        private static int[] dy = new int[]{0, 0, -1, 1};
    
    
        public int minimumTime(int[][] grid) {
            
            int m = grid.length;
            int n = grid[0].length;
    
            // steps are blocked
            if (grid[0][1] > 1 && grid[1][0] > 1) {
                return -1;
            }
    
            boolean[][] visited = new boolean[m][n];
    
            // nodes in the heap sorted by time
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
            pq.add(new Node(grid[0][0], 0, 0));
    
            while (!pq.isEmpty()) {
                Node current = pq.poll();
    
                if (current.row == m - 1 && current.col == n - 1) {
                    return current.time;
                }
    
                if (visited[current.row][current.col]) {
                    continue;
                }
    
                visited[current.row][current.col] = true;
    
                for (int i = 0; i < 4; i++) {
                    int newRow = current.row + dx[i];
                    int newCol = current.col + dy[i];
    
                    if (isValid(grid, newRow, newCol)) {
                        // wait time calculated as a diff between the time in a grid and current time
                        // we cannot wait in the same cell, so we should waste the time by stepping into the neighbour cell and back
                        // each unit of time wasted takes 2 seconds (to travel there and back)
                        // therefore, if difference between current time and target cell's time is odd,
                        // we can step into target cell exactly when it become available (adding 0)
                        // Otherwise, if difference is even, we'll arrive at the target cell 1 second after it has opened (adding 1)
                        int waitTime = (grid[newRow][newCol] - current.time) % 2 == 0 ? 1 : 0; 
                        int newTime = Math.max(grid[newRow][newCol] + waitTime, current.time + 1);
                        pq.add(new Node(newTime, newRow, newCol));
                    }
                }
            }
    
            return -1;
        }
    
        private boolean isValid(int[][] grid, int row, int col) {
            return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
        }
    }

}
