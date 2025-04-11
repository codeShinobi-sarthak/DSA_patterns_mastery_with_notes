### **Monotonic Stack - The Ultimate Pattern for Range Queries** 🚀

#### **What is a Monotonic Stack?**

A **Monotonic Stack** is a stack that maintains its elements in either **increasing** or **decreasing** order. It is
mainly used in problems where we need to find **next/previous greater/smaller elements** efficiently.

#### **Why Use Monotonic Stacks?**

👉 Helps solve **range queries** efficiently in **O(n)** instead of **O(n²)** (like brute force).  
👉 Used in problems involving **spans, temperatures, stock prices, and histogram areas**.  
👉 Useful when solving **next/previous greater or smaller elements**.

---

## **🔹 Types of Monotonic Stacks**

1. **Increasing Monotonic Stack** (Maintains elements in increasing order)
    - Used to find **Next Greater Element (NGE)**
    - Used to find **Previous Smaller Element (PSE)**

2. **Decreasing Monotonic Stack** (Maintains elements in decreasing order)
    - Used to find **Next Smaller Element (NSE)**
    - Used to find **Previous Greater Element (PGE)**

---

## **🔹 Key Idea of Monotonic Stack**

We use a stack to **store indices** instead of values and maintain the order by **popping elements that violate
monotonicity**.

---

## **🔹 Common Problems Using Monotonic Stack**

### **1️⃣ Next Greater Element (NGE) - Right**

#### **Problem Statement:**

Given an array, find the **next greater element** for each element.

🔹 **Example:**

```
Input:  [2, 1, 5, 6, 2, 3]
Output: [5, 5, 6, -1, 3, -1]
```

🔹 **Explanation:**  
For each element, find the next greater element on the right. If none exists, return `-1`.

🔹 **Java Solution:**

```java
import java.util.*;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {  // Traverse from right to left
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();  // Remove smaller elements
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek(); // Store the next greater element
            stack.push(nums[i]);  // Push the current element to the stack
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        System.out.println(Arrays.toString(nextGreaterElement(nums)));
    }
}
```

✅ **Time Complexity:** **O(n)** (Each element is pushed and popped at most once)  
✅ **Space Complexity:** **O(n)** (Stack usage)

---

### **2️⃣ Next Smaller Element (NSE) - Right**

#### **Problem Statement:**

Find the **next smaller element** for each element.

🔹 **Example:**

```
Input:  [4, 5, 2, 10, 8]
Output: [2, 2, -1, 8, -1]
```

🔹 **Java Solution:**

```java
public class NextSmallerElement {
    public static int[] nextSmallerElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nextSmallerElement(nums)));
    }
}
```

✅ **Time Complexity:** **O(n)**  
✅ **Space Complexity:** **O(n)**

---

## **🔹 Summary of Monotonic Stack**

| Problem                        | Stack Order | Traversal Direction |
|--------------------------------|-------------|---------------------|
| Next Greater Element           | Decreasing  | Right to Left       |
| Next Smaller Element           | Increasing  | Right to Left       |
| Previous Greater Element       | Decreasing  | Left to Right       |
| Previous Smaller Element       | Increasing  | Left to Right       |
| Largest Rectangle in Histogram | Increasing  | Left to Right       |

---

### **🚀 Pro Tip for Monotonic Stack**

- **Use a stack of indices**, not values! This allows you to track **positions** efficiently.
- **Think in reverse:** If you need the **next greater element**, traverse **from right to left**.
- **Stack stores potential answers**, and we remove elements that are no longer useful.