package com.darthlynx.algorithms.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeliverServiceTest {

    private DeliverService test = new DeliverService();

    @Test
    public void test1() {
        int[][] grid = {{1, 0, 0},
                        {1, 0, 0},
                        {1, 9, 0}};

        int expectedNumberOfMoves = 3;

        int actualNumberOfMoves = test.findTheShortestPath(3, 3, grid);

        assertEquals(expectedNumberOfMoves, actualNumberOfMoves);
    }

    @Test
    public void test2() {
        int[][] grid = {{1, 0},
                        {0, 9}};

        int expectedNumberOfMoves = -1;

        int actualNumberOfMoves = test.findTheShortestPath(2, 2, grid);

        assertEquals(expectedNumberOfMoves, actualNumberOfMoves);
    }

    @Test
    public void test3() {
        int[][] grid = {{},{}};

        int expectedNumberOfMoves = -1;

        int actualNumberOfMoves = test.findTheShortestPath(0, 0, grid);

        assertEquals(expectedNumberOfMoves, actualNumberOfMoves);
    }

}