## 🧠 Phase 3 Quiz – "Recursion with Arrays & Strings"

### ✅ Rules:
- No loops allowed!
- Think in terms of: **base case + recursive call**
- Try in your head first, then write code if stuck

---

### 🧩 Q1: What will this print?

```java
void mystery(int[] arr, int index) {
    if (index == arr.length) return;
    mystery(arr, index + 1);
    System.out.print(arr[index] + " ");
}

int[] arr = {10, 20, 30};
mystery(arr, 0);
```

> A. 10 20 30  
> B. 30 20 10  
> C. 0 1 2  
> D. Nothing (infinite recursion)

---

### 🧩 Q2: What's the base case for checking if an array is sorted?

```java
boolean isSorted(int[] arr, int index) {
    // ??? base case
    return arr[index] < arr[index + 1] && isSorted(arr, index + 1);
}
```

> A. `index == arr.length`  
> B. `index == 0`  
> C. `index == arr.length - 1`  
> D. `index == arr.length - 2`

---

### 🧩 Q3: What’s the result of this function for `reverse("abc")`?

```java
String reverse(String str) {
    if (str.length() == 0) return "";
    return reverse(str.substring(1)) + str.charAt(0);
}
```

> A. "abc"  
> B. "bac"  
> C. "cba"  
> D. "bca"

---

### 🧩 Q4: Which function is best for finding all indices of `target` in array?

> A.
```java
int findIndex(int[] arr, int index, int target)
```

> B.
```java
void findAll(int[] arr, int index, int target, List<Integer> result)
```

> C.
```java
int findAll(int[] arr, int target)
```

> D.
```java
boolean hasIndex(int[] arr, int target)
```

---

### 🧩 Q5: What’s the output of this?

```java
boolean isPalindrome(String s, int start, int end) {
    if (start >= end) return true;
    return s.charAt(start) == s.charAt(end) && isPalindrome(s, start + 1, end - 1);
}

System.out.println(isPalindrome("madam", 0, 4));
```

> A. false  
> B. true  
> C. Error  
> D. infinite recursion
