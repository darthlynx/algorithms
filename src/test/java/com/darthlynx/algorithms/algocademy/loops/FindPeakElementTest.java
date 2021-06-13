package com.darthlynx.algorithms.algocademy.loops;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindPeakElementTest {

    @Test
    public void testFindPeakElement() {
        int[] nums = {1, 2, 3, 1};
        int expectedResult = 2;

        int actualResult = new FindPeakElement().findPeakElement(nums);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindPeakElement2() {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int expectedResult = 1; // or 5

        int actualResult = new FindPeakElement().findPeakElement(nums);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindPeakIfItIsAtTheBeginning() {
        int[] nums = {3, 2, 1};
        int expectedResult = 0;

        int actualResult = new FindPeakElement().findPeakElement(nums);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindPeakIfItIsAtTheEnd() {
        int[] nums = {1, 2, 3};
        int expectedResult = 2;

        int actualResult = new FindPeakElement().findPeakElement(nums);

        assertEquals(expectedResult, actualResult);
    }

}