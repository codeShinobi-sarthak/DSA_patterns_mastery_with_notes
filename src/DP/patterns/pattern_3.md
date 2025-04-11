## 🧩 Pattern 3️⃣: **Grid DP** — “Paths in a 2D Grid” 📦➡️📦

---

### 📖 Concept Explanation

Grid DP problems involve:
- Navigating a **2D matrix/grid**
- Usually moving **right ⬅️ or down ⬇️**
- Goal: Find the **min/max/count of ways** to reach a cell.

⛳ Most common goals:
- 🔢 Count paths
- 💰 Minimize cost
- 🧱 Avoid obstacles

---

### 🧠 Typical DP Structure

We use a **2D DP array**: `dp[row][col]`  
It means: “What’s the best value I can achieve at (row, col)?”

---

### 🔥 Example Problem 1: **Unique Paths**

📜 **Problem:**  
Robot starts at `(0, 0)` and must reach `(m-1, n-1)` by only moving ⬇️ or ➡️. How many unique paths?

---

### 💡 Idea

To reach `dp[i][j]`, we can only come from:
- `dp[i-1][j]` (from above)
- `dp[i][j-1]` (from left)

So,

```
dp[i][j] = dp[i-1][j] + dp[i][j-1]
```

---

### 💻 Java Code

```java
public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];

    // First row and column have only one path
    for (int i = 0; i < m; i++) dp[i][0] = 1;
    for (int j = 0; j < n; j++) dp[0][j] = 1;

    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
    }
    return dp[m-1][n-1];
}
```

---

### 🔥 Example Problem 2: **Minimum Path Sum**

📜 **Problem:**  
Given a grid filled with non-negative numbers, find a path from `(0, 0)` to `(m-1, n-1)` that minimizes the sum.

---

### 🧠 Transition

From top or left, choose the one with **minimum cost**:

```
dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
```

---

### 💻 Java Code

```java
public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] dp = new int[m][n];

    dp[0][0] = grid[0][0];

    // Fill first row and col
    for (int i = 1; i < m; i++)
        dp[i][0] = dp[i-1][0] + grid[i][0];
    for (int j = 1; j < n; j++)
        dp[0][j] = dp[0][j-1] + grid[0][j];

    // Fill rest of grid
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
        }
    }
    return dp[m-1][n-1];
}
```

---

### 🪄 Bonus: Space Optimization

You only need the **previous row or column**, so you can reduce space from `O(m*n)` ➡️ `O(n)`

```java
public int uniquePathsOptimized(int m, int n) {
    int[] dp = new int[n];
    Arrays.fill(dp, 1); // first row

    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[j] += dp[j - 1];
        }
    }
    return dp[n - 1];
}
```

---

### 🧠 Visualization of Path Count

For 3x3 Grid:

```
1 1 1
1 2 3
1 3 6  <- total paths to reach each cell
```

---

### 🎯 Real Interview Problems

| 🧩 Problem | 💡 Platform |
|-----------|-------------|
| Unique Paths | LeetCode Medium |
| Minimum Path Sum | LeetCode Medium |
| Unique Paths II (with obstacles) | LeetCode Medium |
| Max Path Sum in Grid | Coding Ninjas, GFG |
| Cherry Pickup I/II | LeetCode Hard |

---