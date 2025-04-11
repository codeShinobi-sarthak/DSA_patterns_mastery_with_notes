# 📘 Phase 1: Core Foundations of Recursion

## 🧩 1. What is Recursion?

**Definition:**
Recursion is a technique where a function **calls itself** to solve a smaller version of the original problem.

> “Break big problems into smaller, easier-to-solve sub-problems.”

**Real-life example:**
Imagine opening a box, and inside is another box… and so on. You keep opening boxes until you find the one with the gift 🎁 (base case), then close all the boxes back up (returning phase).

---

## 🧠 2. Anatomy of a Recursive Function

Every recursive function must have **two essential parts**:

| Part         | Meaning                                                      |
|--------------|--------------------------------------------------------------|
| ✅ Base Case  | The condition to stop recursion (the simplest input)        |
| 🔁 Recursive Case | The part where the function calls itself with a smaller input |

### 📌 Example: Factorial of N
```java
int factorial(int n) {
    if (n == 0) return 1;              // ✅ Base Case
    return n * factorial(n - 1);       // 🔁 Recursive Case
}
```

---

## 🧱 3. How Recursion Works Internally (Stack)

Every recursive call is pushed onto the **call stack**. When a base case is reached, functions start **returning** (unwinding the stack).

### 🧠 Think Like a Stack:
```text
factorial(3)
→ 3 * factorial(2)
    → 2 * factorial(1)
        → 1 * factorial(0)
            → returns 1
        → returns 1
    → returns 2
→ returns 6
```

💡 **LIFO** (Last In, First Out): Last function called is the first to complete.

---

## 🧨 4. Infinite Recursion & Stack Overflow

⚠️ If there's **no base case** or it’s not reachable, the function keeps calling itself → causes a **StackOverflowError** in Java!

```java
int recurse(int n) {
    return recurse(n - 1); // ❌ No base case
}
```

---

## 🌟 5. Recursive Mindset

Ask yourself:
- Can I divide this problem into smaller parts?
- What's the simplest version of this problem (base case)?
- Is the recursive call moving toward the base case?

---

## 🛠️ 6. Try This Exercise (Dry Run on Paper)

### Print numbers from N to 1 using recursion:
```java
void printNto1(int n) {
    if (n == 0) return;
    System.out.println(n);
    printNto1(n - 1);
}
```

Try for `n = 3`. ✍️ Trace on paper:
```
printNto1(3)
→ print 3
→ print 2
→ print 1
→ return
```

---

### ✅ Checklist Summary
| Task                                 | Done |
|--------------------------------------|------|
| Understand base + recursive case     | ✅  |
| Learn stack behavior                 | ✅  |
| Practice dry runs on paper           | ✅  |
| Avoid infinite recursion             | ✅  |
| Build recursive mindset              | ✅  |

---