package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/trapping-rain-water-ii/
public class TrappingRainWaterTwo {

    // Time complexity: O(m * n * log(m * n))
    // Space complexity: O(m * n)
    class Solution {

        class Cell {
            int height;
            int row;
            int col;
    
            Cell(int height, int row, int col) {
                this.height = height;
                this.row = row;
                this.col = col;
            }
        }
    
        private int[] dx = new int[] { 0, 0, -1, 1 };
        private int[] dy = new int[] { -1, 1, 0, 0 };
    
        public int trapRainWater(int[][] heightMap) {
            int rows = heightMap.length;
            int cols = heightMap[0].length;
    
            boolean[][] visited = new boolean[rows][cols];
    
            // min heap
            PriorityQueue<Cell> boundary = new PriorityQueue<>((a, b) -> Integer.compare(a.height, b.height));
    
            // add boundaries (first and last column and row)
            for (int i = 0; i < cols; i++) {
                boundary.offer(new Cell(heightMap[0][i], 0, i));
                boundary.offer(new Cell(heightMap[rows - 1][i], rows - 1, i));
                visited[0][i] = true;
                visited[rows - 1][i] = true;
            }
            for (int i = 0; i < rows; i++) {
                boundary.offer(new Cell(heightMap[i][0], i, 0));
                boundary.offer(new Cell(heightMap[i][cols - 1], i, cols - 1));
                visited[i][0] = true;
                visited[i][cols - 1] = true;
            }
    
            int totalWater = 0;
    
            while (!boundary.isEmpty()) {
                // selecting the cell from the boundary with the smallest height
                Cell curr = boundary.poll();
    
                int currRow = curr.row;
                int currCol = curr.col;
                int currHeight = curr.height;
    
                for (int i = 0; i < 4; i++) {
                    int newRow = currRow + dx[i];
                    int newCol = currCol + dy[i];
    
                    if (isValidCell(newRow, newCol, rows, cols) && !visited[newRow][newCol]) {
                        int newHeight = heightMap[newRow][newCol];
    
                        if (newHeight < currHeight) {
                            totalWater += (currHeight - newHeight);
                        }
    
                        boundary.offer(new Cell(Math.max(newHeight, currHeight), newRow, newCol));
                        visited[newRow][newCol] = true;
                    }
                }
            }
    
            return totalWater;
        }
    
        private boolean isValidCell(int x, int y, int rows, int cols) {
            return x >= 0 && x < rows && y >= 0 && y < cols;
        }
    }
}
