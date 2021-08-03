package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindFirstAndLastPositionOfElementInSortedArrayTest {

    private FindFirstAndLastPositionOfElementInSortedArray test = new FindFirstAndLastPositionOfElementInSortedArray();

    @Test
    public void test1() {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] expectedResult = {3,4};

        int[] actualResult = test.searchRange(nums, target);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void test2() {
        int[] nums = {1,2,2,4,4,5,6};
        int target = 2;

        int[] expectedResult = {1,2};

        int[] actualResult = test.searchRange(nums, target);

        assertArrayEquals(expectedResult, actualResult);
    }

}