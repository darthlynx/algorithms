package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeakIndexInMountainArrayTest {

    @Test
    public void testPeakIndexInMountainArray() {
        int[] arr = {0,2,1,0};
        int expected = 1;
        int actual = new PeakIndexInMountainArray().peakIndexInMountainArray(arr);
        assertEquals(expected, actual);
    }
}