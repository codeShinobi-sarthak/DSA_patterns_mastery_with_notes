## 🧩 Pattern 4️⃣: **2D DP with Two Sequences** — “Compare, Match, Modify” 📘📘

---

### 📖 Concept Explanation

This pattern deals with **two sequences** (usually strings or arrays), and the goal is often to:
- ✅ Compare them
- 🔁 Transform one into another
- 🔍 Find similarity or difference

🧠 **Key Observations:**
- Problems often need a **2D DP table**, where `dp[i][j]` means:
  ➤ *Best result for first `i` chars of A and first `j` chars of B*

---

### 🔥 Common Problem Types:
| 💥 Task | 🧩 Example |
|--------|-----------|
| 🔗 Longest common structure | LCS, LCSubstring |
| ✂️ Minimum edits to match | Edit Distance |
| 🧼 String compression | Shortest Common Supersequence |
| 🔄 Transform A → B | Min Insert/Delete to Convert |

---

### 🔥 Example Problem 1: **Longest Common Subsequence (LCS)**

📜 **Problem:**  
Given two strings `text1` and `text2`, return the length of their longest subsequence that appears in both.

---

### 🧠 Recurrence Relation

If `text1[i-1] == text2[j-1]`:
> `dp[i][j] = 1 + dp[i-1][j-1]`

Else:
> `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`

---

### 💻 Java Code – LCS

```java
public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length(), n = text2.length();
    int[][] dp = new int[m+1][n+1];

    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (text1.charAt(i-1) == text2.charAt(j-1))
                dp[i][j] = 1 + dp[i-1][j-1];
            else
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
    }
    return dp[m][n];
}
```

---

### 🔥 Example Problem 2: **Edit Distance**

📜 **Problem:**  
Convert word1 to word2 using:
- Insert
- Delete
- Replace  
  Find the **minimum operations** needed.

---

### 🧠 Recurrence Relation

If characters match:
> `dp[i][j] = dp[i-1][j-1]`

Else:
> `dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])`  
(delete, insert, replace)

---

### 💻 Java Code – Edit Distance

```java
public int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] dp = new int[m+1][n+1];

    for (int i = 0; i <= m; i++) dp[i][0] = i;
    for (int j = 0; j <= n; j++) dp[0][j] = j;

    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (word1.charAt(i-1) == word2.charAt(j-1))
                dp[i][j] = dp[i-1][j-1];
            else
                dp[i][j] = 1 + Math.min(
                    dp[i-1][j-1], // replace
                    Math.min(dp[i][j-1], // insert
                             dp[i-1][j]) // delete
                );
        }
    }
    return dp[m][n];
}
```

---

### 🎯 Real Interview Problems

| 📌 Problem | 🔗 Platform |
|-----------|-------------|
| Longest Common Subsequence | LeetCode Medium |
| Edit Distance | LeetCode Hard |
| Shortest Common Supersequence | GFG |
| Delete Operation for Two Strings | LeetCode Medium |
| Longest Palindromic Subsequence | LeetCode Medium |

---

### 💡 Pro Tips

| 🧠 Insight | 🛠️ What it means |
|------------|-----------------|
| Subsequence ≠ Substring | Subsequence = skip allowed |
| Matching = Diagonal move ↘️ | `dp[i-1][j-1] + 1` |
| Mismatch = Look in all directions | Up, Left, Diagonal |

---

### 🪄 Bonus: Space Optimization

Since we only need the **previous row**, you can shrink the space to `O(n)`

```java
int[] prev = new int[n+1];
int[] curr = new int[n+1];
// fill dp using only prev and curr
```

---

# 👀 Visual Representation: **LCS of "abcde" and "ace"**

---

### 🧩 Problem Recap
We want to find the **Longest Common Subsequence** between:
- `text1 = "abcde"`
- `text2 = "ace"`

👉 Expected LCS: `"ace"` → length = **3**

---

### 🔠 DP Table Structure (6 x 4)

We’ll build a table `dp[i][j]`, where:
- `i` = characters from `"abcde"` (row)
- `j` = characters from `"ace"` (column)
- `dp[i][j]` = length of LCS of `text1[0..i-1]` and `text2[0..j-1]`

🧱 We include one extra row & column for base cases (empty string).

```
      ""  a  c  e
   ----------------
"" |  0  0  0  0
a  |  0  1  1  1
b  |  0  1  1  1
c  |  0  1  2  2
d  |  0  1  2  2
e  |  0  1  2  3
```

---

### 🧠 How it fills:

- At `dp[1][1]`, we match `'a' == 'a'` → `dp[0][0] + 1 = 1`
- At `dp[3][2]`, we match `'c' == 'c'` → `dp[2][1] + 1 = 2`
- At `dp[5][3]`, we match `'e' == 'e'` → `dp[4][2] + 1 = 3`

If not matching, we take the max of:
- `dp[i-1][j]` (top)
- `dp[i][j-1]` (left)

---

### 🔁 Final LCS = **3**

Backtracking from `dp[5][3]`:
- `'e'` matches
- move diagonally to `dp[4][2]`
- `'c'` matches
- move diagonally to `dp[2][1]`
- `'a'` matches  
  → So LCS = `"ace"`

---

### 🎨 Colored Example (for visualization tools or note-making)

You can imagine coloring matches diagonally (↘️) like this:

```
      ""   a   c   e
    ----------------
"" |  0   0   0   0
a  |  0  [1]  1   1
b  |  0   1   1   1
c  |  0   1  [2]  2
d  |  0   1   2   2
e  |  0   1   2  [3]
```

Green boxes = matched characters → they contributed to LCS 📗

---

### 🧠 Takeaway

- **Rows = `text1`, Columns = `text2`**
- Fill the table top-to-bottom, left-to-right
- Base case = `dp[0][*] = 0`, `dp[*][0] = 0`
- When characters match → move diagonally +1
- When they don’t → take max of left or top