# Breadth-First Search (BFS) and Depth-First Search (DFS)

`JUST EXPLAINED ON HIGHER LEVEL SEE CS50AI VIDEO LECTURE MENTIONED BELOW`

## 1. Breadth-First Search (BFS)
BFS is a graph traversal algorithm that explores all neighbors of a node before moving to the next level. It is implemented using a **queue (FIFO)**.

### Characteristics:
- Explores nodes level by level.
- Guarantees the shortest path in an unweighted graph.
- Uses more memory compared to DFS.

### Pseudocode:
```python
from collections import deque

def bfs(graph, start):
    queue = deque([start])
    visited = set()
    visited.add(start)
    
    while queue:
        node = queue.popleft()
        print(node)  # Process the node
        
        for neighbor in graph[node]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append(neighbor)
```

---

## 2. Depth-First Search (DFS)
DFS is a graph traversal algorithm that explores as deep as possible along each branch before backtracking. It is implemented using a **stack (LIFO)** (or recursion).

### Characteristics:
- Explores as far as possible before backtracking.
- May not find the shortest path.
- Uses less memory than BFS in most cases.

### Pseudocode:
```python
def dfs(graph, node, visited=None):
    if visited is None:
        visited = set()
    
    if node not in visited:
        print(node)  # Process the node
        visited.add(node)
        
        for neighbor in graph[node]:
            dfs(graph, neighbor, visited)
```

---

# Visit CS50AI Lecture 0
For a deeper understanding of BFS and DFS, refer to **CS50AI Lecture 0**:

[CS50AI Lecture 0: Search (Video)](https://www.youtube.com/watch?v=WbzNRTTrX0g&t=1s)

[CS50AI Lecture 0: Search (Notes)](https://cs50.harvard.edu/ai/2020/notes/0/)

**It also Explains the the concept of search, min max and other import concepts**