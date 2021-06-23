package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveElementTest {

    @Test
    public void testRemoveElement() {
        int[] nums = {3,2,2,3};
        int value = 3;

        int expectedResult = 2;
        int[] expectedNums = {2,2};

        int actualResult = new RemoveElement().removeElement(nums, value);
        assertEquals(expectedResult, actualResult);

        for (int i = 0; i < actualResult; i++) {
            assertEquals(nums[i], expectedNums[i]);
        }
    }

}