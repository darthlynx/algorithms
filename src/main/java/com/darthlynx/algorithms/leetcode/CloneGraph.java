package com.darthlynx.algorithms.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

// https://leetcode.com/problems/clone-graph/submissions/
public class CloneGraph {

    // Definition for a Node
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }


    class Solution {
        public Node cloneGraph(Node node) {
            Map<Node, Node> cloned = new HashMap<>();

            return dfs(node, cloned);
        }

        private Node dfs(Node node, Map<Node, Node> cloned) {
            if (node == null) {
                return null;
            }
            if (cloned.containsKey(node)) {
                return cloned.get(node);
            }

            Node copy = new Node(node.val, new ArrayList<>());
            cloned.put(node, copy);

            for (Node n : node.neighbors) {
                copy.neighbors.add(dfs(n, cloned));
            }

            return copy;
        }
    }

}
