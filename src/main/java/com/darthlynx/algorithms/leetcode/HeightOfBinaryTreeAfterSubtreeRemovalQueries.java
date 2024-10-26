package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/
public class HeightOfBinaryTreeAfterSubtreeRemovalQueries {

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
        public int[] treeQueries(TreeNode root, int[] queries) {
            Map<Integer, Integer> subtreeHeights = new HashMap<>();    
            Map<Integer, Integer> resHeights = new HashMap<>();

            dfs(root, 0, 0, subtreeHeights, resHeights);
    
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                res[i] = resHeights.get(queries[i]);
            }
    
            return res;
        }
    
        private void dfs(TreeNode root, int currHeight, int maxHeight,
                Map<Integer, Integer> subtreeHeights,
                Map<Integer, Integer> resHeights) {

            if (root == null) {
                return;
            }
            
            resHeights.put(root.val, maxHeight);
            
            // maxHeight should be calculated as a max between current max depth
            // and node's depth + 1 (to include itself) + the height of the opposite node

            dfs(root.left, currHeight + 1,
                    Math.max(maxHeight, currHeight + 1 + computeHeight(root.right, subtreeHeights)),
                    subtreeHeights, resHeights);
    
            dfs(root.right, currHeight + 1,
                    Math.max(maxHeight, currHeight + 1 + computeHeight(root.left, subtreeHeights)),
                    subtreeHeights, resHeights);
        }
    
        // compute height for the subtree
        private int computeHeight(TreeNode node, Map<Integer, Integer> subtreeHeights) {
            if (node == null) {
                return -1; // to not include this node as we add +1 when calculate max
            }
    
            if (subtreeHeights.containsKey(node.val)) {
                return subtreeHeights.get(node.val);
            }
    
            int left = computeHeight(node.left, subtreeHeights);
            int right = computeHeight(node.right, subtreeHeights);
    
            int max = 1 + Math.max(left, right);
            subtreeHeights.put(node.val, max);
    
            return max;
        }
    }
}
