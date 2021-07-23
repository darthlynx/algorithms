package com.darthlynx.algorithms.leetcode;

import java.util.*;

// https://leetcode.com/problems/minimum-index-sum-of-two-lists/
public class MinimumIndexSumOfTwoLists {

    // Time complexity: O(n * m + k), where n = l1.length, m = l2.length, k = map.keySet().length
    // Space complexity: O(n+m+k)
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<Integer, Set<String>> map = new HashMap<>();

        int indexSum;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    indexSum = i + j;
                    if (map.containsKey(indexSum)) {
                        map.get(indexSum).add(list1[i]);
                    } else {
                        map.put(indexSum, new HashSet<>(List.of(list1[i])));
                    }
                }
            }
        }


        int min = Integer.MAX_VALUE;
        for (Integer pos : map.keySet()) {
            min = Math.min(min, pos);
        }

        return map.get(min).toArray(new String[0]);
    }

}
