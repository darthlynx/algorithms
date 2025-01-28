package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule-iv/
public class CourseScheduleIV {

    // Time complexity: O(n^3 + q)
    // Space complexity: O(n^2 + n) ~> O(n^2)
    // where n = numCourses, q = queries.length;
    class Solution {
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < prerequisites.length; i++) {
                graph.computeIfAbsent(prerequisites[i][0], x -> new ArrayList<>()).add(prerequisites[i][1]);
            }

            boolean[][] isReachable = new boolean[numCourses][numCourses];
            // precompute which node is reachable from each node
            for (int i = 0; i < numCourses; i++) {
                bfs(i, graph, isReachable);
            }

            List<Boolean> result = new ArrayList<>();
            for (int[] query : queries) {
                result.add(isReachable[query[0]][query[1]]);
            }
            return result;
        }

        private void bfs(int node, Map<Integer, List<Integer>> graph, boolean[][] isReachable) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(node);

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int current = q.poll();

                    List<Integer> prereqs = graph.getOrDefault(current, new ArrayList<>());
                    for (int nei : prereqs) {
                        if (!isReachable[node][nei]) {
                            isReachable[node][nei] = true;
                            q.offer(nei);
                        }
                    }
                }
            }
        }
    }

}
