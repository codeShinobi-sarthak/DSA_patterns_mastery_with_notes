## 📌 **Pattern 1: Sliding Window**
### 🔹 **What is Sliding Window?**
Sliding Window is an **optimization technique** used for problems involving **arrays or strings** where we need to find **contiguous subarrays** or **substrings** that satisfy a condition. Instead of using brute force (`O(n²)`), we use a **window that slides** over the data, reducing time complexity to `O(n)` in most cases.

---

## 🛠 **How It Works**
1. **Initialize a window (start and end pointers)**
2. **Expand the window** by moving the end pointer (`right++`)
3. **Check the condition** (sum, count, etc.)
4. If the condition is **violated**, **shrink the window** by moving the start pointer (`left++`)
5. Repeat until the array/string is fully processed

---

## 🔥 **Example Problem: Maximum Sum Subarray of Size K**
> **Problem:** Given an array `arr` and an integer `K`, find the **maximum sum** of any contiguous subarray of size `K`.

### **🧠 Brute Force Approach (`O(n²)`)**
Check all subarrays of size `K` and find the maximum sum.
```java
public class MaxSumSubarray {
    public static int maxSumBruteForce(int[] arr, int K) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= arr.length - K; i++) {
            int sum = 0;
            for (int j = i; j < i + K; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int K = 3;
        System.out.println(maxSumBruteForce(arr, K)); // Output: 9
    }
}
```
🔴 **Issue:** This takes **O(n²)** time—too slow for large inputs.

---

### **✅ Optimized Sliding Window Approach (`O(n)`)**
- Maintain a **window of size K**
- Add the new element (`right++`) and remove the old element (`left++`)

```java
public class SlidingWindowMaxSum {
    public static int maxSumSlidingWindow(int[] arr, int K) {
        int maxSum = 0, windowSum = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right]; // Add new element

            // When we reach window size K, check max & slide window
            if (right >= K - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[left]; // Remove leftmost element
                left++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int K = 3;
        System.out.println(maxSumSlidingWindow(arr, K)); // Output: 9
    }
}
```
✅ **This Optimized to `O(n)`, much faster!**

---

## 📊 **When to Use Sliding Window?**
| Scenario | Sliding Window? |  
|------------|-----------------|  
| Fixed-size subarrays | ✅ Yes! |  
| Variable-size subarrays | ✅ Yes! |  
| Non-contiguous elements | ❌ No |  
| Finding all subarrays | ❌ No |  

---

## 🎯 **More Problems to Practice**
1️⃣ **Smallest Subarray with Sum ≥ Target**  
2️⃣ **Longest Substring with K Distinct Characters**  
3️⃣ **Fruits in Baskets (Max 2 types of fruits in a row)**  
4️⃣ **Longest Subarray with Sum ≤ Target**
---

Let's **go deeper** and cover **variable-size Sliding Window** next! This will prepare you for **more complex problems** like **longest substrings, smallest subarrays, etc.** 🚀

---

## 📌 **Variable-Size Sliding Window**
Unlike fixed-size, here `the window can expand and shrink dynamically` based on conditions.

---

### **🔥 Example: Smallest Subarray with Sum ≥ Target**
> **Problem:** Given an array `arr` and an integer `targetSum`, find the **length of the smallest contiguous subarray** whose sum is **≥ targetSum**. If no such subarray exists, return `0`.


### **🧠 Brute Force Approach (`O(n²)`)**
- Check `all subarrays` and find the smallest one meeting the condition.

```java
public class SmallestSubarrayBruteForce {
    public static int minSubarrayLength(int[] arr, int targetSum) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int start = 0, sum = 0;

        for (int end = 0; end < n; end++) {
            sum += nums[end];

            // Shrink the window as much as possible while `sum >= target`
            while (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int targetSum = 7;
        System.out.println(minSubarrayLength(arr, targetSum)); // Output: 2
    }
}
```
🔴 **Problem:** Takes **O(n²)** time—too slow for large inputs.

---

### **✅ Optimized Sliding Window Approach (`O(n)`)**
- **Expand window** by adding `right` pointer.
- **Shrink window** when `sum ≥ targetSum`, updating `minLength`.
- **Continue until the entire array is processed.**

```java
public class SmallestSubarraySlidingWindow {
    public static int minSubarrayLength(int[] arr, int targetSum) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0, left = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right]; // Expand window

            while (sum >= targetSum) { // Shrink window if condition met
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left]; // Remove leftmost element
                left++; // Move left forward
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int targetSum = 7;
        System.out.println(minSubarrayLength(arr, targetSum)); // Output: 2
    }
}
```
✅ **Time Complexity:** `O(n)` (efficient!)

---

## 🔥 **Key Differences Between Fixed & Variable Size Sliding Window**
| Feature | Fixed-Size | Variable-Size |
|---------|-----------|--------------|
| Window size | Constant | Changes dynamically |
| Shrinking? | No | Yes |
| Common Use Case | Subarrays of fixed length (e.g., max sum of K elements) | Finding optimal-sized subarrays (e.g., shortest or longest valid window) |
| Complexity | `O(n)` | `O(n)` |

---

## 🎯 **More Problems to Try**
1️⃣ **Longest Substring with At Most K Distinct Characters**  
2️⃣ **Longest Substring Without Repeating Characters**  
3️⃣ **Fruits in Baskets (Max 2 types of fruits in a row)**