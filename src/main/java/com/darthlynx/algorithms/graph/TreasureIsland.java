package com.darthlynx.algorithms.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreasureIsland {

    private static final String TREASURE = "X";
    private static final String DANGER = "D";

    private static final int[][] DIRECTIONS = {{1,0}, {0,1}, {-1,0}, {0, -1}};


    // TC: O(n*m)
    // SC: O(n*m)
    // where n - number of rows, m - number of columns
    public int findTreasureIsland(String[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));
        grid[0][0] = DANGER; // already checked

        // steps counter
        int counter = 1; // starting from 1 because we already did the {0,0} step

        // BFS
        int updX, updY;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();

                for (int[] direction : DIRECTIONS) {
                    updX = current.x + direction[0];
                    updY = current.y + direction[1];

                    if (isInsideGrid(grid, updX, updY) && !DANGER.equals(grid[updX][updY])) {
                        if (TREASURE.equals(grid[updX][updY])) {
                            return counter;
                        }
                        queue.add(new Point(updX, updY));
                        grid[updX][updY] = DANGER; // already checked
                    }
                }

            }
            counter++;
        }

        return counter;
    }

    // check that new point is not out of bounds
    private boolean isInsideGrid(String[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }


    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
