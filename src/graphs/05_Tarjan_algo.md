
## Tarjan's Strongly Connected Component (SCC) Algorithm 🕵️🔗🔄

### 1. What are Strongly Connected Components (SCCs)? 🔄

*   SCCs are like **self-contained cycles** within a **directed graph**.
*   Within an SCC, you can **reach every other vertex** from any given vertex in the same cycle.
*   You **cannot find a path that leaves a component and comes back** to that same component.
*   Because of this property, SCCs in a graph are **unique**.
*   The video shows an example graph with four distinct SCCs outlined in different colors.

### 2. Understanding Low Link Values 🤔🔗

*   A **low link value** for a node is the **smallest node ID reachable from that node**, *including* the node itself.
*   Node IDs are assigned during a **Depth-First Search (DFS)** traversal.
*   Initially, it might seem that nodes with the **same low link value belong to the same SCC**.
   *   *Example:* Node 1 might have a low link of 0 if node 0 is the lowest ID reachable.
   *   *Example:* Node 3 might have a low link of 2 if node 2 is the lowest ID reachable.
*   When grouping by low link values from a *simple* DFS, nodes appear to group into SCCs.

### 3. The Problem with Simple Low Link Calculation ⚠️😵

*   Grouping nodes by low link values from a single DFS is **highly dependent on the traversal order** of the DFS, which is effectively random.
*   A different DFS order can result in **incorrect low link values** that don't correspond to the true SCCs.
*   The issue is that low link values can be **contaminated** by low IDs from nodes in *other* components if they are reachable during the DFS. This prevents the low link values from telling you which nodes are in which SCCs.

### 4. Tarjan's Algorithm: The Solution! ✅ clever algorithm

*   Tarjan's algorithm is introduced to **cope with the random traversal order** of the DFS.
*   It **maintains an invariant** to prevent low link values of multiple SCCs from interfering with each other.
*   Instead of calculating low links *after* the DFS, Tarjan's **updates them *during* the DFS traversal**, "on the fly".
*   This "on the fly" update allows for a **linear time complexity**.

### 5. Key Components & Variables ⚙️📊

*   **Stack:** A set (often implemented as a stack) of **valid nodes from which to update low link values**.
   *   Nodes are **added to the stack as they are explored for the first time**.
   *   Nodes are **removed from the stack each time an SCC is found**.
*   `unvisited`: A constant value to mark nodes that haven't been visited.
*   `n`: The **number of nodes** in the graph.
*   `G`: The graph, represented as an **adjacency list** of directed edges. Both `n` and `G` are inputs.
*   `id`: A counter used to assign a **unique ID** (like a timestamp) to each node as it's visited.
*   `sccCount`: Tracks the **number of SCCs found**.
*   **Auxiliary Arrays**:
   *   `IDs`: Stores the **ID** assigned to each node. Also indicates if a node has been **visited** (if `IDs[i]` is `unvisited`).
   *   `low`: Stores the **low link value** for each node.
   *   `onStack`: A boolean array tracking whether a node is currently **on the stack**.

### 6. How the DFS Works (The Magic! ✨)

*   Start by marking all nodes as `unvisited` (`IDs[i] = unvisited`).
*   Start a DFS from an unvisited node and continue until all nodes are visited.
*   The `dfs` method takes the current node's ID (`at`).

*   **Upon First Visit (`IDs[at] == unvisited`)** 👇:
   *   Add the current node (`at`) to the stack.
   *   Mark `onStack[at] = true`.
   *   Assign `IDs[at] = id`.
   *   Initialize `low[at] = id`.
   *   Increment the global `id` counter.

*   **Exploring Neighbors (`to`)** ➡️:
   *   Loop through all neighbors (`to`) of the current node (`at`).
   *   If `to` is **unvisited** (`IDs[to] == unvisited`), recursively call `dfs(to)`.

*   **Updating Low Link Values (On Callback/Backtracking) ⬅️** (This happens *after* the recursive call returns):
   *   Check if the neighbor node (`to`) you just returned from is **on the stack** (`onStack[to] == true`).
   *   **If `onStack[to]` is true:** Update the current node's (`at`) low link value: `low[at] = min(low[at], low[to])`. This allows low link values to propagate through cycles.
   *   **If `onStack[to]` is false:** **DO NOT** update `low[at]` using `low[to]`. This prevents contamination from nodes in already found SCCs.

*   **Identifying an SCC** ✅:
   *   After visiting all neighbors of `at`, check if the current node is the **start of a strongly connected component**.
   *   A node `at` starts an SCC if its **ID equals its low link value** (`IDs[at] == low[at]`).

*   **Processing a Found SCC** 📦 Stack Pop
   *   If `IDs[at] == low[at]`, you've found an SCC.
   *   **Pop nodes off the stack** starting from the top, until you pop the current node (`at`).
   *   As you pop a node (`popped_node`), mark it as **not on the stack** (`onStack[popped_node] = false`).
   *   While popping, assign the same ID to all nodes in this SCC (using `IDs[at]`).
   *   Increment `sccCount`.
