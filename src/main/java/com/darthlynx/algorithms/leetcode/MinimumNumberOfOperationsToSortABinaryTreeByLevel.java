package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/
public class MinimumNumberOfOperationsToSortABinaryTreeByLevel {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        // Time complexity: O(N * logN)
        // Space complexity: O(N), where N - number of nodes in a tree
        public int minimumOperations(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            int ops = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                int[] levelNodes = new int[size];
                for (int i = 0; i < size; i++) {
                    TreeNode current = q.poll();
                    levelNodes[i] = current.val;

                    if (current.left != null) {
                        q.offer(current.left);
                    }
                    if (current.right != null) {
                        q.offer(current.right);
                    }
                }

                ops += calculateSwaps(levelNodes);
            }

            return ops;
        }

        private int calculateSwaps(int[] levelNodes) {
            // to represent the sorted state of the nodes
            int[] target = levelNodes.clone();
            Arrays.sort(target);

            int swaps = 0;
            // key - node value; value - location
            Map<Integer, Integer> location = new HashMap<>();
            for (int i = 0; i < levelNodes.length; i++) {
                location.put(levelNodes[i], i);
            }

            for (int i = 0; i < levelNodes.length; i++) {
                if (levelNodes[i] != target[i]) {
                    swaps++;

                    // update nodes location
                    int currentLocation = location.get(target[i]);
                    location.put(levelNodes[i], currentLocation);
                    levelNodes[currentLocation] = levelNodes[i];
                }
            }

            return swaps;
        }
    }
}
