package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    @Test
    public void testMaxDepth() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2));

        assertEquals(2, new MaximumDepthOfBinaryTree().maxDepth(root));
    }
}
