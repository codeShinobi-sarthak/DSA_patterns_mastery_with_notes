## 🔢 **Mathematical Proof of Floyd’s Cycle Detection Algorithm**

Let’s assume:
- The **head** of the linked list is `H`.
- The **cycle starts at node X**, which is `d` steps from `H`.
- The **length of the cycle is C**.
- The **slow pointer moves 1 step at a time** and the **fast pointer moves 2 steps at a time**.

---

### 📌 **Step 1: Understanding when Fast & Slow meet**
- Initially, both pointers start from `H`.
- The **fast pointer enters the cycle `d` steps after slow**, since slow moves at half the speed.
- Once inside the cycle, let’s say the **slow pointer moves `x` more steps** before they meet.
- Since the **fast pointer moves twice as fast**, it must have moved `2x` steps during that time.

---

### 📌 **Step 2: Setting Up an Equation**
Since the fast pointer moves `2x` steps and the slow pointer moves `x` steps after entering the cycle, we can say:

\[
\text{Fast pointer's total movement} = d + 2x
\]
\[
\text{Slow pointer's total movement} = d + x
\]

Since both pointers must have completed the same number of cycles inside the loop, the **difference between their distances must be a multiple of the cycle length** `C`.

\[
(d + 2x) - (d + x) = kC
\]

Which simplifies to:

\[
x = kC
\]

This means the **slow pointer will be `k` full cycles behind fast** when they meet.

---

### 📌 **Step 3: Finding the Cycle Start Point**
Once the pointers meet inside the cycle, we reset **one pointer to `H`** and move both **at the same speed (1 step per move)**.

Since the **slow pointer had covered `x` steps inside the cycle**, it still needs **`C - x` steps** to reach the start of the cycle.

At the same time, the pointer starting from `H` has also traveled `d` steps (which is the exact distance to the cycle start).

💡 **Conclusion**: They will meet **at the cycle’s starting node!** 🎯

---

## 🔥 **Summary of the Proof**
1️⃣ Fast moves **twice as fast** as slow, so when they meet, the slow pointer has moved `x` steps inside the cycle.  
2️⃣ Since `x = kC`, this means the slow pointer is `k` cycles behind the fast pointer when they meet.  
3️⃣ Resetting one pointer to `H` and moving both at equal speed guarantees they meet at the **cycle start**.

---

## 🔍 **Key Takeaways**
- **Why does it work?** Because the difference in distances traveled by fast and slow is a multiple of the cycle length.
- **Why reset one pointer to head?** To ensure they meet exactly at the **start of the cycle**.
- **Why move both at equal speed after resetting?** Because they are now equidistant from the cycle start.

