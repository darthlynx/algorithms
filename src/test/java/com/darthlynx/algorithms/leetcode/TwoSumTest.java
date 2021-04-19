package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TwoSumTest {

    @Test
    public void testTwoSum() {
        TwoSum solution = new TwoSum();

        int[] nums = {3,2,4};
        int target = 6;
        List<Integer> expected = Arrays.asList(1,2);
        int[] res = solution.twoSum(nums,target);
        List<Integer> actual = Arrays.stream(res).boxed().collect(Collectors.toList());
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
        assertTrue(actual.containsAll(expected));
    }

}