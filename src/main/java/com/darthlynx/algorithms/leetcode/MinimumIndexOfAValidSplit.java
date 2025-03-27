package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/minimum-index-of-a-valid-split/
public class MinimumIndexOfAValidSplit {

    // Time complexity: O(N)
    // Space complexity: O(N)
    class Solution1 {
        public int minimumIndex(List<Integer> nums) {
            // get the frequencies of the numbers
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            // find the dominant number
            int dominant = 0;
            int dTotal = 0;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() > nums.size() / 2) {
                    dominant = entry.getKey();
                    dTotal = entry.getValue();
                    break;
                }
            }

            int dFreq = 0;
            int other = 0;
            int res = -1;
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) == dominant) {
                    dFreq++;
                } else {
                    other++;
                }
                if (dFreq > other) {
                    res = i;
                    break;
                }
            }

            // verify if dominant number is stil dominant in the remaining part of the array
            if ((nums.size() - (res + 1)) / 2 >= dTotal - dFreq) {
                return -1;
            }

            return res;
        }
    }

    // Time complexity: O(N)
    // Space complexity: O(1)
    class Solution2 {
        public int minimumIndex(List<Integer> nums) {
            int dominant = getDominant(nums);
            int dTotal = 0;
            for (int num : nums) {
                if (num == dominant) {
                    dTotal++;
                }
            }
    
            int dFreq = 0;
            int other = 0;
            int res = -1;
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) == dominant) {
                    dFreq++;
                } else {
                    other++;
                }
                if (dFreq > other) {
                    res = i;
                    break;
                }
            }
    
            if ((nums.size() - (res + 1)) / 2 >= dTotal - dFreq) {
                return -1;
            }
    
            return res;
        }
    
        private int getDominant(List<Integer> nums) {
            int dominant = 0;
            int count = 0;
    
            for (int num : nums) {
                if (count == 0) {
                    dominant = num;
                }
    
                if (num == dominant) {
                    count++;
                } else {
                    count--;
                }
            }
            return dominant;
        }
    }
}
