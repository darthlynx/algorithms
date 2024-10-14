package com.darthlynx.algorithms.leetcode;

import java.util.Queue;
import java.util.LinkedList;

// https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {

    class Solution {

        private int[] dx = new int[]{-1, 1, 0, 0};
        private int[] dy = new int[]{0, 0, -1, 1};
    
        public int orangesRotting(int[][] grid) {
            
            Queue<int[]> q = new LinkedList<>();
            
            // put all rotten fruits locations into the queue
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) { // rotten
                        q.offer(new int[]{i, j});
                    }
                }
            }
            int minutes = 0;
            while (!q.isEmpty()) {
                int size = q.size();
    
                for (int i = 0; i < size; i++) {
                    int[] fruit = q.poll();
    
                    for (int k = 0; k < 4; k++) {
                        add(fruit[0] + dx[k], fruit[1] + dy[k], q, grid);
                    }
                }
                if (!q.isEmpty()) {
                    minutes++;
                }
            }
            
            // if any fresh fruits left - return -1
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
    
            return minutes;
        }
    
        private void add(int x, int y, Queue<int[]> q, int[][] grid) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
                return;
            }
            grid[x][y] = 2; // mark as rotten
            q.offer(new int[]{x, y});
        }
    }

}
