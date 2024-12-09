package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/two-best-non-overlapping-events/
public class TwoBestNonOverlappingEvents {

    // Top-down DP
    // Time complexity: O(n * logn)
    // Space complexity: O(n*3) => O(n)
    class Solution {
        public int maxTwoEvents(int[][] events) {
            int n = events.length;

            // 3, because count could be 0, 1 or 2 (we need to choose at most 2
            // non-overlapping events)
            int[][] dp = new int[n][3];
            for (int i = 0; i < n; i++) {
                dp[i] = new int[] { -1, -1, -1 };
            }

            // sort events by start times
            Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

            return findEvents(events, 0, 0, dp);
        }

        private int findEvents(int[][] events, int idx, int count, int[][] dp) {
            if (count == 2 || idx >= events.length) {
                return 0;
            }

            if (dp[idx][count] == -1) {
                int end = events[idx][1];
                int nextEventIdx = findNextEvent(events, idx, end);

                int includedValue = nextEventIdx < events.length && events[nextEventIdx][0] > end
                        ? findEvents(events, nextEventIdx, count + 1, dp)
                        : 0;
                int include = events[idx][2] + includedValue;

                int exclude = findEvents(events, idx + 1, count, dp);
                dp[idx][count] = Math.max(include, exclude);
            }
            return dp[idx][count];
        }

        private int findNextEvent(int[][] events, int idx, int end) {
            int bad = idx;
            int good = events.length;
            while (good - bad > 1) {
                int mid = bad + (good - bad) / 2;
                if (events[mid][0] > end) {
                    good = mid;
                } else {
                    bad = mid;
                }
            }
            return good;
        }
    }

    // PriorityQueue to sort events
    // Time complexity: O(n * logn)
    // Space complexity: O(n)
    class Solution2 {
        public int maxTwoEvents(int[][] events) {
            // stores pair of end time and value
            // sorted by end time
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

            // sort events by start time
            Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

            int maxValue = 0;
            int maxSum = 0;

            for (int[] event : events) {
                // poll all elements from pq that end before the current event start
                // because they guaranteed to not overlap
                while (!pq.isEmpty() && pq.peek()[0] < event[0]) {
                    maxValue = Math.max(maxValue, pq.peek()[1]);
                    pq.poll();
                }
                // check the maxSum we can form from the current event value
                // and the maxValue of the event happened before
                maxSum = Math.max(maxSum, maxValue + event[2]);
                pq.add(new int[] { event[1], event[2] });
            }

            return maxSum;
        }
    }

    // Greedy
    // Time complexity: O(n * logn)
    // Space complexity: O(n)
    class Solution3 {

        public static final int START = 1;
        public static final int END = 0;

        public int maxTwoEvents(int[][] events) {
            List<int[]> times = new ArrayList<>();

            // Combine all events into single array with different types of events
            for (int[] event : events) {
                times.add(new int[] { event[0], START, event[2] });
                times.add(new int[] { event[1] + 1, END, event[2] });
            }

            // sort by times: first by time, then by type
            times.sort((a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });

            int result = 0;
            int maxValue = 0;

            for (int[] timeValue : times) {
                if (timeValue[1] == START) {
                    // calculate max sum
                    result = Math.max(result, timeValue[2] + maxValue);
                } else {
                    // update the maximum value seen so far
                    maxValue = Math.max(maxValue, timeValue[2]);
                }
            }

            return result;
        }
    }

}
