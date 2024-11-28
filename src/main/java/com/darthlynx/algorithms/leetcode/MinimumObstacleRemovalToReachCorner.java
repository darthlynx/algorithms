package com.darthlynx.algorithms.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/
public class MinimumObstacleRemovalToReachCorner {

    // Dijkstra algorithm (for weighted graph)
    // Time complexity: O(m*n*log(m*n))
    // Space complexity: O(m*n)
    class Solution1 {

        static class Node {
            int obstacleCount;
            int row;
            int column;
    
            Node(int obstacleCount, int row, int column) {
                this.obstacleCount = obstacleCount;
                this.row = row;
                this.column = column;
            }
        }
    
        private static int[] dx = new int[] { -1, 1, 0, 0 };
        private static int[] dy = new int[] { 0, 0, -1, 1 };
        
        public int minimumObstacles(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
    
            int[][] minObstacles = new int[m][n];
    
            for (int[] row : minObstacles) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            // calculate obstacles in first node
            minObstacles[0][0] = grid[0][0];
            
            // sort nodes by number of obstacles
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.obstacleCount, b.obstacleCount));
            pq.add(new Node(minObstacles[0][0], 0, 0));
    
            while (!pq.isEmpty()) {
                Node current = pq.poll();
    
                if (current.row == m - 1 && current.column == n - 1) {
                    return current.obstacleCount;
                }
    
                for (int i = 0; i < 4; i++) {
                    int newRow = current.row + dx[i];
                    int newColumn = current.column + dy[i];
    
                    if (isValid(grid, newRow, newColumn)) {
                        int newObstacles = current.obstacleCount + grid[newRow][newColumn];
    
                        if (newObstacles < minObstacles[newRow][newColumn]) {
                            minObstacles[newRow][newColumn] = newObstacles;
                            pq.add(new Node(newObstacles, newRow, newColumn));
                        }
                    }
                }
            }
    
            return minObstacles[m - 1][n - 1];
        }
    
        private boolean isValid(int[][] grid, int row, int col) {
            return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
        }
    }


    // 0-1 BFS
    // https://codeforces.com/blog/entry/22276
    // Time complexity: O(m*n)
    // Space complexity: O(m*n)
    class Solution2 {

        static class Node {
            int obstacleCount;
            int row;
            int column;
    
            Node(int obstacleCount, int row, int column) {
                this.obstacleCount = obstacleCount;
                this.row = row;
                this.column = column;
            }
        }
    
        private static int[] dx = new int[] { -1, 1, 0, 0 };
        private static int[] dy = new int[] { 0, 0, -1, 1 };

        public int minimumObstacles(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
    
            int[][] minObstacles = new int[m][n];
    
            for (int[] row : minObstacles) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            
            // calculate obstacles in first node
            minObstacles[0][0] = grid[0][0];

            Deque<Node> deque = new ArrayDeque<>();
            deque.add(new Node(minObstacles[0][0], 0, 0));

            while (!deque.isEmpty()) {
                Node current = deque.poll();

                for (int i = 0; i < 4; i++) {
                    int newRow = current.row + dx[i];
                    int newCol = current.column + dy[i];

                    // if valid and not processed yet
                    if (isValid(grid, newRow, newCol) && minObstacles[newRow][newCol] == Integer.MAX_VALUE) {

                        // if obstacle, add to the end of the queue
                        if (grid[newRow][newCol] == 1) {
                            minObstacles[newRow][newCol] = current.obstacleCount + 1;
                            deque.addLast(new Node(minObstacles[newRow][newCol], newRow, newCol));
                        } else { // otherwise, add to the beginning of the queue
                            minObstacles[newRow][newCol] = current.obstacleCount;
                            deque.addFirst(new Node(minObstacles[newRow][newCol], newRow, newCol));
                        }
                    }
                }
            }
            return minObstacles[m-1][n-1];
        }

        private boolean isValid(int[][] grid, int row, int col) {
            return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
        }
    }

}
