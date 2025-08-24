🌟✨ **Session 2.3: Shortest Path Algorithms – Dijkstra, Bellman‑Ford & Floyd‑Warshall** ✨🌟
*"In the kingdom of graphs, not all roads are created equal. Some are short and swift, others deceptive and heavy. Let’s learn how to navigate this world with precision."* 🚦🛣️

---

## 🧭 WHY SHORTEST PATH ALGORITHMS?

In a weighted graph, each edge has a cost—time, distance, money, risk. These algorithms help us **choose the optimal route** from one node to others (or all pairs) depending on constraints like **negative weights**, **graph size**, or **density**.

---

# 🚀 1. **Dijkstra’s Algorithm** – The Greedy Guide

> 📌 **Best for**: Graphs with **non-negative edge weights**

### 🎨 Intuition

Imagine you're navigating a road map. At every step, Dijkstra chooses the **cheapest, known destination** so far and expands from there. It **greedily builds the shortest path tree**, layer by layer.

### 🔄 Step-by-Step

1. Set all distances to ∞, except the source (set to 0).
2. Use a **priority queue** (min-heap) to always pick the closest unvisited node.
3. For each neighbor of the current node:

    * If the new path to neighbor is shorter, update it.
4. Repeat until all nodes are visited or the queue is empty.

### 🧮 Time Complexity

* With a min-heap (priority queue): **O((V + E) log V)**

### ⚠️ Limitations

* Fails with **negative weights**, as it may **lock in a wrong early path**.

---

# ⚔️ 2. **Bellman-Ford Algorithm** – The Resilient Warrior

> 📌 **Best for**: Graphs **with negative weights** but **no negative cycles**

### 🎨 Intuition

Unlike Dijkstra, Bellman-Ford is **not greedy**. It tries all possible paths by **relaxing edges repeatedly**, ensuring you find the true shortest path—**even if it’s buried deep in a chain**.

### 🔄 Step-by-Step

1. Set all distances to ∞, except source = 0.
2. **Repeat V - 1 times**:

    * For every edge (u → v):

        * If `dist[v] > dist[u] + weight`, update `dist[v]`.
3. After V-1 rounds, do a final round:

    * If any edge still updates, a **negative cycle exists**.

### 🧮 Time Complexity

* O(V × E) — can be costly for dense graphs

### ✅ Strengths

* Handles **negative edges**
* Can **detect negative cycles**

---

# 🧠 3. **Floyd-Warshall Algorithm** – The All-Pairs Philosopher

> 📌 **Best for**: **All-pairs shortest paths**, smaller graphs (dense or with ≤100 nodes)

### 🎨 Intuition

Imagine sitting in a matrix room. Each cell `[i][j]` holds the best known distance from node `i` to node `j`. You methodically consider **every node k** as a **potential intermediate**—and ask:

> "Is going through `k` better than going direct?"

If yes, update the path via `k`.

### 🔄 Step-by-Step

For every `k`, for every `i`, for every `j`:

```
if (dist[i][k] + dist[k][j] < dist[i][j])  
    dist[i][j] = dist[i][k] + dist[k][j]
```

### 🧮 Time Complexity

* **O(V³)** — expensive but elegant, best used when `V` is small

### 🧼 Pros

* Works with **negative weights** (but not negative cycles)
* Gives **all-pairs shortest paths** in one go
* Super elegant with adjacency matrix

---

## 📚 Summary Table

| Algorithm      | Handles Negative Weights | Detects Negative Cycles | All Pairs? | Time Complexity  | Use When…                           |
| -------------- | ------------------------ | ----------------------- | ---------- | ---------------- | ----------------------------------- |
| Dijkstra       | ❌ No                     | ❌ No                    | 🚫 No      | O((V + E) log V) | Fast on large graphs with ≥ 0 edges |
| Bellman-Ford   | ✅ Yes                    | ✅ Yes                   | 🚫 No      | O(V × E)         | Safer for negatives, but slower     |
| Floyd-Warshall | ✅ Yes                    | ❌ No                    | ✅ Yes      | O(V³)            | Elegant for dense small graphs      |

---

## 🔍 Real-Life Analogies

* **Dijkstra**: Google Maps avoiding toll roads—greedily looks for minimal time.
* **Bellman-Ford**: Project cost analysis with both gains and losses—carefully considers every edge case.
* **Floyd-Warshall**: Shipping matrix for companies—“what’s the cheapest way from every warehouse to every customer?”

---

