- 🎯 Core bit tricks (because they're fast)
- 🔥 High-yield DSA problems (because they get asked)
- 🧠 Some clever patterns (to surprise the interviewer)

# ✅ **Bit Manipulation List for Interviews**

---

## 🧩 **I. Core Tricks – Must-Know One-Liners** (10/10 must master)

These come up in MCQs, coding rounds, and system questions.

| Trick | What to Know |
|------|--------------|
| ✅ Check Even/Odd | `n & 1 == 0` ➝ Even |
| ✅ Check kth Bit is Set | `(n >> k) & 1` or `(n & (1 << k))` |
| ✅ Set kth Bit | `n | (1 << k)` |
| ✅ Clear kth Bit | `n & ~(1 << k)` |
| ✅ Toggle kth Bit | `n ^ (1 << k)` |
| ✅ Count 1s | Brian Kernighan’s Algorithm |
| ✅ Is Power of Two | `n & (n - 1) == 0` and `n != 0` |
| ✅ Swap Without Temp | `a ^= b; b ^= a; a ^= b` |
| ✅ Turn off rightmost 1 | `n & (n - 1)` |
| ✅ Isolate rightmost 1 | `n & (-n)` |

🎯 Practice a few dry runs on these with small values. You’ll own them like your name. 👑

---

## 🧠 **II. Top DSA Problems – Coding Round & Interview Favs**

| Problem Name | Why it’s 🔥 |
|--------------|-------------|
| ✅ Single Number (LC 136) | XOR magic – `a ^ a = 0` |
| ✅ Single Number II (LC 137) | Bit position count – real test of skill |
| ✅ Number of 1 Bits (LC 191) | Bit counting + edge handling |
| ✅ Counting Bits (LC 338) | Precomputation using DP & bits |
| ✅ Bitwise AND of Range | Observing patterns – tricky |
| ✅ Find Missing Number | XOR from 0 to n vs array |
| ✅ Find Duplicate Number | Bit tricks or Floyd’s cycle |
| ✅ Subset Generation | Classic interview combo |
| ✅ Gray Code | Pattern-based generation (optional) |

💡 **Do at least 7/9** of these. Practice in Leetcode-style format.

---

## 🧬 **III. Optional (for Advanced Candidates & Dream Companies)**

Only explore **if** you want to aim for Google/META-type rounds or enjoy complex bit logic.

| Concept | Use |
|--------|-----|
| ⏳ Bitmask DP | TSP, assign tasks, etc. |
| ♟ Backtracking + Bits | Sudoku + bits, coloring |
| 💼 Subset Sum via Bitmasks | Efficient subset state storage |
| 🌐 Bitmask on Graphs | Hamiltonian path, state compression |

---

# 🧠 TL;DR – The ComboList at a Glance:

✅ **Must Master (10 core tricks)**  
✅ **Do 7–9 key problems (LC 136, 137, 191, 338...)**  
✅ **Explore Bitmask DP if you like Bit manupulation**

---