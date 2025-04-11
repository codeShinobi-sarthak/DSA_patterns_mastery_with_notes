
# 🧠 Prefix Sum Pattern (Cumulative Sum)

## 📌 Definition:
**Prefix Sum** is a technique to preprocess an array to get the **sum of elements from index 0 to i** in constant time.

```java
prefixSum[i] = prefixSum[i - 1] + nums[i];
```

---

## 💡 When to Use:
- When you need to find **sum of elements in a range [i, j]** repeatedly.
- When the problem involves **finding subarrays with a given sum**.
- Works best when combined with **HashMap** to store prefix sums and their counts.

---

## ✅ Core Idea: (Important)
 For any subarray `nums[i..j]`, the sum can be calculated as:
```java
 sum(i..j) = prefixSum[j] - prefixSum[i - 1]
```

If `prefixSum[j] - prefixSum[i - 1] == k`, then the subarray from `i` to `j` has sum = `k`.

---

## 🧾 Java Implementation of Prefix Sum:
```java
int[] prefixSum = new int[nums.length + 1];
for (int i = 0; i < nums.length; i++) {
    prefixSum[i + 1] = prefixSum[i] + nums[i];
}
```

---

## 🔥 Prefix Sum + HashMap Trick

Used to count subarrays with a given sum in **O(n)**:

```java
Map<Integer, Integer> map = new HashMap<>();
map.put(0, 1); // base case

int prefixSum = 0, count = 0;
for (int num : nums) {
    prefixSum += num;
    count += map.getOrDefault(prefixSum - k, 0);
    map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
}
```

---

## 🧠 Key Use Cases:
| Use Case                                  | Technique                         |
|-------------------------------------------|-----------------------------------|
| Sum of subarray in O(1)                   | Precompute `prefixSum` array      |
| Count subarrays with sum `k`              | Use prefix sum + HashMap          |
| Longest subarray with sum `k`             | HashMap + store earliest index    |
| 2D prefix sum for submatrices             | Use 2D prefix matrix              |
| Range sum queries                         | Precompute prefix sum             |

---

## ⚠️ Pitfalls to Avoid:
- Don’t forget the base case: `map.put(0, 1)`
- Watch for integer overflow in large arrays
- Prefix sum works for **contiguous subarrays** only
