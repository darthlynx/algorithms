package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/maximum-number-of-k-divisible-components/
public class MaximumNumberOfKDivisibleComponents {

    // Time complexity: O(v + e)
    // Space complexity: O(v + e)
    class Solution {

        private int components = 0;
    
        public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
            Set<Integer> visited = new HashSet<>();
    
            if (n == 1) {
                return n;
            }
            
            // key is node number, value - edges (node numbers)
            Map<Integer, List<Integer>> tree = new HashMap<>();
    
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                addEdge(tree, edge[0], edge[1]);
                addEdge(tree, edge[1], edge[0]);
            }
    
            long val = calculateValue(0, visited, tree, values, k);
            if (val % k == 0) {
                components++;
            }
    
            return components;
        }
    
        private long calculateValue(int node, Set<Integer> visited, Map<Integer, List<Integer>> tree, int[] values, int k) {
            if (visited.contains(node)) {
                return -1;
            }
            visited.add(node);
            long totalValue = (long) values[node]; // adding value of the current node
            for (int edge : tree.getOrDefault(node, new ArrayList<>())) {
                long edgeValue = calculateValue(edge, visited, tree, values, k);
                if (edgeValue >= 0) {
                    if (edgeValue % k == 0) {
                        components++;
                    } else{
                        totalValue += edgeValue;
                    }
                }
            }
    
            return totalValue;
        }
    
        private void addEdge(Map<Integer, List<Integer>> tree, int edge1, int edge2) {
            tree.computeIfAbsent(edge1, k -> new ArrayList<>()).add(edge2);
        }
    }
}
