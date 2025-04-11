## 🧩 Pattern 2️⃣: **Count Ways DP** — "How Many Ways?" 🧮✨

### 📖 Concept Explanation

This pattern is about:
- 🔢 Counting *possibilities* not *minimums* or *maximums*
- 🤔 Often involves *combinations* of choices
- 💡 Similar to 1D DP but focused on **number of ways** to reach a state

---

### 🔁 Recurrence Relation Format

You typically build a solution like:
> `dp[i] = dp[i - choice1] + dp[i - choice2] + ...`

🎯 The idea: At index `i`, count the number of ways you can get there by trying **all previous valid jumps**.

---

### 🔥 Example Problem 1: **Decode Ways**

📜 **Problem:**  
Given a string of digits representing an encoded message (where 'A' = 1, ..., 'Z' = 26), count how many ways it can be decoded.

🧠 For example, `"12"` can be:
- "AB" (1-2)
- "L" (12)

So 2 ways.

---

### 🧠 Step-by-Step Breakdown

#### ➤ **1. Define Base Cases**
- `dp[0] = 1` (empty string has 1 way)
- `dp[1] = 1` (if first digit ≠ 0)

#### ➤ **2. Transition**
For each index `i`:
- If `s[i-1]` is not `'0'`, then:  
  `dp[i] += dp[i-1]`
- If two digits `s[i-2..i-1]` form a number between 10 and 26:  
  `dp[i] += dp[i-2]`

---

### 💻 Java Code: Decode Ways

```java
public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
    int n = s.length();
    int[] dp = new int[n+1];
    dp[0] = 1; dp[1] = 1;

    for (int i = 2; i <= n; i++) {
        int oneDigit = Integer.parseInt(s.substring(i-1, i));
        int twoDigits = Integer.parseInt(s.substring(i-2, i));

        if (oneDigit >= 1) dp[i] += dp[i-1];
        if (twoDigits >= 10 && twoDigits <= 26) dp[i] += dp[i-2];
    }
    return dp[n];
}
```

---

### 🔥 Example Problem 2: **Coin Change (Count Ways)**

📜 **Problem:**  
You are given `coins[]` and a target amount `n`. Count **how many ways** you can make the amount using the coins **infinite times**.

---

### 🧠 Recurrence Relation

`dp[i] += dp[i - coin]` for all coins  
Build from 0 → n, using each coin one by one.

---

### 💻 Java Code: Coin Change (Count Ways)

```java
public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
        for (int i = coin; i <= amount; i++) {
            dp[i] += dp[i - coin];
        }
    }
    return dp[amount];
}
```

💡 **Why this order?**  
Using each coin fully before moving on to the next avoids duplicates (e.g., 1+2 and 2+1 counted once).

---

### 🧠 Visualization Example (amount = 5, coins = [1, 2, 5])
```
dp[0] = 1
=> after 1: dp = [1,1,1,1,1,1]
=> after 2: dp = [1,1,2,2,3,3]
=> after 5: dp = [1,1,2,2,3,4]
```

🎯 Final answer: 4 ways to make 5

---

### 🪄 Key Tips for Count Ways DP

| 💡 Clue | 🧠 Insight |
|--------|-----------|
| “How many ways…” | You need to **sum** previous sub-results |
| Choices can repeat? | Coin Change → Nested loops |
| Choices must be unique order? | Use DFS or permutations |

---

### 🎯 Real-World Interview Problems

| 🔢 Problem | 💡 Platform |
|-----------|-------------|
| Decode Ways | LeetCode Medium |
| Coin Change II | LeetCode Medium |
| Dice Roll Combinations | LeetCode Medium |
| Staircase (variation) | LeetCode Easy |
| Target Sum | LeetCode Medium |

---

Let’s gooo! 🚀 Ready for **Pattern 3️⃣: Grid DP** 📦➡️📦 next?  
It’s all about navigating 2D grids, paths, and cost optimization. Shall we jump in? 🧭