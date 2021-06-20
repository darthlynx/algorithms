package com.darthlynx.algorithms.algocademy.loops;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesFromArrayTest {

    @Test
    public void testRemoveDuplicates() {
        int[] initial = {2, 3, 1, 1, 4, 3, -2, 1};
        int[] expectedResult = {2, 3, 1, 4, -2};

        int[] actualResult = new RemoveDuplicatesFromArray().removeDuplicates(initial);
        assertArrayEquals(expectedResult, actualResult);
    }

}