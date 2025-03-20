# Disjoint Set (Union-Find)

#disjointset #union-find #dsu #graph

## Overview

The Disjoint Set Union (DSU) or Union-Find data structure is used to efficiently manage and query connectivity between elements. It supports two primary operations:

- `Find(x)`: Determines the representative (root) of the set containing x.

- `Union(x, y)`: Merges the sets containing x and y.

This data structure is commonly used in graph-related problems, such as Kruskal’s Minimum Spanning Tree (MST) algorithm.

## Optimizations

1. Path compression in `find(x)`
    - reduces the depth of the tree by making each node directly point to the root
    - Improvement: speeds up future `find()` operations by flattening the structure

2. Union by rank
    - always attach the smaller tree under the larger tree to keep the structure balanced
    - Improvement: reduces tree height, leading to faster operations

## Example

```java
class DisjointSet {
    private int[] parent;
    private int[] rank;

    DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i; // initially, each node is its own parent
            rank[0] = 0;
        }
    }

    int find(int v) {
        if (parent[v] != v) {
            parent[v] = find(parent[v]); // path compression
        }
        return parent[v];
    }

    void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}
```


## Kruskal's Algorithm (using Union-Find)

Kruskal’s algorithm is used to find the Minimum Spanning Tree (MST) of a weighted graph.

Steps:
1. Sort all edges in non-decreasing order of weight.
2. Initialize the Union-Find structure (each node is its own parent initially).
3. Iterate through edges:
    - If the edge connects two different sets, add it to the MST and merge the sets.
    - Otherwise, ignore the edge (to avoid cycles).
4. Stop when we have V-1 edges in the MST (where V is the number of vertices).

### Implementation

```java
class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class DisjointSet {
    int[] parent, rank;
    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    int find(int v) {
        if (parent[v] != v) parent[v] = find(parent[v]);
        return parent[v];
    }
    void union(int u, int v) {
        int rootU = find(u), rootV = find(v);
        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) parent[rootV] = rootU;
            else if (rank[rootU] < rank[rootV]) parent[rootU] = rootV;
            else { parent[rootV] = rootU; rank[rootU]++; }
        }
    }
}

public class KruskalsAlgorithm {
    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));
        
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(V);
        List<Edge> mst = new ArrayList<>();
        
        for (Edge edge : edges) {
            if (ds.find(edge.src) != ds.find(edge.dest)) {
                mst.add(edge);
                ds.union(edge.src, edge.dest);
            }
        }
        
        System.out.println("Edges in Minimum Spanning Tree:");
        for (Edge e : mst) {
            System.out.println(e.src + " - " + e.dest + " : " + e.weight);
        }
    }
}
```

## Complexity Analysis

| Operation |   Time complexity |
| :--- | :--- |
| Find() (with path compression) | O(α(V)) |
| Union() (with rank) | O(α(V)) |
| Kruskal’s Algorithm | O(E log E) |

Where α(V) is the inverse Ackermann function, which is nearly constant in practice.