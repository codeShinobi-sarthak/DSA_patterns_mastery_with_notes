# 🚀 Two Pointers

The **Two Pointers** technique is an optimization strategy where you use two pointers to traverse an array (or linked list) efficiently instead of using nested loops.

---
## 🧠 What is the Two Pointers Technique?

#### It involves placing two pointers at different positions in a data structure and moving them strategically based on the problem’s conditions. This technique is mainly used in sorted arrays or linked lists to reduce the time complexity from O(n²) to O(n).

🔹 Types of Two Pointers:

1) **Opposite Ends (Start & End)** → Used in problems like Two Sum in Sorted Array or Palindrome Checking

2) **Same Direction (Slow & Fast)** → Used in Removing Duplicates, Finding Cycle in Linked Lists, Sliding Window, etc.

---

## 📌 **When to Use Two Pointers?**
✅ **Sorted Arrays or Linked Lists**  
✅ **Finding Pairs/Sums (e.g., Two Sum, Three Sum, etc.)**  
✅ **Reversing or Rotating Arrays**  
✅ **Merging Two Sorted Lists/Arrays**  
✅ **Removing Duplicates In-Place**

---

### 🔥 **Example 1: Two Sum in Sorted Array (Using Two Pointers)**
> **Problem:** Given a **sorted** array `arr[]` and a target sum `target`, find two numbers whose sum equals `target`.

#### ❌ **Brute Force Approach (O(n²))**
- Use **nested loops** to check all pairs. **Inefficient!**

#### ✅ **Optimized Approach (O(n)) – Two Pointers**
1. Place **one pointer at the start (`left`)** and another at the **end (`right`)**.
2. If `arr[left] + arr[right] == target`, return indices.
3. If the sum is **too small**, move `left` forward to increase it.
4. If the sum is **too large**, move `right` backward to decrease it.

```java
public class TwoSumSorted {
    public static int[] twoSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) return new int[]{left, right};
            else if (sum < target) left++;  // Need a bigger sum
            else right--; // Need a smaller sum
        }
        return new int[]{-1, -1}; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        int target = 6;
        int[] result = twoSum(arr, target);
        System.out.println(Arrays.toString(result)); // Output: [1, 3] (2 + 4 = 6)
    }
}
```
✅ **Time Complexity:** `O(n)` (Single pass, no nested loops!)  
✅ **Space Complexity:** `O(1)` (In-place, no extra space needed)

---

### 🔥 **Example 2: Removing Duplicates from a Sorted Array (In-Place)**
> **Problem:** Remove duplicates from a **sorted** array in **O(n)** time without extra space.

#### ✅ **Optimized Two Pointers Approach**
1. Use **one pointer (`i`) for placing unique elements**.
2. Use **another pointer (`j`) to scan the array**.
3. Whenever a **new unique element** is found, place it in the correct position.

```java
public class RemoveDuplicates {
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;

        int i = 0; // Pointer for unique elements

        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++; // Move to the next position
                arr[i] = arr[j]; // Place the new unique element
            }
        }
        return i + 1; // New array length
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5};
        int newLength = removeDuplicates(arr);
        System.out.println(newLength); // Output: 5 (Unique elements: {1,2,3,4,5})
    }
}
```
✅ **Time Complexity:** `O(n)` (Single pass)  
✅ **Space Complexity:** `O(1)` (Modified in-place)

---

### 🎯 **More Problems to Try**
1️⃣ **Three Sum (Find all triplets that sum to zero)**  
2️⃣ **Move Zeroes to End (Without changing order of elements)**  
3️⃣ **Reverse a String (Using Two Pointers in-place)**