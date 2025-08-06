#tree #segment #segmenttree

A **Segment Tree** is a binary tree data structure used for efficient range queries and updates on arrays.


## What It Does

Efficiently performs:
- Range queries (e.g., sum, min, max) in O(log n)
- Point updates (change a value) in O(log n)

Much faster than naive O(n) approaches when multiple operations are involved.

## Example Problem

You have an array of stock prices:
```
prices = [5, 2, 6, 3]
```

Need to answer:
- What's the maximum price between day 1 and day 3?
- What if day 2's price changes?

Segment Tree solves both in logarithmic time.

## Structure

- Leaf nodes: each represent a single array element

- Internal nodes: aggregate data from their children (e.g., max/sum/min)

Visual layout for `arr = [5, 2, 6, 3]` (storing max):

```text
                    [0,3]
                    max=6
                  /        \
              [0,1]        [2,3]
            max=5         max=6
           /    \        /     \
        [0]      [1]   [2]      [3]
        5         2     6        3
```

## Operations
1. Build: Build tree from array in O(n) time.
2. Query: Get aggregate (e.g. max) in range [L, R] in O(log n) time.
3. Update: Change a single element’s value in O(log n) time and update all affected parent nodes.


## Time and Space complexity

| Operation | Time     | Space |
| --------- | -------- | ----- |
| Build     | O(n)     | O(n)  |
| Query     | O(log n) | O(n)  |
| Update    | O(log n) | O(n)  |

> Tree is usually implemented using an array of size 4 * n (safe upper bound).

## When to use
- frequent range queries (sum, min, max, etc.) and frequent updates
- The array is mutable (values can change)
- fast performance (O(log n) per query/update)
- you are working with static-size arrays (no inserts/deletes)
- problems involve intervals, sliding windows, or subarray aggregates

## When not to use

- Prefix sums needed (or range sum updates only)
    * Use a Fenwick Tree / Binary Indexed Tree, which is simpler and faster to implement.
- The array is never updated
    * Use prefix sums (precompute once, answer in O(1)) — no tree needed.
- Inserts/deletes needed (i.e. a dynamic array)
    * Use Balanced Binary Search Trees (e.g., TreeSet, TreeMap, AVL) or Ordered Statistics Trees.
- The array size is very small (e.g. ≤ 1000) and performance is not critical
    * A simple brute-force approach is often easier and more readable.
- multi-dimensional queries needed (e.g. 2D range sums) and segment tree complexity becomes too high
    * Use 2D prefix sums, Fenwick Trees, or even KD-Trees depending on the use case.

## Example

```java
class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }

    public void build(int[] arr, int node, int l, int r) {
        if (l == r) {
            // means that this is a Leaf node: store the array element
            tree[node] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        // Left child is at index: 2 * node + 1
        // Right child is at index: 2 * node + 2
        // These formulas ensure a binary heap-style tree layout in a flat array
        build(arr, 2 * node + 1, l, mid);
        build(arr, 2 * node + 2, mid + 1, r);
        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    public int query(int ql, int qr) {
        return query(0, 0, n - 1, ql, qr);
    }

    /**
     * node - node's index
     * l - Left boundary of the current node's segment
     * r - Right boundary of the current node's segment
     * ql - Left boundary of the query range
     * qr - Right boundary of the query range
     */
    public int query(int node, int l, int r, int ql, int qr) {
        if (qr < l || ql > r) { // no overlap
            return Integer.MIN_VALUE;
        }
        if (ql <= l && r <= qr) { // full overlap
            return tree[node];
        }
        int mid = (l + r) / 2;
        return Math.max(
            query(2 * node + 1, l, mid, ql, qr),
            query(2 * node + 2, mid + 1, r, ql, qr)
        );
    }

    public void update(int index, int value) {
        update(0, 0, n - 1, index, value);
    }

    public void update(int node, int l, int r, int index, int value) {
        if (l == r) {
            tree[node] = value;
            return;
        }
        int mid = (l + r) / 2;
        if (index <= mid) {
            update(2 * node + 1, l, mid, index, value);
        } else {
            update(2 * node + 2, mid + 1, r, index, value);
        }
        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }
}

```

## Variants

- Lazy Segment Tree: optimized for range updates
- Persistent Segment Tree: supports versioning (used in advanced algorithms)
- 2D Segment Tree: for 2D grids

## Related Topics
- Fenwick Tree (Binary Indexed Tree)
- Range Minimum Query (RMQ)
- Lazy Propagation
- Prefix Sum vs Segment Tree
