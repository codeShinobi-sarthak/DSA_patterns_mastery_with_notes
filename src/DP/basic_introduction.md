## 🧠 Phase 1: Foundations of Dynamic Programming 📘✨

### 🔍 What is Dynamic Programming (DP)?

> **Dynamic Programming is a method for solving problems by breaking them down into simpler subproblems, solving each subproblem once, and storing their results to avoid redundant work.**

It is used **only** when:
- ✅ **Overlapping Subproblems** exist
- ✅ The problem has an **Optimal Substructure**

---

### 🧠 Key Concepts

#### 🧩 1. Overlapping Subproblems

If your recursive solution recalculates the same subproblems again and again — **Bingo!** That’s a DP candidate 🎯

🧪 _Example:_
Fibonacci(5) = Fibonacci(4) + Fibonacci(3)  
But... Fibonacci(4) = Fibonacci(3) + Fibonacci(2)  
👉 We see Fibonacci(3) repeated — overlapping! 😲

---

#### 🧱 2. Optimal Substructure

A problem has **optimal substructure** if its optimal solution can be constructed from the optimal solutions of its subproblems.

🧪 _Example:_  
Shortest path from A to D via B and C depends on the shortest paths A→B, B→C, and C→D.

---

### 🧠 Memoization vs Tabulation

| 📊 Feature | 🧠 Memoization (Top-Down) | 🧮 Tabulation (Bottom-Up) |
|-----------|---------------------------|----------------------------|
| 🎯 Approach | Recursive + Caching | Iterative |
| 🧾 Structure | Function calls with cache | Filling table |
| 🚀 Speed | Faster for small inputs | Better for large input |
| 🧠 Stack | Uses Call Stack | No recursion |

---

#### 🔧 Memoization (Top-Down) — Java Style
```java
int fib(int n, int[] dp) {
    if (n <= 1) return n;
    if (dp[n] != -1) return dp[n];
    return dp[n] = fib(n-1, dp) + fib(n-2, dp);
}
```

---

#### 🧮 Tabulation (Bottom-Up) — Java Style
```java
int fib(int n) {
    int[] dp = new int[n+1];
    dp[0] = 0; dp[1] = 1;
    for (int i = 2; i <= n; i++)
        dp[i] = dp[i-1] + dp[i-2];
    return dp[n];
}
```

---

### 🪄 Space Optimization

👉 Sometimes, you don’t need the whole `dp[]` array — just the **last few values**!

```java
int fib(int n) {
    if (n <= 1) return n;
    int prev2 = 0, prev1 = 1;
    for (int i = 2; i <= n; i++) {
        int cur = prev1 + prev2;
        prev2 = prev1;
        prev1 = cur;
    }
    return prev1;
}
```

🔥 **Boom!** O(n) → O(1) space with the same result!

---

### 🧪 Quick Checklist to Identify a DP Problem:

✅ Can you break the problem into subproblems?  
✅ Are subproblems reused?  
✅ Does the overall solution depend on smaller ones?  
✅ Can you store results to avoid recomputation?

If it’s all yes — DP it! 🧠🎯

---

Ready to dive into **Pattern 1️⃣: 1D DP** next? 🤓 