package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumPathSumTest {

    private MinimumPathSum test = new MinimumPathSum();

    @Test
    public void testMinPathSum() {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};

        int expectedResult = 7;

        int actualResult = test.minPathSum(grid);

        assertEquals(expectedResult, actualResult);
    }

}