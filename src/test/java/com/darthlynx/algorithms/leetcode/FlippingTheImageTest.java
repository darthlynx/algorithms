package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlippingTheImageTest {

    private FlippingTheImage test = new FlippingTheImage();

    @Test
    public void test1() {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] expectedResult = {{1,0,0},{0,1,0},{1,1,1}};

        int[][] actualResult = test.flipAndInvertImage(image);

        assertEquals(expectedResult.length, actualResult.length);

        for (int i = 0; i < expectedResult.length; i++) {
            assertArrayEquals(expectedResult[i], actualResult[i]);
        }
    }
}