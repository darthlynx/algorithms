# Eulerian Path

Tags: #Graph

[Eulerian Path](https://en.wikipedia.org/wiki/Eulerian_path) is a path in a graph that visits every edge exactly once. Eulerian Circuit is an Eulerian Path that starts and ends on the same vertex. 


## The Rules of Eulerian Path

Eulerian paths have a couple of conditions:

In an undirected graph, either all nodes have an even degree, or exactly two have an odd degree.
In a directed graph (which is what we have here), we need to check if:
- Each node’s `outDegree` matches its `inDegree`;
- Or, exactly one node has one more outgoing edge (`outDegree = inDegree + 1`), which indicates our starting point.

![Example](../Excalidraw/EulerianPath.excalidraw)

Reference: [Eurelian Path/Circuit algorithm](https://www.youtube.com/watch?v=8MpoO2zA2l4)