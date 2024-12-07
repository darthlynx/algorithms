# 0-1 Breads First Search

Tags: #Graph #BFS

Ref: [https://codeforces.com/blog/entry/22276](https://codeforces.com/blog/entry/22276)

0-1 BFS is named so, since it works on graphs with edge weights 0 and 1. 

Let's take a point of execution of BFS when you are at an arbitrary vertex "u" having edges with weight 0 and 1. Similar to Dijkstra, we only put a vertex in the queue if it has been relaxed by a previous vertex (distance is reduced by travelling on this edge) and we also keep the queue sorted by distance from source at every point of time

Now, when we are at `u`, we know one thing for sure: Travelling an edge `(u,v)` would make sure that `v` is either in the same level as `u` or at the next successive level. 
This is because the edge weights are 0 and 1. An edge weight of 0 would mean that they lie on the same level, whereas an edge weight of 1 means they lie on the level below. 
We also know that during BFS our queue holds vertices of two successive levels at max. So, when we are at vertex `u`, our queue contains elements of level `L[u]` or `L[u] + 1`. And we also know that for an edge `(u,v)`, `L[v]` is either `L[u]` or `L[u] + 1`. Thus , if the vertex `v` is relaxed and has the same level, we can push it _to the front of our queue_ and if it has the very next level, we can push it _to the end of the queue_.
This helps us keep the queue sorted by level for the BFS to work properly.

We could use double ended queue (`Deque` in Java) to do the next operations:
1. Remove top element (to get the vertex for BFS)
2. Insert at the beginning (for elements with the same level, 0)
3. Insert at the end (to push a vertex on next level, 1)


### Example:

```
for all v in vertices:
	dist[v] = inf
dist[source] = 0;
deque d
d.push_front(source)
while d.empty() == false:
	vertex = get front element and pop as in BFS.
	for all edges e of form (vertex , u):
	    if travelling e relaxes distance to u:
			relax dist[u]
			if e.weight = 1:
				d.push_back(u)
			else:
				d.push_front(u)
```

### Complexity
But the time complexity of this code is `O(E + V)` , which is linear and more efficient than Dijkstra.
The analysis and proof of correctness is also same as that of BFS