package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/count-the-number-of-complete-components/
public class CountTheNumberOfCompleteComponents {

    // Time complexity: O(N + M * logN)
    // Space complexity: O(N + M + logN)
    // where N = number of nodes, M number of edges
    // logN in space complexity is for sorting
    class Solution {
        public int countCompleteComponents(int n, int[][] edges) {
            Map<Integer, List<Integer>> graph = new HashMap<>();

            // add itself to the list of the nodes
            for (int i = 0; i < n; i++) {
                graph.computeIfAbsent(i, x -> new ArrayList<>()).add(i);
            }

            for (int[] edge : edges) {
                int node1 = edge[0];
                int node2 = edge[1];
                graph.get(node1).add(node2);
                graph.get(node2).add(node1);
            }

            Map<List<Integer>, Integer> componentFreq = new HashMap<>();
            for (int i = 0; i < n; i++) {
                List<Integer> neighbours = graph.get(i);
                Collections.sort(neighbours);
                componentFreq.put(neighbours, componentFreq.getOrDefault(neighbours, 0) + 1);
            }

            int result = 0;
            // in each complete component with K vertices,
            // each vertice should have exactly K neighbours
            // and exactly K vertices must share this pattern
            for (Map.Entry<List<Integer>, Integer> entry : componentFreq.entrySet()) {
                if (entry.getKey().size() == entry.getValue()) {
                    result++;
                }
            }

            return result;
        }
    }
}
