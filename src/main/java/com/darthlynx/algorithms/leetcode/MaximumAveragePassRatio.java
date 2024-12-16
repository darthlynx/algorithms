package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/maximum-average-pass-ratio/
public class MaximumAveragePassRatio {

    // Time complexity: O(N * logN)
    // Space complexity: O(N), where N - num of classes
    class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
                return Double.compare(getRatio(b[0], b[1]), getRatio(a[0], a[1]));
            });

            for (int[] clazz : classes) {
                maxHeap.offer(clazz);
            }

            for (int i = 0; i < extraStudents; i++) {
                int[] clazz = maxHeap.poll();
                clazz[0]++;
                clazz[1]++;
                maxHeap.offer(clazz);
            }

            double passRatio = 0;
            while (!maxHeap.isEmpty()) {
                int[] c = maxHeap.poll();
                passRatio += (double) c[0] / c[1];
            }

            return passRatio / classes.length;
        }

        // we need to maximize potential ratio, so need to check
        // which ratio will have biggest grows after adding one more student
        private double getRatio(int pass, int total) {
            return (double) (pass + 1) / (total + 1) - (double) pass / total;
        }
    }

    // Time complexity: O(N * logN)
    // Space complexity: O(N), where N - num of classes
    // This version has better performance due to less int-to-double conversions
    class Solution2 {
        static class Clazz {
            double ratioImprovement;
            int pass;
            int total;

            Clazz(double ratioImprovement, int pass, int total) {
                this.ratioImprovement = ratioImprovement;
                this.pass = pass;
                this.total = total;
            }
        }

        public double maxAverageRatio(int[][] classes, int extraStudents) {
            PriorityQueue<Clazz> maxHeap = new PriorityQueue<>((a, b) -> {
                return Double.compare(b.ratioImprovement, a.ratioImprovement);
            });

            for (int[] c : classes) {
                maxHeap.offer(new Clazz(getRatioImprovement(c[0], c[1]), c[0], c[1]));
            }

            for (int i = 0; i < extraStudents; i++) {
                Clazz c = maxHeap.poll();
                maxHeap.offer(new Clazz(getRatioImprovement(c.pass + 1, c.total + 1), c.pass + 1,
                        c.total + 1));
            }

            double passRatio = 0;
            while (!maxHeap.isEmpty()) {
                Clazz c = maxHeap.poll();
                passRatio += (double) c.pass / c.total;
            }

            return passRatio / classes.length;
        }

        // we need to maximize potential ratio, so need to check
        // which ratio will have biggest grows after adding one more student
        private double getRatioImprovement(int pass, int total) {
            return (double) (pass + 1) / (total + 1) - (double) pass / total;
        }
    }
}
