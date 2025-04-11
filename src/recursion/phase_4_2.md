# 🧠 Phase 4 (part-2) –  Recursion in Trees & Linked Lists

> ✅ **Goal:** Learn how recursion powers tree traversal, depth calculations, path finding, and recursive manipulation of linked lists.

---

## 🧠 Part 1: **Tree Recursion Patterns**

### 🔹 Pattern 1: DFS Traversals (Preorder, Inorder, Postorder)

```java
// Inorder: Left → Node → Right
void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
```

- ✅ Preorder → `Node → Left → Right`
- ✅ Postorder → `Left → Right → Node`

---

### 🔹 Pattern 2: Find Height (Max Depth)

```java
int height(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(height(root.left), height(root.right));
}
```

📌 Pattern: **Bottom-up recursion**  
💡 Key: Return value bubbles up from the children.

---

### 🔹 Pattern 3: Count Paths / Path Sum / Root-to-Leaf

```java
boolean hasPathSum(TreeNode root, int target) {
    if (root == null) return false;
    if (root.left == null && root.right == null) return root.val == target;
    
    return hasPathSum(root.left, target - root.val) ||
           hasPathSum(root.right, target - root.val);
}
```

📌 Pattern: **Top-down decision making**, no return value building (in simpler form).

---

### 🔹 Pattern 4: Lowest Common Ancestor (LCA)

```java
TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;

    TreeNode left = lca(root.left, p, q);
    TreeNode right = lca(root.right, p, q);

    if (left != null && right != null) return root; // current is LCA
    return left != null ? left : right;
}
```

📌 **Divide and conquer** with return values.

---

## 🔗 Part 2: **Linked List Recursion Patterns**

### 🔹 Pattern 1: Reverse a Linked List Recursively

```java
ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode newHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
}
```

🧠 **Recursive unwinding** does the reversal magic.

---

### 🔹 Pattern 2: Find Mid Node (Helper for Rec Merge Sort)

```java
ListNode findMid(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```

📌 Used in **Divide & Conquer** patterns.

---

### 🔹 Pattern 3: Merge Two Sorted Linked Lists (Recursively)

```java
ListNode merge(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    
    if (l1.val < l2.val) {
        l1.next = merge(l1.next, l2);
        return l1;
    } else {
        l2.next = merge(l1, l2.next);
        return l2;
    }
}
```

💡 You can use this as part of **Merge Sort** too.

---

### 🔹 Pattern 4: Check Palindrome (Recursive Two Pointer)

```java
ListNode frontPointer;

boolean isPalindrome(ListNode head) {
    frontPointer = head;
    return recursivelyCheck(head);
}

boolean recursivelyCheck(ListNode current) {
    if (current == null) return true;
    if (!recursivelyCheck(current.next)) return false;
    boolean isEqual = (current.val == frontPointer.val);
    frontPointer = frontPointer.next;
    return isEqual;
}
```

🔥 Classic recursive technique using stack-like behavior.

---

## ✅ Phase 5 Checklist

| Pattern                              | Mastered? ✅ |
|--------------------------------------|--------------|
| Tree Traversals (in/pre/post)        |              |
| Max Depth / Height                   |              |
| Root-to-leaf Path / Path Sum         |              |
| Lowest Common Ancestor (LCA)         |              |
| Reverse Linked List (Recursive)      |              |
| Merge Two Sorted Lists               |              |
| Find Middle Node (LL)                |              |
| Palindrome Check in LL               |              |

