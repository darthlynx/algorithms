package com.darthlynx.algorithms.bytopic.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class DeliverService {

    private static final int ACCESSIBLE = 1;
    private static final int RESTRICTED = 0;
    private static final int DESTINATION = 9;

    // two-dimensional grid to represent left, right, top and bottom steps
    private static final int[][] DIRECTIONS = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public int findTheShortestPath(int numRows, int numColumns, int[][] grid) {
        if (numRows <= 0 || numColumns <= 0 || grid == null) {
            return -1;
        }

        boolean isFound = false;

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));
        grid[0][0] = RESTRICTED; // mark as visited

        // BFS approach
        int counter = 1;

        int updX, updY;
        while (!queue.isEmpty()) {

            int size = queue.size(); // fix the size, because we want to check neighbour cells layer by layer
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();

                for (int[] direction : DIRECTIONS) {
                    updX = current.x + direction[0];
                    updY = current.y + direction[1];

                    if (isInsideGrid(grid, updX, updY) && isNotRestricted(grid, updX, updY)) {
                        if (isDestinationReached(grid, updX, updY)) {
                            isFound = true;
                            return counter;
                        }
                        queue.add(new Point(updX, updY));
                        grid[updX][updY] = RESTRICTED; // mark as visited
                    }
                }

            }
            counter++;

        }

        return isFound ? counter : -1;
    }

    private boolean isInsideGrid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    private boolean isNotRestricted(int[][] grid, int x, int y) {
        return grid[x][y] != RESTRICTED;
    }

    private boolean isDestinationReached(int[][] grid, int x, int y) {
        return grid[x][y] == DESTINATION;
    }

    // Helper class to hold the current point's coordinates
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
