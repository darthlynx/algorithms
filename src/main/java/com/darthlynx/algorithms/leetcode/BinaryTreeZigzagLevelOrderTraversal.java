package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        boolean right = true;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<Integer> nodes;
        while (!queue.isEmpty()) {
            nodes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (right) {
                    nodes.add(current.val);
                } else {
                    nodes.add(0, current.val);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            resultList.add(nodes);
            right = !right;
        }

        return resultList;
    }

    @Test
    public void testZigzagLevelOrder() {
        // root = [3,9,20,null,null,15,7]
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, new TreeNode(9), right);

        // [[3],[20,9],[15,7]]
        List<List<Integer>> expectedResult = Arrays.asList(Arrays.asList(3), Arrays.asList(20,9), Arrays.asList(15,7));

        assertEquals(expectedResult, new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
    }

    @Test
    public void testOneNodeZigzagLevelOrder() {
        // root = [1]
        TreeNode root = new TreeNode(1);

        // [[1]]
        List<List<Integer>> expectedResult = Arrays.asList(Arrays.asList(1));

        assertEquals(expectedResult, new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
    }

}
