# Topological Sorting Explanation

#topological #sort #graph #topology

Topological sorting is an ordering of the vertices in a Directed Acyclic Graph (DAG) such that for every directed edge `u→v`, vertex `u` appears before vertex `v` in the ordering.

## Key Points:

- Topological sorting is only possible for DAGs (graphs without cycles).
- It is not unique—there can be multiple valid topological orders for the same graph.
- It is commonly used in scheduling problems, dependency resolution, and compiler optimizations.

## Algorithms for Topological Sorting

There are two main approaches:

1. Kahn’s Algorithm (BFS-based approach).
    Uses in-degree (number of incoming edges to a node).
    Start with nodes having zero in-degree.
    Remove processed nodes and update in-degrees.
    Repeat until all nodes are processed.

2. DFS-Based Approach.
    Uses Depth First Search (DFS) and a stack.
    Recursively visit all adjacent nodes before pushing the current node onto the stack.
    The final order (reverse of stack order) is the topological order.

### Example: Using Kahn’s Algorithm

Consider a graph:
```txt
   5 → 0 → 2
   4 → 0 → 3
   2 → 3
   4 → 1 → 3
```

```java
public class TopologicalSort {
    public static void topologicalSort(int vertices, List<List<Integer>> adj) {
        int[] inDegree = new int[vertices];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        // Compute in-degrees
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Add nodes with zero in-degree to the queue
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Process nodes
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Check if topological sorting was possible (DAG verification)
        if (result.size() != vertices) {
            System.out.println("Cycle detected! No topological sort possible.");
        } else {
            System.out.println("Topological Sort: " + result);
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        topologicalSort(vertices, adj);
    }
}
```

### Topological Sorting using DFS

The DFS-based approach works as follows:

1. Use DFS to visit each node.
2. Recursively visit all adjacent nodes before adding the current node to a stack.
3. Reverse the stack to get the topological order.

```java
public class DFSTopologicalSort {
    public static void topologicalSort(int vertices, List<List<Integer>> adj) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        // Perform DFS for each unvisited node
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        // Print topological order
        System.out.print("Topological Sort (DFS): ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private static void dfs(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }

        // Push the node onto the stack after visiting all its neighbors
        stack.push(node);
    }

    public static void main(String[] args) {
        int vertices = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        topologicalSort(vertices, adj);
    }
}
```

## Complexity

| Approach	| Data Structure Used | Complexity | Suitable For |
| :--- | :--- | :--- | :--- |
| Kahn’s Algorithm (BFS) | Queue (in-degree processing) | `O(V+E)` | When in-degree is easy to compute |
| DFS-Based Approach | Stack (post-order DFS) | `O(V+E)` | When recursive DFS is easier |
