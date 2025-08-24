🌿✨ **Session 1.2: Depth‑First Search (DFS)** ✨🌿

---

### 📝 Core Ideas

1. **Recursive DFS**:

    * Dive deep: call DFS on each unvisited neighbor.
    * Backtrack naturally as the call stack unwinds.
2. **Iterative DFS**:

    * Simulate recursion with an explicit **Stack**.
    * Handy when recursion depth is a worry.
3. **Visited Array**:

    * Prevent infinite loops by marking vertices.
4. **Connected Components**:

    * Run DFS from every unvisited vertex—each launch marks a new component.

---

### 🌱 Java Implementation

```java
public class GraphDFS {
    private final int V;
    private List<List<Edge>> adjList;

    public GraphDFS(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(new Edge(u, v));
        adjList.get(v).add(new Edge(v, u));  // remove for directed
    }

    // Recursive DFS
    private void dfsRecursive(int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");
        for (Edge e : adjList.get(u)) {
            if (!visited[e.to]) {
                dfsRecursive(e.to, visited);
            }
        }
    }

    // Iterative DFS
    private void dfsIterative(int start) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");
                // Push neighbors (in reverse order to match recursive)
                for (int i = adjList.get(u).size() - 1; i >= 0; i--) {
                    int v = adjList.get(u).get(i).to;
                    if (!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }
    }

    // Count connected components
    public int countComponents() {
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                System.out.print("Component " + (++count) + ": ");
                dfsRecursive(i, visited);
                System.out.println();
            }
        }
        return count;
    }

    // Demo
    public static void main(String[] args) {
        GraphDFS g = new GraphDFS(6);
        int[][] edges = {
            {0, 1}, {0, 2}, {1, 3},
            {2, 3}, {4, 5}
        };
        for (int[] e : edges) g.addEdge(e[0], e[1]);

        System.out.print("Recursive DFS from 0: ");
        g.dfsRecursive(0, new boolean[g.V]);
        System.out.println();

        System.out.print("Iterative DFS from 0: ");
        g.dfsIterative(0);
        System.out.println("\n");

        int comps = g.countComponents();
        System.out.println("Total components: " + comps);
    }
}
```

---

### 🖋️ Diagram (Sample Graph & DFS Tree)

```
    0──1
    │  │
    2──3

    4──5
```

* **DFS Recursive (from 0)**: 0 → 1 → 3 → 2
* **Component Trees**:

    * Component 1: (0, 1, 3, 2)
    * Component 2: (4, 5)

---

🌾✨ **Session 2.1: Breadth‑First Search (BFS)** ✨🌾

---

### 🌊 The Essence of BFS

Imagine dropping a pebble in a still pond. Ripples spread evenly in all directions, reaching every point at the same “distance” before moving on. That’s BFS in a graph: from a chosen start node, you visit every neighbor, then every neighbor of those neighbors, and so on—never leaping deeper until every node at the current depth is explored.

---

### 📜 Step‑by‑Step Journey

1. **Initialize**

    * Mark all vertices as unvisited.
    * Prepare an empty **queue**.
2. **Start Point**

    * Choose a source node; mark it visited and enqueue it.
3. **Wave Expansion**

    * **While** the queue isn’t empty:

        1. **Dequeue** the front node (call it “current”).
        2. **Process**: record its value, or update distance.
        3. **Enqueue Neighbors**: for each adjacent node not yet visited, mark it visited and enqueue.
4. **Completion**

    * When the queue drains, every vertex reachable from the source has been touched in order of increasing distance.

---

### 🌟 Why BFS Shines

* **Shortest Path in Unweighted Graphs**
  Each layer you traverse increments the distance by exactly one edge. The first time you reach a target, you’ve found the shortest route.
* **Connectivity & Components**
  Run BFS from an unvisited node; all nodes you reach form one connected component.
* **Level‑Order Traversal**
  Ideal for scenarios where you must process or group nodes by their “depth”—for example, in social networks (friends of friends), organizational charts, or puzzle solvers.

---

### 🕰️ Complexity & Considerations

* **Time**: O(V + E) — every vertex and edge is considered at most once.
* **Space**: O(V) for the queue and visited markers.
* **Trade‑off vs. DFS**

    * BFS uses more memory (holds an entire frontier), but guarantees minimal steps to targets.
    * DFS uses less immediate memory but dives deep, which can miss the shallow shortest path.

---

### ✨ Real‑World Inspirations

* **GPS Navigation**: Finding the fewest turns on a grid‑like street map.
* **Peer‑to‑Peer Networks**: Broadcasting a message in layers so every peer hears it in the fewest hops.
* **AI Pathfinding**: Early moves in maze‑solving games to guarantee shortest moves.

---
