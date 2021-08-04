package com.darthlynx.algorithms.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreasureIsland {

    private static final String TREASURE = "X";
    private static final String DANGER = "D";

    private static final int[][] DIRECTIONS = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public int findTreasureIsland(String[][] grid) {

        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(new Coordinate(0,0));
        grid[0][0] = DANGER;
        int steps = 1; // starting from 1 because we made a first step as [0,0]

        // BFS
        int updX, updY;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate position = queue.poll();

                // checking left, right, top and bottom positions from the current one
                for (int[] direction : DIRECTIONS) {
                    updX = position.x + direction[0];
                    updY = position.y + direction[1];

                    if (isInsideGrid(grid, updX, updY) && !DANGER.equals(grid[updX][updY])) {
                        if (TREASURE.equals(grid[updX][updY])) {
                            return steps;
                        }
                        queue.add(new Coordinate(updX, updY));
                        grid[updX][updY] = DANGER; // means that this cell is already visited
                    }
                }
            }
            steps++;
        }

        return steps;
    }

    private boolean isInsideGrid(String[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
