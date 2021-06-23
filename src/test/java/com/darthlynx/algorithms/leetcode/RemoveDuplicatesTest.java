package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesTest {

    @Test
    public void testRemoveElement() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int expectedResult = 5;
        int[] expectedNums = {0,1,2,3,4,-1,-1,-1,-1,-1};

        int actualResult = new RemoveDuplicates().removeDuplicates(nums);
        assertEquals(expectedResult, actualResult);

        for (int i = 0; i < actualResult; i++) {
            assertEquals(nums[i], expectedNums[i]);
        }
    }

}