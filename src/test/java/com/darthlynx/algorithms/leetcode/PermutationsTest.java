package com.darthlynx.algorithms.leetcode;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PermutationsTest {

    private Permutations test = new Permutations();

    @Test @Ignore
    public void test1() {
        int[] nums = {1,2,3};

        List<List<Integer>> expectedResult = List.of(List.of(1,2,3), List.of(1,3,2),
                List.of(2,1,3), List.of(2,3,1), List.of(3,1,2), List.of(3,2,1));

        List<List<Integer>> actualResult = test.permute(nums);

        assertEquals(expectedResult, actualResult);
    }

}