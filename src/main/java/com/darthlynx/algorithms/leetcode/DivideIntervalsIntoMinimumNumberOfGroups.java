package com.darthlynx.algorithms.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/
public class DivideIntervalsIntoMinimumNumberOfGroups {

    // the main idea is to find the max number of overlapping intervals
    // if they are overlapping, it means that they have to be in different groups
    class Solution {
        public int minGroups(int[][] intervals) {
            List<int[]> events = new ArrayList<>();
    
            for (int[] interval : intervals) {
                events.add(new int[]{interval[0], 1}); // start
                events.add(new int[]{interval[1] + 1, -1}); // finish (+1 required as intervals are inclusive)
            }
    
            // sort events in ascending order
            Collections.sort(events, (e1, e2) -> {
                if (e1[0] == e2[0]) { // sort by event type in case values are the same
                    return Integer.compare(e1[1], e2[1]);
                }
                return Integer.compare(e1[0], e2[0]); // otherwise, sort by value
            });
    
            int concurrentIntervals = 0;
            int maxConcurrentIntervals = 0;
    
            for (int[] event : events) {
                concurrentIntervals += event[1];
                maxConcurrentIntervals = Math.max(maxConcurrentIntervals, concurrentIntervals);
            }
    
            return maxConcurrentIntervals;
    
        }
    }

}
