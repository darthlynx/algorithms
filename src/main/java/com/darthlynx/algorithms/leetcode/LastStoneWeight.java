package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;
import java.util.Comparator;

// https://leetcode.com/problems/last-stone-weight/
public class LastStoneWeight {

    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

            for (int stone : stones) {
                maxHeap.offer(stone);
            }

            while (maxHeap.size() > 1) {
                int first = maxHeap.poll();
                int second = maxHeap.poll();
                if (first > second) {
                    maxHeap.offer(first - second);
                }
            }

            return maxHeap.size() > 0 ? maxHeap.peek() : 0;
        }
    }

}
