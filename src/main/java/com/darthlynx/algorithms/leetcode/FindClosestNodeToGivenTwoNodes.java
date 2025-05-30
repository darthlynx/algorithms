package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
public class FindClosestNodeToGivenTwoNodes {

    // Time complexity: O(n+n) ~ O(n)
    // Space complexity: O(n)
    // where n == number of edges == number of nodes
    class Solution {
        public int closestMeetingNode(int[] edges, int node1, int node2) {
            int n = edges.length;
            int[] dist1 = new int[n];
            int[] dist2 = new int[n];
            Arrays.fill(dist1, Integer.MAX_VALUE);
            Arrays.fill(dist2, Integer.MAX_VALUE);

            bfs(node1, edges, dist1);
            bfs(node2, edges, dist2);

            int minDistNode = -1;
            int minDistance = Integer.MAX_VALUE;

            for (int currNode = 0; currNode < n; currNode++) {
                if (minDistance > Math.max(dist1[currNode], dist2[currNode])) {
                    minDistNode = currNode;
                    minDistance = Math.max(dist1[currNode], dist2[currNode]);
                }
            }

            return minDistNode;
        }

        public void bfs(int startNode, int[] edges, int[] dist) {
            int n = edges.length;
            Queue<Integer> q = new LinkedList<>();
            q.offer(startNode);

            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);
            dist[startNode] = 0;

            while (!q.isEmpty()) {
                int node = q.poll();
                if (visited[node]) {
                    continue;
                }
                visited[node] = true;
                int neighbor = edges[node];
                if (neighbor != -1 && !visited[neighbor]) {
                    dist[neighbor] = 1 + dist[node];
                    q.offer(neighbor);
                }
            }
        }
    }
}
