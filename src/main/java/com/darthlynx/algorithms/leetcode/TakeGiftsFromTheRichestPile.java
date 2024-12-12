package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/take-gifts-from-the-richest-pile/
public class TakeGiftsFromTheRichestPile {

    // Time complexity: O(k*logN + N*logN) => O(logN*(k+N))
    // Space complexity: O(N)
    class Solution {
        public long pickGifts(int[] gifts, int k) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            for (int gift : gifts) {
                maxHeap.offer(gift);
            }

            for (int i = 0; i < k; i++) {
                int giftPile = maxHeap.poll();
                int updated = sqrt(giftPile);
                maxHeap.offer(updated);
            }

            long totalLeft = 0;
            while (!maxHeap.isEmpty()) {
                totalLeft += maxHeap.poll();
            }

            return totalLeft;
        }

        public int sqrt(int x) {
            int good = 1;
            int bad = x;

            while (bad - good > 1) {
                int mid = good + (bad - good) / 2;

                if ((long) mid * mid <= (long) x) {
                    good = mid;
                } else {
                    bad = mid;
                }
            }
            return good;
        }
    }

}
