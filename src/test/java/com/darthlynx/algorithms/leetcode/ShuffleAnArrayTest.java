package com.darthlynx.algorithms.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ShuffleAnArrayTest {

    private ShuffleAnArray test;

    @Test
    public void testShuffle() {
        int[] nums = {1,2,3};
        test = new ShuffleAnArray(nums);
        int[] shuffled = test.shuffle();
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(shuffled));
        assertFalse(Arrays.equals(nums, shuffled));
    }

    @Test
    public void testReset() {
        int[] nums = {1,2,3};
        test = new ShuffleAnArray(nums);
        int[] shuffled = test.shuffle();
        System.out.println(Arrays.toString(shuffled));
//        assertFalse(Arrays.equals(nums, shuffled));
        int[] reset = test.reset();
        System.out.println(Arrays.toString(reset));
        assertArrayEquals(nums, reset);
    }

}