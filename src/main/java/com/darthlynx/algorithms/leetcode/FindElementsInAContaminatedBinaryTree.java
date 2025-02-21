package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
public class FindElementsInAContaminatedBinaryTree {

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
    class FindElements {

        private TreeNode root;
        private Set<Integer> nodes;

        // Time complexity: O(n)
        // Space complexity: O(n)
        public FindElements(TreeNode root) {
            this.root = root;
            this.root.val = 0;
            nodes = new HashSet<>();
            recover(this.root);
        }

        private void recover(TreeNode node) {
            if (node == null) {
                return;
            }
            nodes.add(node.val);
            if (node.left != null) {
                node.left.val = 2 * node.val + 1;
            }
            if (node.right != null) {
                node.right.val = 2 * node.val + 2;
            }
            recover(node.left);
            recover(node.right);
        }

        // Time complexity: O(1)
        public boolean find(int target) {
            return nodes.contains(target);
        }
    }

    /**
     * Your FindElements object will be instantiated and called as such:
     * FindElements obj = new FindElements(root);
     * boolean param_1 = obj.find(target);
     */
}
