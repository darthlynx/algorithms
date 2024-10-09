package com.darthlynx.algorithms.leetcode;

import java.util.Queue;
import java.util.LinkedList;

// [Premium] https://leetcode.com/problems/walls-and-gates/description/
public class WallsAndGates {

    /*
    You are given a m×n 2D grid initialized with these three possible values:

    -1 - A wall that can not be traversed.
    0 - A gate.
    INF - means an empty room that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.

    Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should remain INF.
    Assume the grid can only be traversed up, down, left, or right.

    Example 1:

    Input: [
        [2147483647,-1,0,2147483647],
        [2147483647,2147483647,2147483647,-1],
        [2147483647,-1,2147483647,-1],
        [0,-1,2147483647,2147483647]
    ]

    Output: [
        [3,-1,0,1],
        [2,2,1,-1],
        [1,-1,2,-1],
        [0,-1,3,4]
    ]

    Example 2:

    Input: [
        [0,-1],
        [2147483647,2147483647]
    ]

    Output: [
        [0,-1],
        [1,2]
    ]

    Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 100
    grid[i][j] is one of {-1, 0, 2147483647}
     */
    class Solution {

        private int[] dx = new int[]{0, 0, -1, 1};
        private int[] dy = new int[]{-1, 1, 0, 0};
    
        public void wallsAndGates(int[][] grid) {
    
            int m = grid.length;
            int n = grid[0].length;
    
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> q = new LinkedList<>();
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        visited[i][j] = true;
                        q.add(new int[]{i, j});
                    }
                }
            }
    
            int distance = 0;
    
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] cell = q.poll();
                    int x = cell[0];
                    int y = cell[1];
                    grid[x][y] = distance;
    
                    for (int k = 0; k < 4; k++) {
                        addCell(x + dx[k], y + dy[k], visited, q, grid);
                    }
                }
                distance++;
            }
        }
    
        private void addCell(int i, int j, boolean[][] visited, Queue<int[]> q, int[][] grid) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length 
                || grid[i][j] == -1 || visited[i][j]) {
                return;
            }
            visited[i][j] = true;
            q.add(new int[]{i, j});
        }
    }
    
}
