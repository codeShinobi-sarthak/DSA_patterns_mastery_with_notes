# 📘 Phase 2: Baby Steps – Basic Recursion Practice

---

## 🔰 Format for Each Problem:
- **Problem Name & Description**
- **Recursive Approach**
- **Base Case + Recursive Case**
- **Java Code**
- **Dry Run or Tree Visualization**

---

### 🧪 Problem 1: Print Numbers from N to 1

**Goal:** Print all numbers from N down to 1 using recursion.

🔍 **Base case:** `if n == 0 return;`  
🔁 **Recursive case:** print n, call with `n - 1`

```java
void printNto1(int n) {
    if (n == 0) return;
    System.out.println(n);
    printNto1(n - 1);
}
```

📊 **Dry Run for `n = 3`:**
```
printNto1(3) → prints 3
printNto1(2) → prints 2
printNto1(1) → prints 1
printNto1(0) → returns
```

---

### 🧪 Problem 2: Print Numbers from 1 to N

Just a reverse of the above problem!

🔍 **Base case:** `if n == 0 return;`  
🔁 **Recursive case:** call with `n - 1`, then print n

```java
void print1toN(int n) {
    if (n == 0) return;
    print1toN(n - 1);
    System.out.println(n);
}
```

💡 *Think of it like going deep first, then printing on the way back up.*

---

### 🧪 Problem 3: Sum of First N Natural Numbers

**Goal:** Return the sum of numbers from 1 to N

🔍 **Base case:** `if n == 0 return 0;`  
🔁 **Recursive case:** `return n + sum(n - 1);`

```java
int sum(int n) {
    if (n == 0) return 0;
    return n + sum(n - 1);
}
```

📊 **Trace for `sum(3)`**
```
sum(3) → 3 + sum(2)
          → 2 + sum(1)
              → 1 + sum(0)
                  → 0
→ Returns: 3 + 2 + 1 + 0 = 6
```

---

### 🧪 Problem 4: Factorial of N

**Goal:** Return factorial of a number `n`

🔍 **Base case:** `if n == 0 return 1;`  
🔁 **Recursive case:** `return n * factorial(n - 1);`

```java
int factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
}
```

---

### 🧪 Problem 5: Fibonacci Number (Nth term)

**Goal:** Return the Nth Fibonacci number  
Sequence: `0, 1, 1, 2, 3, 5, 8, 13, ...`

🔍 **Base case:**
- if `n == 0 return 0`
- if `n == 1 return 1`

🔁 **Recursive case:** `fib(n - 1) + fib(n - 2)`

```java
int fib(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fib(n - 1) + fib(n - 2);
}
```

📛 **Note:** This has **overlapping subproblems** → slow for big `n`. You’ll fix it later with **Memoization (DP)**.

---

### 🧪 Problem 6: Reverse a String

```java
void reverse(String str, int index) {
    if (index == -1) return;
    System.out.print(str.charAt(index));
    reverse(str, index - 1);
}
```

🔁 Recursive case: print current char and call on smaller string.

You can also return a reversed string using:
```java
String reverse(String s) {
    if (s.length() == 0) return "";
    return reverse(s.substring(1)) + s.charAt(0);
}
```

---

### ✅ Phase 2 Progress Checklist

| Problem                       | Status ✅ |
|------------------------------|-----------|
| Print N to 1                 |           |
| Print 1 to N                 |           |
| Sum of N natural numbers     |           |
| Factorial                    |           |
| Fibonacci                    |           |
| Reverse a string             |           |
