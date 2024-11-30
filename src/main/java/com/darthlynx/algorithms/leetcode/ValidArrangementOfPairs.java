package com.darthlynx.algorithms.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/valid-arrangement-of-pairs/
public class ValidArrangementOfPairs {

    // Time complexity: O(v+e)
    // Space complexity: O(v+e)
    class Solution {

        public int[][] validArrangement(int[][] pairs) {
            
            Map<Integer, Deque<Integer>> adjacencyMatrix = new HashMap<>();
            Map<Integer, Integer> inDegree = new HashMap<>();
            Map<Integer, Integer> outDegree = new HashMap<>();

            List<Integer> result = new ArrayList<>();

            for (int[] pair : pairs) {
                int start = pair[0];
                int end = pair[1];
                adjacencyMatrix.computeIfAbsent(start, k -> new ArrayDeque<>()).add(end);
                
                outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
                inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
            }

            // find the start node (outDegree == inDegree + 1)
            int startNode = -1;
            for (int node : outDegree.keySet()) {
                if (outDegree.get(node) == inDegree.getOrDefault(node, 0) + 1) {
                    startNode = node;
                    break;
                }
            }

            // if no such node (inDegree for all nodes == outDegree, which means that Eulerian path is closed)
            // we can choose any node from the list as a starting point (first in this case)
            if (startNode < 0) {
                startNode = pairs[0][0];
            }

            dfs(startNode, adjacencyMatrix, result);

            // Reverse the result since DFS gives us the path in reverted order
            Collections.reverse(result);

            return constructPairedResult(result);
        }
    }

    private void dfs(int node, Map<Integer, Deque<Integer>> adjacencyMatrix, List<Integer> result) {
        Deque<Integer> neighbours = adjacencyMatrix.get(node);

        while (neighbours != null && !neighbours.isEmpty()) {
            int nextNode = neighbours.pollFirst();
            dfs(nextNode, adjacencyMatrix, result);
        }
        // add to result as a postorder
        // In postorder we first expore all the neighbours of the node,
        // and only append the node to the path after all its edges have been processed
        result.add(node);
    }

    private int[][] constructPairedResult(List<Integer> result) {
        int[][] pairedResult = new int[result.size() - 1][2];

        // if result is [1, 2, 3, 4]
        // paired result will look like this:
        // [[1, 2], [2, 3], [3, 4]]
        for (int i = 1; i < result.size(); i++) {
            pairedResult[i-1] = new int[]{result.get(i-1), result.get(i)};
        }

        return pairedResult;
    }
}
