# 🧠 Phase 4 (part-1) – Backtracking & Recursive Search

> ✅ **Goal:** Learn how to *try all possibilities*, *backtrack when needed*, and *build solutions step-by-step*.  
> This is the core of problems like **N-Queens**, **Sudoku Solver**, and **Combinations**.

---

## 🌱 What is Backtracking?

> "Try → Check → Backtrack → Try Next"

You explore possible solutions using recursion, **undo** the step (backtrack) when the current path fails, and **try other paths**.

> 🧩 Classic structure:
```java
void backtrack(...) {
    if (solution found) return;

    for (choices) {
        make choice
        backtrack
        undo choice // 🔙 backtrack step
    }
}
```

---

## 🧪 Core Problems to Master Backtracking

### 🧩 1. Subsets (Power Set)
📦 Input: `[1, 2, 3]`  
🎯 Output: `[[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]`

```java
void subsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
    if (index == nums.length) {
        result.add(new ArrayList<>(current));
        return;
    }

    // include
    current.add(nums[index]);
    subsets(nums, index + 1, current, result);

    // exclude (Backtrack part)
    current.remove(current.size() - 1);
    subsets(nums, index + 1, current, result);
}
```

---

### 🧩 2. Subset Sum (Find all subset sums)

```java
void subsetSums(int[] arr, int i, int sum, List<Integer> result) {
    if (i == arr.length) {
        result.add(sum);
        return;
    }

    // include
    subsetSums(arr, i + 1, sum + arr[i], result);

    // exclude
    subsetSums(arr, i + 1, sum, result);
}
```

---

### 🧩 3. Generate All Permutations

📦 Input: `[1,2,3]`  
🎯 Output: `[1,2,3], [1,3,2], [2,1,3]...`

```java
void permute(int[] nums, int index, List<List<Integer>> result) {
    if (index == nums.length) {
        List<Integer> perm = new ArrayList<>();
        for (int num : nums) perm.add(num);
        result.add(perm);
        return;
    }

    for (int i = index; i < nums.length; i++) {
        swap(nums, index, i);
        permute(nums, index + 1, result);
        swap(nums, index, i); // backtrack
    }
}
```

---

### 🧩 4. Palindrome Partitioning

📦 Input: `"aab"`  
🎯 Output: `[["a", "a", "b"], ["aa", "b"]]`

```java
void partition(String s, int start, List<String> path, List<List<String>> result) {
    if (start == s.length()) {
        result.add(new ArrayList<>(path));
        return;
    }

    for (int end = start; end < s.length(); end++) {
        String substr = s.substring(start, end + 1);
        if (isPalindrome(substr)) {
            path.add(substr);
            partition(s, end + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
```

---

## 👑 Bonus Challenges (Once You’re Confident)

- 🔥 **N-Queens Problem**
- 🔥 **Sudoku Solver**
- 🔥 **Word Search**
- 🔥 **Combination Sum**
- 🔥 **Rat in a Maze**

---

## 📊 Phase 4 Checklist

| Problem                        | Done? ✅ |
|-------------------------------|----------|
| Subsets (Power Set)           |          |
| Subset Sums                   |          |
| All Permutations              |          |
| Palindrome Partitioning       |          |
| Combination Sum               |          |
| N-Queens / Sudoku / Maze      |          |

---