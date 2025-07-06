package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/finding-pairs-with-a-certain-sum/
public class FindingPairsWithACertainSum {

    class FindSumPairs {

        private final int[] nums1;
        private final int[] nums2;
        private final Map<Integer, Integer> valueToFreq;

        // Time complexity: O(m), where m = nums2.length
        // Space complexity: O(m)
        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;

            valueToFreq = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) {
                valueToFreq.put(nums2[i], valueToFreq.getOrDefault(nums2[i], 0) + 1);
            }
        }

        // Time complexity: O(1)
        // Space complexity: O(1)
        public void add(int index, int val) {
            // remove old value
            int key = nums2[index];
            int oldFreq = valueToFreq.get(nums2[index]);
            if (oldFreq == 1) {
                valueToFreq.remove(key);
            } else {
                valueToFreq.put(key, oldFreq - 1);
            }

            // add new value
            nums2[index] += val;
            valueToFreq.put(nums2[index], valueToFreq.getOrDefault(nums2[index], 0) + 1);
        }

        // Time complexity: O(n), where n = nums1.length
        // Space complexity: O(1)
        public int count(int tot) {
            int count = 0;
            for (int num : nums1) {
                if (valueToFreq.containsKey(tot - num)) {
                    count += valueToFreq.get(tot - num);
                }
            }

            return count;
        }
    }

    /**
     * Your FindSumPairs object will be instantiated and called as such:
     * FindSumPairs obj = new FindSumPairs(nums1, nums2);
     * obj.add(index,val);
     * int param_2 = obj.count(tot);
     */
}
