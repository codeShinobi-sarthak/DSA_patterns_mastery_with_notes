# Dynamic Programming: Partition DP

The **Partition DP** pattern is used for problems where you need to find an optimal way to partition a sequence by making a series of "cuts."



***

## The Core Idea 🧱

The core idea is to solve a problem on a sequence `[i...j]` by trying every possible position `k` to make a partition (or a "cut") between `i` and `j`. The solution for `[i...j]` is then derived by combining the solutions of the subproblems `[i...k]` and `[k+1...j]`.

**Analogy**: Imagine you have a long wooden rod that you need to cut into pieces. The cost of cutting varies depending on where you make the cut. To find the cheapest way to cut the entire rod, you would consider every possible location for your *first* cut. After making a cut, you're left with two smaller rods, each with its own optimal cutting strategy. Partition DP systematically explores all these cutting choices to find the absolute best one.

***

## How to Identify It

Look for problems with these characteristics:
* **Keywords**: "partition," "split," "divide," "parenthesization."
* **Problem Structure**: You are given a sequence (like a string or an array) and asked to find an optimal value (minimum cost, maximum profit, number of ways) by breaking it into contiguous parts.
* **Recursive Formulation**: The problem can be naturally expressed by asking, "If I make a split at position `k`, what's the combined result of optimally solving the left part and the right part?"

***

## The State & Recurrence Relation

This is the heart of the pattern.

* **The State**: A subproblem is almost always defined by a start index `i` and an end index `j`. The DP state is typically `dp[i][j]`, representing the optimal solution for the sequence from index `i` to `j`.
* **The Recurrence Relation**: To calculate `dp[i][j]`, you iterate through all possible partition points `k` between `i` and `j-1`. The recurrence looks something like this:
    ```
    dp[i][j] = min/max/sum over k from i to j-1 { dp[i][k] + dp[k+1][j] + cost_of_this_partition }
    ```
  The `cost_of_this_partition` is specific to the problem.

***

## Classic Problems

### Palindrome Partitioning (Minimum Cuts)
* **Problem**: Find the minimum number of cuts needed to partition a string so that every part is a palindrome.
* **State**: `dp[i]` = the minimum number of cuts needed for the prefix of the string of length `i`.
* **Recurrence**: `dp[i] = min(dp[j-1] + 1)` for all `j <= i` where the substring `s[j-1...i-1]` is a palindrome. You typically pre-compute a table that tells you if any substring `s[i...j]` is a palindrome.

### Boolean Parenthesization
* **Problem**: Given a boolean expression like `T^F|T`, find the number of ways to place parentheses so that the expression evaluates to `true`.
* **State**: `dp[i][j][isTrue]`, representing the number of ways the sub-expression `s[i...j]` can be parenthesized to evaluate to the boolean `isTrue`.
* **Recurrence**: Iterate through all operators `k` in the range. For each operator, combine the results from the left subproblem (`dp[i][k-1]`) and the right subproblem (`dp[k+1][j]`).

***

## Complexity & Common Pitfalls

### Complexity Analysis
* **Time Complexity**: Typically **O(N³)**. The three nested loops are for the length of the substring, the start index `i`, and the partition point `k`.
* **Space Complexity**: **O(N²)** for the 2D DP table to store the results of all subproblems `dp[i][j]`.

### Common "Gotchas" & Pitfalls
* ⚠️ **Incorrect Loop Structure**: The standard way to implement Partition DP is to iterate based on the **length** of the substring, from smallest (1) to largest (N). This ensures that when you compute `dp[i][j]`, the solutions for all smaller subproblems have already been calculated.
* ⚠️ **Off-by-One Errors**: Managing the indices `i`, `j`, and the partition point `k` is very tricky and prone to errors.
* ⚠️ **Forgetting the Combination Cost**: In some problems (like Matrix Chain Multiplication), there is an additional cost for combining the two results, which must be included in the recurrence.