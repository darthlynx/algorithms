# Diameter of the Tree

#graph #DFS #BFS

## Main approach:
Run BFS/DFS on any node `s` in the graph, remembering the node `u` discovered last.
Run BFS/DFS from `u` remembering the node `v` discovered last.
`d(u,v)` is the diameter of the tree

Example (DFS):
```java
class Solution {
    private int maxDistance = -1;
    private int farthestNode = -1;

    private int calculateDiameter(Map<Integer, List<Integer>> graph) {
        maxDistance = -1;
        farthestNode = -1;
        Set<Integer> visited = new HashSet<>();
        // starting from random node
        dfs(0, visited, 0, graph);

        maxDistance = 0;
        visited = new HashSet<>();
        // starting from the farthest node
        dfs(farthestNode, visited, 0, graph);

        return maxDistance;
    }

    private void dfs(int node, Set<Integer> visited, int distance, Map<Integer, List<Integer>> graph) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);

        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }

        for (int neighbour : graph.getOrDefault(node, new ArrayList<>())) {
            dfs(neighbour, visited, distance + 1, graph);
        }
    }
}
```