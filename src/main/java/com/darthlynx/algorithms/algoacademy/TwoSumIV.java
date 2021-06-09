package com.darthlynx.algorithms.algoacademy;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIV {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexOfValue = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int secondNumber = target - nums[i];
            if (indexOfValue.containsKey(secondNumber)) {
                return new int[]{indexOfValue.get(secondNumber), i};
            } else {
                indexOfValue.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}
