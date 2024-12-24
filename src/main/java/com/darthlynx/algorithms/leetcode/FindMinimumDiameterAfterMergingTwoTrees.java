package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/
public class FindMinimumDiameterAfterMergingTwoTrees {

    // Time complexity: O(n + m)
    // Space complexity: O(n + m)
    // where n - number of nodes in tree1, m - num of nodes in tree2
    class Solution {
        public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
            Map<Integer, List<Integer>> tree1 = new HashMap<>();
            buildGraph(tree1, edges1);

            Map<Integer, List<Integer>> tree2 = new HashMap<>();
            buildGraph(tree2, edges2);

            int diameter1 = calculateDiameter(tree1);
            int diameter2 = calculateDiameter(tree2);
            // System.out.printf("diameter1: %d; diameter2: %d", diameter1, diameter2);

            return getDiameterAfterMerge(diameter1, diameter2);
        }

        // minimum possible diameter will be
        // a half of the diameter of first and second tree
        // +1 edge to connect them;
        // result diameter should not be less than one of the original diameters
        private int getDiameterAfterMerge(int diameter1, int diameter2) {
            int max = Math.max(diameter1, diameter2);
            return Math.max(getRadius(diameter1) + getRadius(diameter2) + 1, max);
        }

        private int getRadius(int diameter) {
            return diameter % 2 == 0 ? diameter / 2 : diameter / 2 + 1;
        }

        private void buildGraph(Map<Integer, List<Integer>> graph, int[][] edges) {
            for (int i = 0; i < edges.length; i++) {
                int v = edges[i][0];
                int u = edges[i][1];
                graph.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
                graph.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            }
        }

        private int maxDistance = -1;
        private int farthestNode = -1;

        private int calculateDiameter(Map<Integer, List<Integer>> graph) {
            maxDistance = -1;
            farthestNode = -1;
            Set<Integer> visited = new HashSet<>();
            // starting from random node
            dfs(0, visited, 0, graph);

            maxDistance = 0;
            visited = new HashSet<>();
            // starting from the farthest node
            dfs(farthestNode, visited, 0, graph);

            return maxDistance;
        }

        private void dfs(int node, Set<Integer> visited, int distance, Map<Integer, List<Integer>> graph) {
            if (visited.contains(node)) {
                return;
            }
            visited.add(node);

            if (distance > maxDistance) {
                maxDistance = distance;
                farthestNode = node;
            }

            for (int neighbour : graph.getOrDefault(node, new ArrayList<>())) {
                dfs(neighbour, visited, distance + 1, graph);
            }
        }
    }
}
