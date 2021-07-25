package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RotateArrayTest {

    private RotateArray test = new RotateArray();

    @Test
    public void test1() {
        int[] nums = {1,2,3,4};
        int k = 2;
        int[] expectedResult = {3,4,1,2};

        test.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
        assertArrayEquals(expectedResult, nums);
    }

    @Test
    public void test2() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        int[] expectedResult = {5,6,7,1,2,3,4};

        test.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
        assertArrayEquals(expectedResult, nums);
    }

    @Test
    public void test3() {
        int[] nums = {-1,-100,3,99};
        int k = 3;
        int[] expectedResult = {-100,3,99,-1};

        test.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
        assertArrayEquals(expectedResult, nums);
    }

    @Test
    public void test4() {
        int[] nums = {1,2};
        int k = 3;
        int[] expectedResult = {2,1};

        test.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
        assertArrayEquals(expectedResult, nums);
    }

    @Test
    public void test5() {
        int[] nums = {1,2};
        int k = 5;
        int[] expectedResult = {2,1};

        test.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
        assertArrayEquals(expectedResult, nums);
    }

}