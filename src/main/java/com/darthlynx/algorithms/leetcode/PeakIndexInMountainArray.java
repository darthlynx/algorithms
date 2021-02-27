package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PeakIndexInMountainArray {

    // https://leetcode.com/problems/peak-index-in-a-mountain-array/
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid+1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    @Test
    public void testPeakIndexInMountainArray() {
        int[] arr = {0,2,1,0};
        int expected = 1;
        int actual = peakIndexInMountainArray(arr);
        assertEquals(expected, actual);
    }
}
