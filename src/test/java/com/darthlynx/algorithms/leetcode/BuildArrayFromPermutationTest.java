package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuildArrayFromPermutationTest {

    private final BuildArrayFromPermutation test = new BuildArrayFromPermutation();

    @Test
    public void testPermutation() {
        int[] nums = {0,2,1,5,3,4};
        int[] expectedResult = {0,1,2,4,5,3};

        int[] actualResult = test.buildArray(nums);

        assertArrayEquals(expectedResult, actualResult);
    }

}