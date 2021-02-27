package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TwoSum {

    // https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> checked = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int lookFor = target - nums[i];
            if (checked.containsKey(lookFor)) {
                return new int[]{i, checked.get(lookFor)};
            } else {
                checked.put(nums[i], i);
            }
        }
        return new int[2];
    }

    @Test
    public void testTwoSum() {
        int[] nums = {3,2,4};
        int target = 6;
        List<Integer> expected = Arrays.asList(1,2);
        int[] res = twoSum(nums,target);
        List<Integer> actual = Arrays.stream(res).boxed().collect(Collectors.toList());
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
        assertTrue(actual.containsAll(expected));
    }
}
