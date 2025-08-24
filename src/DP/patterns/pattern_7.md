
# 🧱 Pattern 7: **Partition DP** — *Divide and Conquer Intelligently!* 🧠✂️

---

## 🧩 What is Partition DP?

These problems involve:

* Breaking things **into segments or partitions**
* Making **decisions at each partition**
* Solving subproblems on those partitions

🧠 Common in problems like:

* **Palindrome Partitioning**
* **Boolean Parenthesization**
* **MCM (Matrix Chain Multiplication)**

---

## 🔥 Common Characteristics

| Feature           | Details                                                     |
| ----------------- | ----------------------------------------------------------- |
| 🎯 Goal           | Minimize/Maximize number of operations/ways                 |
| ➗ Partition Point | Try every `k` in range (like `i to j`)                      |
| 🧠 State          | Typically 2D: `dp[i][j]` = result for subarray `i to j`     |
| 🔄 Recurrence     | Loop over `k`, combine results of `dp[i][k]` & `dp[k+1][j]` |

---

## 🎓 Classic Problem: **Palindrome Partitioning II**

**🧠 Problem:**
Given a string `s`, partition it into the **fewest** cuts such that every substring is a palindrome.

**Example:**
`s = "aab"` → Output: `1` (since `"aa|b"`)

---

### 🧠 Recurrence Relation

Let’s define:

* `dp[i]` = min cuts needed for substring `s[0..i]`

Check all `j` from `0 to i`:

* If `s[j..i]` is a palindrome → `dp[i] = min(dp[i], dp[j-1] + 1)`

Base:

```java
dp[i] = 0 if s[0..i] is palindrome
```

---

### 💻 Java Code (Optimized)

```java
public int minCut(String s) {
    int n = s.length();
    int[] dp = new int[n];
    boolean[][] isPal = new boolean[n][n];

    for (int i = 0; i < n; i++) {
        int minCut = i;
        for (int j = 0; j <= i; j++) {
            if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPal[j + 1][i - 1])) {
                isPal[j][i] = true;
                minCut = (j == 0) ? 0 : Math.min(minCut, dp[j - 1] + 1);
            }
        }
        dp[i] = minCut;
    }
    return dp[n - 1];
}
```

---

### 🎯 Other Partition DP Problems

| 🧩 Problem                  | 🔥 Idea                                        |
| --------------------------- | ---------------------------------------------- |
| Palindrome Partitioning I   | Return all valid palindrome partitions         |
| Boolean Parenthesization    | Count # of ways to parenthesize to get True    |
| Evaluate Expression to True | Variant of above                               |
| Minimum Cost to Cut a Stick | Pick best cut position                         |
| Burst Balloons              | Pick which balloon to burst last! 🎈           |
| Scrambled Strings           | Check if a string is scrambled form of another |

---

### 📊 Table Visualization

Imagine you’re filling a 2D `dp[i][j]` table for substrings —
Each cell holds the result for `s[i..j]`, and you try all possible `k` partitions within.

---

## 📌 Summary

| 🔍 Concept                 | 💡 Insight                             |
| -------------------------- | -------------------------------------- |
| Try every partition        | for `k = i to j-1`                     |
| Use sub-results            | Combine `dp[i][k]` & `dp[k+1][j]`      |
| Palindrome check?          | Precompute using `isPal[][]`           |
| Works for math and strings | Cutting problems, boolean strings, etc |

---