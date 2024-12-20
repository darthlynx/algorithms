package com.darthlynx.algorithms.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/
public class ReverseOddLevelsOfBinaryTree {

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
    // Space complexity: O(n)
    class Solution {
        public TreeNode reverseOddLevels(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            int level = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                Stack<Integer> stack = new Stack<>();
                Queue<TreeNode> levelNodes = new LinkedList<>();

                for (int i = 0; i < size; i++) {
                    TreeNode current = q.poll();
                    if (level % 2 != 0) { // odd level
                        stack.add(current.val);
                        levelNodes.add(current);
                    }
                    if (current.left != null) {
                        q.offer(current.left);
                    }
                    if (current.right != null) {
                        q.offer(current.right);
                    }
                }
                // swapping odd level nodes values
                while (!stack.isEmpty()) {
                    levelNodes.poll().val = stack.pop();
                }
                level++;
            }

            return root;
        }
    }

}
