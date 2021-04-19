package com.darthlynx.algorithms.leetcode;

import java.util.ArrayDeque;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinimumDepthOfBinaryTree {

     public static class TreeNode {
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


}
