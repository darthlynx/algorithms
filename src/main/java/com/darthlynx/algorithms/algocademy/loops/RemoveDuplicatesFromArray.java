package com.darthlynx.algorithms.algocademy.loops;

import java.util.LinkedHashSet;
import java.util.Set;

// https://algocademy.com/app/#problem/remove-duplicates-from-array/lang/java/solution/1-1
public class RemoveDuplicatesFromArray {

    public int[] removeDuplicates(int[] nums) {
        Set<Integer> unique = new LinkedHashSet<>();

        for (int num : nums) {
            if (!unique.contains(num)) {
                unique.add(num);
            }
        }
        return unique.stream().mapToInt(Number::intValue).toArray();
    }
}
