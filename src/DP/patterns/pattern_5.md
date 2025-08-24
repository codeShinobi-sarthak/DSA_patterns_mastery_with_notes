# 🎒 Pattern 5️⃣: **Knapsack DP** — “Pack Smart, Win Big” 💰🎯

---

### 📖 Concept Explanation

The **Knapsack Pattern** involves making decisions under **constraints** — typically, you have a limited capacity (like a bag), and you're choosing whether to include each item.

Most problems follow this vibe:
> ✅ "Include or Exclude"  
> 🎯 "Maximize or Minimize something (value, weight, cost)"

---

### 🎒 Classic 0/1 Knapsack Problem

📜 **Problem Statement:**  
You are given:
- `weights[]` of `n` items
- `values[]` of those items
- A max weight `W` (capacity of your bag)

**Goal:** Pick items to maximize total value **without exceeding weight W**

---

### 🧠 Recurrence Relation

Let’s define `dp[i][w]` = max value with items `0 to i` and capacity `w`

**Two choices at each step:**
- 🔴 Don't take item: `dp[i-1][w]`
- 🟢 Take item if `weights[i] ≤ w`: `values[i] + dp[i-1][w - weights[i]]`

So,

```java
dp[i][w] = max(dp[i-1][w], values[i] + dp[i-1][w - weights[i]])
```

---

### 💻 Java Code – 0/1 Knapsack

```java
public int knapsack(int[] weights, int[] values, int W) {
    int n = weights.length;
    int[][] dp = new int[n+1][W+1];

    for (int i = 1; i <= n; i++) {
        for (int w = 0; w <= W; w++) {
            if (weights[i-1] <= w)
                dp[i][w] = Math.max(dp[i-1][w], values[i-1] + dp[i-1][w - weights[i-1]]);
            else
                dp[i][w] = dp[i-1][w];
        }
    }
    return dp[n][W];
}
```

---

### 🎯 Real Interview Problems Using This Pattern:

| 🧩 Problem | 💥 Type |
|-----------|---------|
| 0/1 Knapsack | Classic |
| Subset Sum | Only weights |
| Equal Partition | Can we split array in 2 equal sums? |
| Target Sum | + and - signs to reach a target |
| Count of Subsets with Given Sum | Count ways to sum to `target` |
| Min Subset Sum Diff | Balance two subsets |
| Can Partition K Subsets | Variation of subset-sum |

---

### 🪄 Space Optimization

We only use the previous row, so we can optimize space:

```java
int[] prev = new int[W+1];
int[] curr = new int[W+1];

for (int i = 1; i <= n; i++) {
    for (int w = 0; w <= W; w++) {
        if (weights[i-1] <= w)
            curr[w] = Math.max(prev[w], values[i-1] + prev[w - weights[i-1]]);
        else
            curr[w] = prev[w];
    }
    prev = curr.clone();
}
```

---

### 🧠 Table Visualization (for `n=3`, `W=5`)

| weights -> | 0 | 1 | 2 | 3 | 4 | 5 |
| ------------ |---|---|---|---|---|---|
| i=0       | 0 | 0 | 0 | 0 | 0 | 0 |
| i=1       | 0 | 0 | 3 | 3 | 3 | 3 |
| i=2       | 0 | 0 | 3 | 4 | 4 | 7 |
| i=3       | … | … | … | … | … | ✅ |

---

### 📌 Summary

| 🎯 Thing to Remember | 🔥 Insight |
|----------------------|-----------|
| 2 Decisions | Include or Exclude |
| 2D Table = item × weight | Base case: dp[0][*] = 0 |
| Capacity W drives choices | Check if weight fits |
| Common in finance, gaming, resource allocation | Real-world vibes ✅ |