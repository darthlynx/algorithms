package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-the-number-of-good-subarrays/
public class CountTheNumberOfGoodSubarrays {

    // Time complexity: O(n)
    // Space complexity: O(n)
    class Solution {
        public long countGood(int[] nums, int k) {
            Map<Integer, Integer> freq = new HashMap<>();

            long good = 0;
            long pairCount = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                // add
                int oldFreq = freq.getOrDefault(nums[right], 0);
                freq.put(nums[right], oldFreq + 1);
                pairCount += oldFreq;

                // while good
                while (pairCount >= k && left < right) {
                    // imagine we have fixed good subarray nums[left,right].
                    // every subarray that starts at current left and ends at index >= right will be also good
                    // if nums[left, right] has at least k pairs, then
                    // nums[left, right+1]
                    // ...
                    // nums[left, nums.length-1] will have them too
                    // Therefore, we will have nums.length - right good subarrays
                    good += (nums.length - right);

                    // remove
                    freq.put(nums[left], freq.get(nums[left]) - 1);
                    pairCount -= freq.get(nums[left]);
                    if (freq.get(nums[left]) == 0) {
                        freq.remove(nums[left]);
                    }
                    left++;
                }
            }

            return good;
        }
    }
}
