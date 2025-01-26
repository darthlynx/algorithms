package com.darthlynx.algorithms.bytopic.graph;

import org.junit.Test;

import com.darthlynx.algorithms.bytopic.graph.TreasureIsland;

import static org.junit.Assert.*;

public class TreasureIslandTest {

    private TreasureIsland test = new TreasureIsland();

    @Test
    public void test1() {
        String[][] grid = { { "O", "O", "O", "O" },
                { "D", "O", "D", "O" },
                { "O", "O", "O", "O" },
                { "X", "D", "D", "O" } };

        int expectedNumberOfMoves = 5;

        int actualNumberOfMoves = test.findTreasureIsland(grid);

        assertEquals(expectedNumberOfMoves, actualNumberOfMoves);
    }

    @Test
    public void testCornerCase1() {
        String[][] grid = {};

        int expectedNumberOfMoves = 0;
        int actualNumberOfMoves = test.findTreasureIsland(grid);

        assertEquals(expectedNumberOfMoves, actualNumberOfMoves);
    }

    @Test
    public void testCornerCase2() {
        String[][] grid = null;

        int expectedNumberOfMoves = 0;
        int actualNumberOfMoves = test.findTreasureIsland(grid);

        assertEquals(expectedNumberOfMoves, actualNumberOfMoves);
    }

    @Test
    public void testCornerCase3() {
        String[][] grid = { {}, {}, {} };

        int expectedNumberOfMoves = 0;
        int actualNumberOfMoves = test.findTreasureIsland(grid);

        assertEquals(expectedNumberOfMoves, actualNumberOfMoves);
    }

}