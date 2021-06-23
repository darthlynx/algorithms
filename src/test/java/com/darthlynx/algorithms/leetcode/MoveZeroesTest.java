package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MoveZeroesTest {

    @Test
    public void testMoveZeroesForArrayOfZeroes() {
        int[] nums = {0};

        int[] expectedResult = {0};

        new MoveZeroes().moveZeroes(nums);
        assertArrayEquals(expectedResult, nums);
    }

    @Test
    public void testMoveZeroesToTheEndOfTheArray() {
        int[] nums = {0,1,0,3,12};

        int[] expectedResult = {1,3,12,0,0};

        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        assertArrayEquals(expectedResult, nums);
    }

}