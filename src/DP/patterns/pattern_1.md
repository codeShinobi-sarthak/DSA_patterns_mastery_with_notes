## 🧩 Pattern 1️⃣: 1D DP — *Linear Progression Problems* 🧗‍♂️📈

### 📖 Concept Explanation (Easy Mode Activated 🧃)

This pattern applies when:
- The problem depends on **previous 1 or 2 or k steps**
- The **state** can be represented by **one variable (like an index)**
- Classic examples include:  
  ➤ Climbing Stairs 🪜  
  ➤ Fibonacci Numbers 🐚  
  ➤ Minimum Cost Climbing Stairs 💰  
  ➤ House Robber 🏠💵

---

### 🔁 Recurrence Relation Pattern

The basic idea:  
`dp[i] = dp[i-1] + dp[i-2]`  
Or  
`dp[i] = min(dp[i-1], dp[i-2]) + cost[i]`

🎯 Your state depends on 1 or 2 previous states — **linear flow**.

---

### 🔥 Example Problem: Climbing Stairs

📜 **Problem:**  
You are climbing a staircase. It takes `n` steps to reach the top. Each time you can climb either 1 or 2 steps.  
**Q:** How many distinct ways can you climb to the top?

---

### 🧠 Step-by-Step Approach

#### ➤ **1. Identify Base Cases**
- `dp[0] = 1` (1 way to stand at the start)
- `dp[1] = 1` (1 way to reach step 1: take 1 step)

#### ➤ **2. Recurrence Relation**
- To reach step `i`, either come from `i-1` or `i-2`:  
  `dp[i] = dp[i-1] + dp[i-2]`

---

### 💻 Java Code: Tabulation

```java
public int climbStairs(int n) {
    if (n <= 1) return 1;
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
}
```

---

### 🪄 Space Optimized Java Code

```java
public int climbStairs(int n) {
    if (n <= 1) return 1;
    int prev2 = 1, prev1 = 1;
    for (int i = 2; i <= n; i++) {
        int curr = prev1 + prev2;
        prev2 = prev1;
        prev1 = curr;
    }
    return prev1;
}
```

🧠 Space: O(1) ✅  
⏱️ Time: O(n) ✅

---

### 🖼️ Visual Diagram

```
dp[0] = 1
dp[1] = 1
dp[2] = dp[1] + dp[0] = 2
dp[3] = dp[2] + dp[1] = 3
dp[4] = dp[3] + dp[2] = 5
...
```

It forms the **Fibonacci** sequence! 🔁

---

### 🎯 Real-World Interview Problems (Same Pattern)

| 🔢 Problem | 💡 Platform |
|-----------|-------------|
| Climbing Stairs | LeetCode Easy |
| Min Cost Climbing Stairs | LeetCode Easy |
| House Robber | LeetCode Medium |
| Jump Game | LeetCode Medium |
| Frog Jump | LeetCode (Harder Variant) |