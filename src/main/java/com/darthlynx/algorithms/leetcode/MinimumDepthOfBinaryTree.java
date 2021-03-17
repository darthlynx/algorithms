package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;

import static org.junit.Assert.assertEquals;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinimumDepthOfBinaryTree {

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

    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return depth;
    }

    @Test
    public void testMinDepth() {
        TreeNode rRight = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, null, rRight);

        assertEquals(3, new MinimumDepthOfBinaryTree().minDepth(root));
    }

    @Test
    public void testMinDepth2() {
         // [1,2,3,4,5]
        TreeNode rLeft = new TreeNode(2);
        TreeNode rRight = new TreeNode(3, new TreeNode(4), new TreeNode(5));
        TreeNode root = new TreeNode(1, rLeft, rRight);

        assertEquals(2, new MinimumDepthOfBinaryTree().minDepth(root));
    }
}
