package com.darthlynx.algorithms.leetcode;

import java.util.*;

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

}
