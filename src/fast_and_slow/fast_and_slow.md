# 🏁 **Fast & Slow Pointers (Tortoise and Hare Algorithm)**

---
## 🧠 **What is the Fast & Slow Pointers Technique?**
Fast & Slow Pointers, also known as the **Tortoise and Hare Algorithm**, is a technique where:
- One pointer (**slow**) moves **one step at a time**
- Another pointer (**fast**) moves **two steps at a time**

This technique is mainly used for **cycle detection** in **linked lists** and **finding the middle node** efficiently.

---

## 🎯 **Where is Fast & Slow Pointers Used?**
| Use Case | Example Problems |
|----------|----------------|
| **Cycle Detection** | Detect Cycle in a Linked List (Floyd’s Algorithm) |
| **Finding Middle of a List** | Find Middle Node of a Linked List |
| **Palindrome Check** | Check if a Linked List is a Palindrome |
| **Rearranging Elements** | Reordering a List |

---

## 🔍 **How Fast & Slow Pointers Work?**
- If there is **no cycle**, the fast pointer reaches `null` first.
- If there **is a cycle**, the fast pointer will **eventually catch up** to the slow pointer, proving the cycle.

---

## 🔵 **Example 1: Detecting a Cycle in a Linked List**
### 💡 **Problem Statement**
> Given a linked list, determine if it contains a cycle.

### ✅ **Optimized Approach (O(n) Time & O(1) Space)**
```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; this.next = null; }
}

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // Moves one step
            fast = fast.next.next;  // Moves two steps

            if (slow == fast) return true; // Cycle detected
        }
        return false; // No cycle
    }
}
```
✅ **Time Complexity:** `O(n)`  
✅ **Space Complexity:** `O(1)`

---

## 🔵 **Example 2: Finding the Middle Node of a Linked List**
### 💡 **Problem Statement**
> Given a linked list, find the middle node.

### ✅ **Optimized Approach (O(n) Time & O(1) Space)**
```java
public class MiddleOfLinkedList {
    public static ListNode findMiddle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;      // Moves one step
            fast = fast.next.next; // Moves two steps
        }
        return slow; // Slow pointer will be at the middle
    }
}
```
✅ **Time Complexity:** `O(n)`  
✅ **Space Complexity:** `O(1)`