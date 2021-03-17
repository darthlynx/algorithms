package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();

        if (root == null) {
            return resultList;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<Integer> levelList;
        TreeNode currentNode;
        while (!queue.isEmpty()) {
            levelList = new ArrayList<>();
            int size = queue.size();            // we can't define queue size dynamically inside loop definition,
            for (int i = 0; i < size; i++) {    // because we continue add new objects into queue
                currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                levelList.add(currentNode.val);
            }
            resultList.add(levelList);
        }
        return resultList;
    }


    @Test
    public void testLevelOrder() {
        // Input [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        TreeNode rLeft = new TreeNode(9);
        TreeNode rRight = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        root.left = rLeft;
        root.right = rRight;

        // Expected [[3],[9,20],[15,7]]
        List<List<Integer>> expectedResult = Arrays.asList(Arrays.asList(3), Arrays.asList(9,20), Arrays.asList(15,7));
        List<List<Integer>> actualResult = new BinaryTreeLevelOrderTraversal().levelOrder(root);

        System.out.println(expectedResult);
        System.out.println(actualResult);
        assertEquals(expectedResult, actualResult);
    }
}
