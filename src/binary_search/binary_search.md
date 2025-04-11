# 🔥 **Binary Search Mastery - Let's Begin!** 🔥

Binary Search is a fundamental **divide-and-conquer** algorithm used for efficient searching. Since you want to **master** it, we'll go step by step:

---

## **🟢 Step 1: Standard Binary Search**
### ✅ **Concept**
Binary Search works by repeatedly dividing the **sorted** search space in half until the target element is found.

### 🚀 **Algorithm**
1️⃣ Find the **middle** element of the array.  
2️⃣ If the middle element is the **target**, return its index.  
3️⃣ If the target is **smaller**, search in the **left half**.  
4️⃣ If the target is **greater**, search in the **right half**.  
5️⃣ Repeat until the search space is empty.

### 📌 **Java Implementation**
```java
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoids overflow

            if (arr[mid] == target) return mid; // Found target
            else if (arr[mid] < target) left = mid + 1; // Search right half
            else right = mid - 1; // Search left half
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 5;
        System.out.println("Index of " + target + ": " + binarySearch(arr, target));
    }
}
```
### ⏳ **Time Complexity**
- **Best case:** `O(1)` (if the target is found at the middle)
- **Worst/Average case:** `O(log N)`

---

## **🔹 Next Steps - Variants of Binary Search**
Now that we have covered the basics, let's move to **variants**:  
1️⃣ **Lower Bound** (First occurrence of target or first element greater than target)  
2️⃣ **Upper Bound** (First element greater than target)  
3️⃣ **First & Last Occurrence** of a number  
4️⃣ **Search in a Rotated Sorted Array**  
5️⃣ **Binary Search on Answers** (e.g., Minimize Max Distance, Aggressive Cows)

---

# 🔥 **Binary Search Mastery - All Variants** 🔥

We'll go through **all important binary search variants**, covering their **concepts, Java code, and real-world applications.** Let's break them down step by step. 🚀

---

## **🔵 2. Lower Bound (First occurrence or first greater element)**
### ✅ **Concept**
- Returns **the first position** where the `target` could be inserted **without disrupting the order**.
- If `target` exists, returns **the first occurrence**.
- If `target` is not found, returns **the next greater element’s index**.

### 🔍 **Example**
```java
arr = [1, 3, 3, 5, 7]
target = 3 → Output: 1 (first occurrence)
target = 4 → Output: 3 (first element > 4)
```

### 📌 **Java Code**
```java
public static int lowerBound(int[] arr, int target) {
    int left = 0, right = arr.length;

    while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] >= target) right = mid; // Move left if mid is ≥ target
        else left = mid + 1; // Move right if mid is < target
    }

    return left; // Returns first occurrence or first greater element
}
```

📌 **Time Complexity:** `O(log N)`

---

## **🟣 3. Upper Bound (First element greater than target)**
### ✅ **Concept**
- Returns the **first index where an element is strictly greater** than `target`.
- Used for **counting occurrences**: `(upperBound - lowerBound) = count of target`.

### 🔍 **Example**
```java
arr = [1, 3, 3, 5, 7]
target = 3 → Output: 3 (first element > 3)
target = 4 → Output: 3 (same as lower bound)
```

### 📌 **Java Code**
```java
public static int upperBound(int[] arr, int target) {
    int left = 0, right = arr.length;

    while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] > target) right = mid; // Move left if mid is > target
        else left = mid + 1; // Move right if mid is ≤ target
    }

    return left; // Returns first greater element
}
```

📌 **Time Complexity:** `O(log N)`

---

## **🟠 4. First & Last Occurrence of a Number**
### ✅ **Concept**
- Used to find **where a number first and last appears** in a sorted array.
- Useful in **counting occurrences** in sorted data.

### 🔍 **Example**
```java
arr = [1, 2, 2, 2, 3, 4]
target = 2 → Output: [1, 3] (First at index 1, Last at index 3)
```

### 📌 **Java Code**
```java
public static int firstOccurrence(int[] arr, int target) {
    int left = 0, right = arr.length - 1, ans = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] >= target) {
            if (arr[mid] == target) ans = mid; // Found candidate
            right = mid - 1; // Move left
        } else {
            left = mid + 1;
        }
    }
    return ans;
}

public static int lastOccurrence(int[] arr, int target) {
    int left = 0, right = arr.length - 1, ans = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] <= target) {
            if (arr[mid] == target) ans = mid; // Found candidate
            left = mid + 1; // Move right
        } else {
            right = mid - 1;
        }
    }
    return ans;
}
```

📌 **Time Complexity:** `O(log N)`

---

## **🟡 5. Search in a Rotated Sorted Array**
### ✅ **Concept**
- Given a **rotated** sorted array, find the index of the target.
- Array was **sorted but rotated** at some pivot point.
- Example: `[4, 5, 6, 7, 0, 1, 2]`

### 🔍 **Example**
```java
arr = [4, 5, 6, 7, 0, 1, 2]
target = 0 → Output: 4
```

### 📌 **Java Code**
```java
public static int searchRotated(int[] arr, int target) {
    int left = 0, right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) return mid;

        if (arr[left] <= arr[mid]) { // Left half is sorted
            if (arr[left] <= target && target < arr[mid]) right = mid - 1;
            else left = mid + 1;
        } else { // Right half is sorted
            if (arr[mid] < target && target <= arr[right]) left = mid + 1;
            else right = mid - 1;
        }
    }
    return -1;
}
```

📌 **Time Complexity:** `O(log N)`

---

## **🟢 6. Binary Search on Answers (Advanced Problems)**
### ✅ **Concept**
- Used for problems like **minimum max distance, aggressive cows, or painters partition**.
- Instead of searching for a number in an array, we search for an **answer** in a range.
- Works when we need to **maximize or minimize** something.

### 🔍 **Example - Aggressive Cows**
- Given stalls `[1, 2, 8, 4, 9]`, place `3` cows such that **minimum distance between cows is maximized**.

### 📌 **Java Code**
```java
public static int aggressiveCows(int[] stalls, int cows) {
    Arrays.sort(stalls);
    int left = 1, right = stalls[stalls.length - 1] - stalls[0];
    int ans = 0;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (canPlaceCows(stalls, cows, mid)) {
            ans = mid; // Store max possible distance
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return ans;
}

private static boolean canPlaceCows(int[] stalls, int cows, int minDist) {
    int count = 1, lastPos = stalls[0];

    for (int i = 1; i < stalls.length; i++) {
        if (stalls[i] - lastPos >= minDist) {
            count++;
            lastPos = stalls[i];
            if (count == cows) return true;
        }
    }
    return false;
}
```

📌 **Time Complexity:** `O(N log N)`

---

## 🎯 **Summary**
| **Variant** | **Use Case** |
|------------|------------|
| **Lower Bound** | First occurrence or first greater element |
| **Upper Bound** | First greater element |
| **First/Last Occurrence** | Counting occurrences in sorted data |
| **Rotated Sorted Search** | Finding elements in rotated arrays |
| **Binary Search on Answers** | Optimization problems |