package com.darthlynx.algorithms.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortedArraysTest {

    private MergeSortedArrays solution;

    @Before
    public void setUp() {
        solution = new MergeSortedArrays();
    }

    @Test
    public void testMergeNonEmptySortedArrays() {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        solution.merge(nums1, m, nums2, n);

        int[] expectedResult = {1,2,2,3,5,6};
        assertTrue(Arrays.equals(nums1, expectedResult));
    }

    @Test
    public void testMergeNonEmptySortedArrays2() {
        int[] nums1 = {2,0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;

        solution.merge(nums1, m, nums2, n);

        int[] expectedResult = {1,2};
        assertTrue(Arrays.equals(nums1, expectedResult));
    }

    @Test
    public void testMergeSortedArraysWhereOneIsEmpty() {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;

        solution.merge(nums1, m, nums2, n);
        int[] expectedResult = {1};

        assertTrue(Arrays.equals(nums1, expectedResult));
    }

}