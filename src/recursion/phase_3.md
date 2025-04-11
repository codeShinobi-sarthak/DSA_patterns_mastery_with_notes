# 🌟 Phase 3: Recursion with Arrays & Strings

> ✅ **Goal:** Learn how to use recursion for traversing and solving problems on arrays and strings (without using loops!).  
This builds your *pattern recognition* and gets you ready for backtracking later.

---

## 🎯 Key Skills in This Phase

- How to pass and modify arrays/strings recursively
- How to track indices and results
- How to build logic without using loops

---

## 🧪 Problem Set

### 🧩 1. Print Elements of an Array

**Given:** `arr = {1, 2, 3, 4}`  
**Task:** Print all elements recursively

```java
void printArray(int[] arr, int index) {
    if (index == arr.length) return;
    System.out.println(arr[index]);
    printArray(arr, index + 1);
}
```

---

### 🧩 2. Find Maximum Element in Array

```java
int maxInArray(int[] arr, int index) {
    if (index == arr.length - 1) return arr[index];
    return Math.max(arr[index], maxInArray(arr, index + 1));
}
```

---

### 🧩 3. Check if Array is Sorted (Strictly Increasing)

```java
boolean isSorted(int[] arr, int index) {
    if (index == arr.length - 1) return true;
    return arr[index] < arr[index + 1] && isSorted(arr, index + 1);
}
```

---

### 🧩 4. Linear Search (Find target in array)

```java
boolean linearSearch(int[] arr, int index, int target) {
    if (index == arr.length) return false;
    if (arr[index] == target) return true;
    return linearSearch(arr, index + 1, target);
}
```

---

### 🧩 5. All Indices of a Target in Array

```java
void findAllIndices(int[] arr, int index, int target, List<Integer> result) {
    if (index == arr.length) return;
    if (arr[index] == target) result.add(index);
    findAllIndices(arr, index + 1, target, result);
}
```

---

### 🧩 6. Reverse a String Recursively (in-place if possible)

```java
String reverse(String str) {
    if (str.length() <= 1) return str;
    return reverse(str.substring(1)) + str.charAt(0);
}
```

🧠 *Challenge:* Try reversing a `char[]` in-place using a helper method with `start` and `end` pointers.

---

## 📝 Bonus Challenge: Palindrome Check (String)

```java
boolean isPalindrome(String str, int start, int end) {
    if (start >= end) return true;
    return str.charAt(start) == str.charAt(end) &&
           isPalindrome(str, start + 1, end - 1);
}
```

---

## 📊 Phase 3 Progress Checklist

| Problem                                | Status ✅ |
|----------------------------------------|-----------|
| Print array elements                   |           |
| Max in array                           |           |
| Check if array is sorted               |           |
| Linear search                          |           |
| Find all indices                       |           |
| Reverse string                         |           |
| Palindrome check (bonus)              |           |

---

# Now to Quiz-2