package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/
public class ShortestDistanceAfterRoadAdditionQueries {

    // Time complexity: O(q * (n + q))
    // Space complexity: O(n + q)
    class Solution {
        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
            List<List<Integer>> graph = new ArrayList<>(n);

            int[] answer = new int[queries.length];

            for (int i = 0; i < n - 1; i++) {
                List<Integer> dependency = new ArrayList<>();
                dependency.add(i+1);
                graph.add(dependency);
            }
            graph.add(new ArrayList<>()); // add entry for the last node

            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                graph.get(query[0]).add(query[1]);
                int length = bfs(graph, n);
                answer[i] = length;
            }

            return answer;
        }

        static class Pair {
            int node;
            int distance;

            Pair(int node, int distance) {
                this.node = node;
                this.distance = distance;
            }
        }

        private int bfs(List<List<Integer>> graph, int n) {
            Set<Integer> visited = new HashSet<>();
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(0, 0));
            int path = -1;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Pair p = q.poll();
                    if (visited.contains(p.node)) {
                        continue;
                    }
                    if (p.node == n - 1) {
                        return p.distance;
                    }
                    visited.add(p.node);
                    for (int child : graph.get(p.node)) {
                        q.offer(new Pair(child, p.distance + 1));
                    }
                }
            }

            return path;
        }
    }
}
