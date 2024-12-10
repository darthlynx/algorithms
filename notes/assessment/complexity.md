
## Input assessment

| Input Size (N) | Time Complexity | Typical Approaches |
| -------------- | --------------- | ------------------ |
| <= 11          | O(N!)           | Permutations |
| <= 26          | O(2^N)          | Exploring all subsets, recursive traversals |
| <= 100         | O(N^4)          | Quadruple nested loops |
| <= 500         | O(N^3)          | Triple nested loops, brute force, Floyd-Warshall algo |
| <= 10^4        | O(N^2)          | Double nested loops, simple sorting |
| <= 10^6        | O(N * logN)     | Efficient sorting, Binary search (N times), Heaps |
| <= 10^8        | O(N)            | Linear traversals, hashing, counting |
| > 10^8         | O(logN), O(1)   | Binary search, Euclidian algo, Basic Math |


