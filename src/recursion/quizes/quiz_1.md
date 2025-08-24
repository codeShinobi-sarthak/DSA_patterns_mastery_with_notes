### ✅ **RECURSION MINI QUIZ (Phase 1)**

**Q1.** What are the two essential parts of a recursive function?  
a) Base case and infinite loop  
b) Recursive case and base case  
c) Loop and stack  
d) Call and return

---

**Q2.** What happens if a recursive function doesn't have a base case?  
a) It returns 0  
b) It runs once  
c) It causes a StackOverflowError  
d) It prints nothing

---

**Q3.** In the factorial example, what is the base case?

```java
int factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
}
```

a) `n == 1`  
b) `return n * factorial(n - 1);`  
c) `if (n == 0) return 1;`  
d) `return 1;`

---

**Q4.** Which data structure is used internally to manage recursive calls?  
a) Queue  
b) Stack  
c) Heap  
d) Linked List

---

**Q5.** What will be printed by the following code?

```java
void mystery(int n) {
    if (n == 0) return;
    mystery(n - 1);
    System.out.print(n + " ");
}
mystery(3);
```

a) `3 2 1`  
b) `1 2 3`  
c) `3 2 1 0`  
d) `1 2 3 0`