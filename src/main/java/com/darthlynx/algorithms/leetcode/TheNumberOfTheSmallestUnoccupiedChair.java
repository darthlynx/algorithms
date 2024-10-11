package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/
public class TheNumberOfTheSmallestUnoccupiedChair {

    class Solution {

        public int smallestChair(int[][] times, int targetFriend) {
            int n = times.length;
    
            List<int[]> events = new ArrayList<>();
    
            for (int i = 0; i < n; i++) {
                events.add(new int[]{times[i][0], i, 1}); // 1 means friend arrives
                events.add(new int[]{times[i][1], i, -1}); // -1 means friend leaves
            }
    
            Collections.sort(events, this::compare);
    
            PriorityQueue<Integer> chairs = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                chairs.offer(i);
            }
    
            PriorityQueue<int[]> usedChairs = new PriorityQueue<>(this::compare);
    
            for (int[] event : events) {
                int time = event[0];
                int index = event[1];
                int eventType = event[2];
                
                // remove chairs which are not in use
                while (!usedChairs.isEmpty() && usedChairs.peek()[0] <= time) {
                    chairs.add(usedChairs.poll()[1]);
                }
    
                if (eventType > 0) { // friend arrives
                    int chair = chairs.poll();
                    if (index == targetFriend) {
                        return chair;
                    }
                    usedChairs.add(new int[]{times[index][1], chair});
                }
            }
    
            return -1;
        }
    
        private int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    }

}
