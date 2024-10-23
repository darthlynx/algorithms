package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/cousins-in-binary-tree-ii/
public class CousinsInBinaryTreeTwo {

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
        public TreeNode replaceValueInTree(TreeNode root) {
        
            Map<Integer, Integer> levelSums = new HashMap<>();
            Map<TreeNode, Integer> siblings = new HashMap<>();
    
            // calculate the sum of nodes values on each level
            calculateLevelSums(root, levelSums, siblings);
    
            // build a new tree by calculating new values for each node
            // node's value should be (levelSum - node's value - sibling's value)
            buildCousinsTree(root, levelSums, siblings);
    
            return root;
        }
    
        private void calculateLevelSums(TreeNode root, Map<Integer, Integer> levelSums, Map<TreeNode, Integer> siblings) {
    
            int level = 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
    
            while (!q.isEmpty()) {
                int size = q.size();
                int levelSum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (node != null) {
                        levelSum += node.val;
                        if (node.left != null) {
                            if (node.right != null) {
                                siblings.put(node.left, node.right.val);
                            }
                            q.add(node.left);
                        }
                        if (node.right != null) {
                            if (node.left != null) {
                                siblings.put(node.right, node.left.val);
                            }
                            q.add(node.right);
                        }
                    }
                }
                levelSums.put(level, levelSum);
                level++;
            }
        }
    
        private void buildCousinsTree(TreeNode root, Map<Integer, Integer> levelSums, Map<TreeNode, Integer> siblings) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
    
            int level = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    int siblingVal = siblings.getOrDefault(node, 0);
                    int value = levelSums.get(level) - node.val - siblingVal;
                    node.val = value;
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
                level++;
            }
        }
    }

}
