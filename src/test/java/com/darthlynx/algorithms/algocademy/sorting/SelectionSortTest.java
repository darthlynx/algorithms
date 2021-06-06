package com.darthlynx.algorithms.algocademy.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionSortTest {

    @Test
    public void testSelectionSort() {
        int[] nums = {3, 1, 10, 8, 7};
        int[] expectedResult = {1, 3, 7, 8, 10};

        new SelectionSort().sort(nums);

        assertArrayEquals(nums, expectedResult);
    }

}