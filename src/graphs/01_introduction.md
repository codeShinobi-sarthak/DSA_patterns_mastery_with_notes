🌿✨ **Session 1.1: Graph Basics & Representations** ✨🌿

---

### 🎯 Goals

* **Speak the language of graphs**: vertices, edges, directed vs. undirected, weighted vs. unweighted.
* **See two faces of the same coin**: adjacency **list** vs. adjacency **matrix**, and when to choose each.

---

### 📝 Key Concepts (Glossary)

1. **Vertex (Node)**: A fundamental unit, like a point on a map.
2. **Edge**: A connection between two vertices.
3. **Directed** (*digraph*): Edges have an orientation (A → B).
4. **Undirected**: Edges don’t care about direction (A — B).
5. **Weighted**: Each edge carries a “cost” or “distance” (e.g., 5 km).
6. **Unweighted**: All edges are equal (just “there” or “not there”).

---

### 🔍 Representations

| Representation                      | Storage                           | Pros                                | Cons |
| ----------------------------------- | --------------------------------- | ----------------------------------- | ---- |
| **Adjacency List**                  | Array/List of Lists               | ✓ Space‑efficient for sparse graphs |      |
| ✓ Easy to iterate neighbors         | ✗ Slower “isConnected?” check     |                                     |      |
| ✗ Can be verbose to print           |                                   |                                     |      |
| **Adjacency Matrix**                | 2D Array (V×V)                    | ✓ O(1) to check if edge exists      |      |
| ✓ Simple & compact for dense graphs | ✗ O(V²) space—even when few edges |                                     |      |
| ✗ Iterating neighbors is O(V)       |                                   |                                     |      |

---

### 🌱 Java Code Stubs

```java
// Represents an edge (optionally weighted)
class Edge {
    int from, to;
    int weight;          // set to 1 if unweighted

    Edge(int from, int to) {
        this(from, to, 1);
    }
    Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

// Graph using adjacency list & matrix
public class Graph {
    private final int V;                  // number of vertices
    private List<List<Edge>> adjList;     // adjacency list
    private int[][] adjMatrix;            // adjacency matrix

    public Graph(int V, boolean useMatrix) {
        this.V = V;
        if (useMatrix) {
            adjMatrix = new int[V][V];
        } else {
            adjList = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>());
            }
        }
    }

    // Add an undirected edge
    public void addEdge(int u, int v, int w) {
        if (adjList != null) {
            adjList.get(u).add(new Edge(u, v, w));
            adjList.get(v).add(new Edge(v, u, w));
        }
        if (adjMatrix != null) {
            adjMatrix[u][v] = w;
            adjMatrix[v][u] = w;
        }
    }

    // Print adjacency list
    public void printAdjList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.print(i + ": ");
            for (Edge e : adjList.get(i)) {
                System.out.print("→" + e.to + "(" + e.weight + ") ");
            }
            System.out.println();
        }
    }

    // Print adjacency matrix
    public void printAdjMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            System.out.println(Arrays.toString(adjMatrix[i]));
        }
    }
}
```

---

### 🔨 Build & Traverse a Simple Graph

```java
public static void main(String[] args) {
    int nodes = 5;
    Graph gList = new Graph(nodes, false);
    Graph gMatrix = new Graph(nodes, true);

    // Sample edges
    int[][] edges = {
        {0, 1, 1}, {0, 2, 3},
        {1, 3, 2}, {2, 3, 4},
        {3, 4, 5}
    };
    for (int[] e : edges) {
        gList.addEdge(e[0], e[1], e[2]);
        gMatrix.addEdge(e[0], e[1], e[2]);
    }

    // Visualize both representations
    gList.printAdjList();
    gMatrix.printAdjMatrix();
}
```

---

### 🖋️ Diagram (5‑Node Example)

```
   (0)
   / \
1 /   \3
 /     \
(1)──2─>(3)──5──(4)
  \
   2
    \
    (2)
```

* **List view**:

    * 0: →1(1) →2(3)
    * 1: →0(1) →3(2) →2(2)
    * …
* **Matrix view**:

    * Row 0: \[0, 1, 3, 0, 0]
    * Row 1: \[1, 0, 2, 2, 0]
    * …

---

