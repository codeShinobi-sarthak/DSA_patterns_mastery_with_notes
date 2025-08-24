
## 🧠 **What is Union-Find / Disjoint Set?**

A **Disjoint Set** is a data structure that keeps track of a **partition of a set into disjoint subsets**.
It's mainly used for **dynamic connectivity** queries — like "are these two nodes in the same component?"
---

## 🔍 **Time Complexity Analysis**

With **Path Compression** + **Union by Rank**, all operations become **nearly constant time**:

> **O(α(N))** per operation
> Where α(N) is the **Inverse Ackermann function**, which grows **slower than log N** and is **practically constant** for N ≤ 10⁹.

---


### 🌈 Real-World Analogy:

Imagine friend circles. Each person belongs to one friend group. Initially, everyone is in their own group.
When two friends meet, you merge their groups. Later, you might want to know if two people are in the same group — DSU answers this!

---

## 🧱 2. **Core Concepts**

| Concept         | Description                                                             |
| --------------- | ----------------------------------------------------------------------- |
| **Parent**      | Each element points to its "leader" (like a boss or head of a tribe).   |
| **Rank**        | Represents the **height or depth** of the tree (used for optimization). |
| **Find(x)**     | Get the **ultimate parent (representative)** of x.                      |
| **Union(x, y)** | Merge the sets of x and y into one group.                               |

---

## 🧠 3. **Why Do We Need DSU?**

Because checking connectivity in a graph, or managing group-like problems, is expensive without it.

👉 DSU gives nearly constant-time operations with optimizations.
🔍 Common in **Graph Algorithms**, **Kruskal’s MST**, **Cycle Detection**, etc.

---

## 🧪 4. **Detailed Explanation of Core Operations**

### 🔍 4.1 `find(x)` – Get the leader (ultimate parent)

```java
int find(int x) {
    if (parent[x] != x)
        parent[x] = find(parent[x]);  // Path compression here
    return parent[x];
}
```

**What happens here?**

* If `x` is not its own parent, recursively go to its parent.
* While coming back up, **make every node in the path directly point to the root**.
* This **flattens** the tree and speeds up future queries.

### ⚔️ 4.2 `union(x, y)` – Merge the two sets

```java
void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);

    if (rootX == rootY) return; // already in same set

    // Attach smaller tree under larger tree
    if (rank[rootX] < rank[rootY]) {
        parent[rootX] = rootY;
    } else if (rank[rootX] > rank[rootY]) {
        parent[rootY] = rootX;
    } else {
        parent[rootY] = rootX;
        rank[rootX]++;
    }
}
```

**What's going on?**

* Find roots of x and y.
* If they’re already connected → do nothing.
* Else attach the **smaller tree under the bigger** to reduce height.

---

## 🔨 5. **Full Java Code Template**

```java
class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // Each node is its own parent
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]); // Path compression
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}
```

---

## 🧮 6. Time Complexity

| Operation | Time    |
| --------- | ------- |
| `find`    | O(α(N)) |
| `union`   | O(α(N)) |

> α(N) = Inverse Ackermann Function → grows super slowly, treated like O(1) in practice.

---

## 📦 7. Where Do We Use DSU?

| Problem Type              | Application                                    |
| ------------------------- | ---------------------------------------------- |
| ✅ Cycle Detection         | Detect cycle in undirected graphs              |
| ✅ Kruskal’s MST Algorithm | Select smallest edge that doesn’t form a cycle |
| ✅ Number of Islands       | Merge adjacent '1's                            |
| ✅ Accounts Merge          | Merge user accounts with common emails         |
| ✅ Dynamic Connectivity    | Add/delete edges, check if connected           |

---



## 📚 **Common Interview Problems Using DSU**

1. 🔗 **Graph Connectivity** – "Are these two nodes connected?"
2. 🌉 **Kruskal’s MST** – Add smallest edge without forming a cycle.
3. 🌀 **Cycle Detection in Undirected Graph**
4. 🏝️ **Number of Islands (with union)** – Union 2D grid cells.
5. 🔄 **Redundant Connection** – Detect the edge that forms a cycle.
6. ⚔️ **Accounts Merge** – Merge overlapping accounts using Union-Find.
7. 💼 **Employee Merge** – Similar structure, used in company structure questions.
8. 🧱 **Percolation Problem** – Union-find in 2D simulation problems.

---

## 🧪 8. Common Problems on DSU

### 💥 Leetcode Must-Solve:

1. 🔗 [547. Number of Provinces](https://leetcode.com/problems/number-of-provinces/)
2. 🔄 [684. Redundant Connection](https://leetcode.com/problems/redundant-connection/)
3. 🧾 [721. Accounts Merge](https://leetcode.com/problems/accounts-merge/)
4. 🏝️ [200. Number of Islands (with Union-Find)](https://leetcode.com/problems/number-of-islands/)

---

## 🗺️ 9. Visual Intuition (Example Walkthrough)

```text
n = 5 (0 to 4)
Initially:
[0] [1] [2] [3] [4]

Union(0, 1) → 0 becomes parent of 1
[0-1] [2] [3] [4]

Union(1, 2) → 0 becomes parent of 2 as well
[0-1-2] [3] [4]

Find(2):
    parent[2] = 1 → parent[1] = 0
    Path Compression → 2 → 0 directly

```

---
