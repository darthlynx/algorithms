package com.darthlynx.algorithms.algocademy.hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumIVTest {

    @Test
    public void testTwoSum() {
        int[] nums = {4, 1, 5, 3, 10};
        int target = 9;

        int[] expectedCoordinates = {0, 2};
        int[] resultCoordinates = new TwoSumIV().twoSum(nums, target);

        assertArrayEquals(expectedCoordinates, resultCoordinates);
    }

}