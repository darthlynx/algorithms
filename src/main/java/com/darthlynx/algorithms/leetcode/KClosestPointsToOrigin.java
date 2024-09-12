package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/k-closest-points-to-origin/description/
public class KClosestPointsToOrigin {
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
    
            PriorityQueue<int[]> heap = new PriorityQueue<>(this::compare);
    
            for (int i = 0; i < points.length; i++) {
                heap.add(points[i]);
            }
    
            int[][] result = new int[k][];
            for (int i = 0; i < k; i++) {
                result[i] = heap.poll();
            }
    
            return result;
        }
    
        private int compare(int[] first, int[] second) {
            double d1 = getDistance(first[0], first[1]);
            double d2 = getDistance(second[0], second[1]);
    
            return Double.compare(d1, d2);
        }
    
        private double getDistance(int x, int y) {
            return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        }
    }

}
