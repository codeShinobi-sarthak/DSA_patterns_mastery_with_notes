## ⭐ Template 1: **Subsequence Pattern**

> Used when you need to include/exclude elements — classic recursion intro!

### 🧩 Core Structure:
```java
void solve(int index, List<Integer> current, int[] arr) {
    if (index == arr.length) {
        System.out.println(current);
        return;
    }

    // Pick the element
    current.add(arr[index]);
    solve(index + 1, current, arr);

    // Backtrack
    current.remove(current.size() - 1);

    // Do NOT pick the element
    solve(index + 1, current, arr);
}
```

### 🔥 Used In:
- All Subsequences
- Subset Sums
- Count number of subsequences with sum `k`
- Can be converted into DP with memoization later

---

## ⭐ Template 2: **Pick / Not Pick with Return Type (Functional Style)**

> Return-type version of subsequence for problems like:
> “Return all subsequences with sum X”, “Return subsets of a string”, etc.

### 🧩 Core Structure:
```java
List<List<Integer>> solve(int index, int[] arr, List<Integer> current) {
    if (index == arr.length) {
        List<List<Integer>> base = new ArrayList<>();
        base.add(new ArrayList<>(current));
        return base;
    }

    // Pick
    current.add(arr[index]);
    List<List<Integer>> left = solve(index + 1, arr, current);
    current.remove(current.size() - 1);

    // Not Pick
    List<List<Integer>> right = solve(index + 1, arr, current);

    left.addAll(right); // Merge results
    return left;
}
```

### 🔥 Used In:
- Return all subsequences
- Power set
- Count/print/return variants
- Palindromic partitions (modified)

---

## ⭐ Template 3: **Tree Recursion (Backtracking Style)**

> The ultimate recursive tool: Used in permutations, N-Queens, Sudoku, etc.

### 🧩 Core Structure:
```java
void solve(List<Integer> current, boolean[] used, int[] nums) {
    if (current.size() == nums.length) {
        System.out.println(current);
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        if (used[i]) continue;

        // Choose
        current.add(nums[i]);
        used[i] = true;

        // Recurse
        solve(current, used, nums);

        // Backtrack
        current.remove(current.size() - 1);
        used[i] = false;
    }
}
```

### 🔥 Used In:
- Permutations
- Combination Sum
- N-Queens
- Sudoku
- Path Finding in grid/maze

---

## ✅ Phase 5 – Final Recap

| Template                               | Real Use Cases |
|----------------------------------------|----------------|
| ✅ Subsequence Pattern                 | Subsets, Sums, DP |
| ✅ Pick/Not Pick with Return          | Functional Recursion, Power Set |
| ✅ Tree Recursion with Backtracking   | Permutations, N-Queens, Grid Paths |
