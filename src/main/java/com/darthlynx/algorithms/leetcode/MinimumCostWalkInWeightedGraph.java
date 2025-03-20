package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/
public class MinimumCostWalkInWeightedGraph {

    // Time complexity: O(n + m + q)
    // Space complexity: O(n)
    // where n - number of nodes, m - number of edges, q - number of queries
    class Solution {

        class DisjointSet {
            private int[] parent;
            private int[] rank;

            DisjointSet(int size) {
                parent = new int[size];
                rank = new int[size];

                for (int i = 0; i < size; i++) {
                    parent[i] = i; // initially, each node is its own parent
                    rank[i] = 0;
                }
            }

            int find(int v) {
                if (parent[v] != v) {
                    parent[v] = find(parent[v]);
                }
                return parent[v];
            }

            void union(int u, int v) {
                int rootU = find(u);
                int rootV = find(v);
                if (rootU != rootV) {
                    if (rank[rootU] > rank[rootV]) {
                        parent[rootV] = rootU;
                    } else if (rank[rootU] < rank[rootV]) {
                        parent[rootU] = rootV;
                    } else {
                        parent[rootV] = rootU;
                        rank[rootU]++;
                    }
                }
            }
        }

        public int[] minimumCost(int n, int[][] edges, int[][] query) {
            DisjointSet ds = new DisjointSet(n);

            int[] componentCost = new int[n];
            // all values are initially set to the number with only 1s in its binary
            // representation
            Arrays.fill(componentCost, Integer.MAX_VALUE);

            // combine edges into components
            for (int[] edge : edges) {
                ds.union(edge[0], edge[1]);
            }

            // calculate the cost of each component by performing bitwise AND of all edge
            // weights on it
            for (int[] edge : edges) {
                int root = ds.find(edge[0]);
                componentCost[root] &= edge[2];
            }

            int[] res = new int[query.length];
            for (int i = 0; i < query.length; i++) {
                int start = query[i][0];
                int end = query[i][1];

                // if start and end are in different components
                if (ds.find(start) != ds.find(end)) {
                    res[i] = -1;
                } else {
                    int root = ds.find(start);
                    res[i] = componentCost[root];
                }
            }

            return res;
        }
    }
}
