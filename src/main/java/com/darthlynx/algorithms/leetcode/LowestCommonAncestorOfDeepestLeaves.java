package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
public class LowestCommonAncestorOfDeepestLeaves {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    // Time complexity: O(n)
    // Space complexity: O(1)
    class Solution {

        class Node {
            TreeNode node;
            int depth;

            Node(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            return dfs(root).node;
        }

        private Node dfs(TreeNode root) {
            if (root == null) {
                return new Node(null, 0);
            }

            Node left = dfs(root.left);
            Node right = dfs(root.right);

            if (left.depth > right.depth) {
                return new Node(left.node, left.depth + 1);
            }
            if (left.depth < right.depth) {
                return new Node(right.node, right.depth + 1);
            }
            return new Node(root, left.depth + 1);
        }
    }
}
