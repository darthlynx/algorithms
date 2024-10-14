package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/maximal-score-after-applying-k-operations/
public class MaximalScoreAfterApplyingKOperations {

    class Solution {
        public long maxKelements(int[] nums, int k) {
            // max heap
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            
            for (int num : nums) {
                pq.offer(num);
            }
    
            long score = 0;
    
            for (int i = 0; i < k; i++) {
                int localMax = pq.poll();
                score += localMax;
                localMax = ceil(localMax);
                pq.offer(localMax);
            }
    
            return score;
        }
    
        private int ceil(int val) {
            if (val % 3 == 0) {
                return val / 3;
            } else {
                return val / 3 + 1;
            }
        }
    }

}
