package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/take-gifts-from-the-richest-pile/
public class TakeGiftsFromTheRichestPile {

    // Time complexity: O(k*logN + N*logN) => O(logN*(k+N))
    // Space complexity: O(N)
    class Solution {
        public long pickGifts(int[] gifts, int k) {
            PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));

            for (int gift : gifts) {
                maxHeap.offer((long) gift);
            }

            for (int i = 0; i < k; i++) {
                long giftPile = maxHeap.poll();
                long updated = sqrt(giftPile);
                maxHeap.offer(updated);
            }

            long totalLeft = 0;
            while (!maxHeap.isEmpty()) {
                totalLeft += maxHeap.poll();
            }

            return totalLeft;
        }

        public long sqrt(long x) {
            long good = 1L;
            long bad = x;

            while (bad - good > 1) {
                long mid = good + (bad - good) / 2;

                if (mid * mid <= x) {
                    good = mid;
                } else {
                    bad = mid;
                }
            }
            return good;
        }
    }

}
