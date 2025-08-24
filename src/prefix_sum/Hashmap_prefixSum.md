# 🔥 HashMap + Subarray + Prefix Count with K

> **"A clever way to count what's behind, so we can conquer what's ahead."**

---

## 📜 Pattern Summary

This pattern helps us **count subarrays with a specific property** (like a sum or number of odds) using:
- A **prefix count** (running tally of some property).
- A **HashMap** to track how often each prefix value occurred.
- A formula:  
  🔑 **If `prefixSum[j] - prefixSum[i] = K`, then subarray (i+1 to j) has the desired property.**

---

## 🎯 Use Cases

| Problem Type                                 | Goal                                |
|---------------------------------------------|-------------------------------------|
| Subarray Sum Equals K                       | Count subarrays where sum == K      |
| Number of Subarrays with Exactly K Odds     | Count subarrays with K odd numbers  |
| Binary Subarrays With Sum K                 | Subarrays of 0/1s with sum == K     |
| At Most / Exactly K Distinct Elements       | Use sliding window with hashmap     |

---

## 🎵 Intuition (Feel It, Not Just Know It)

Imagine **walking on a road**.
- Every step you take is **accumulating some experience** (like sum, odd count, etc.).
- After a while, you want to know:
  > "From which points behind me could I have *exactly K steps of a certain type*?" 🚶‍♂️

If you **already know** how many times you stood at a certain total,  
and your current total is **K more** than that,
then **each such past moment** represents a valid journey! 🏰

---

## 🌟 Step-by-Step Mental Picture

1. **Prefix Count**:
    - Think of prefix count as your "score so far" at each index.
    - `prefixSum[i]` = total "property" from start up to index `i`.

2. **Idea**:
    - If `prefixSum[j] - prefixSum[i] == K`,  
      it means the subarray from `(i+1)` to `j` **has exactly K property**.

3. **HashMap**:
    - At each point, you ask:
      > "How many times have I seen a prefix that would give me exactly K if I subtract it from now?"
    -
   In code:  
   ➔ **`count += map.getOrDefault(currentPrefix - k, 0)`**

4. **Update the Map**:
    - After using, **record** that you've now seen `currentPrefix` once more.
    - So that future points can benefit from this moment.

---



# 🏰 Poetic Summary

> As you walk the road,  
> every footprint records the distance you’ve traveled.  
> If ever two footprints differ by K,  
> they sing a song of a journey perfectly sized —  
> a subarray born from the past, realized in the present. 🌸

---
## 💻 Java Template

### ⭐ Example: Count subarrays with **exactly K odd numbers**

```java
public int numberOfSubarrays(int[] nums, int k) {
    int count = 0;
    int oddCount = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1); // base case

    for (int num : nums) {
        if (num % 2 != 0) {
            oddCount++;
        }

        count += map.getOrDefault(oddCount - k, 0);
        map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
    }

    return count;
}
```

## 🎨 Visual Deep Dive Example

Let's say:

`nums = [1, 1, 2, 1, 1]`  
`k = 3`

---

| Index | Value | Odd Count (Prefix) | What we do? | HashMap                 | How many new subarrays? |
|------|-------|--------------------|-------------|-------------------------|-------------------------|
| 0    | 1     | 1                  | No match    | {0:1, 1:1}              | 0                       |
| 1    | 1     | 2                  | No match    | {0:1, 1:1, 2:1}         | 0                       |
| 2    | 2     | 2                  | No match    | {0:1, 1:1, 2:2}         | 0                       |
| 3    | 1     | 3                  | **Look for (3-3)=0 → Found 1** | {0:1, 1:1, 2:2, 3:1} | +1 |
| 4    | 1     | 4                  | **Look for (4-3)=1 → Found 1** | {0:1, 1:1, 2:2, 3:1, 4:1} | +1 |

---

✅ Final Count = 2

Notice the **magical moment**:

- At index 3, **prefixSum = 3**.  
  Looking back, if there was ever a time prefixSum was `0`, then between that time and now, **we have exactly 3 odds**!

- At index 4, **prefixSum = 4**.  
  Look back for prefixSum `1`, and find it → another subarray.

---

## 🔥 Key Vibes You Should Feel

- **Memory**: We remember how many times each prefix appeared.
- **Matching**: We search for a "past memory" that fits the K-gap.
- **Accumulation**: Prefix sums naturally carry the journey’s total until now.
- **Efficiency**: Instead of checking every past subarray manually (O(n²)),  
  we check instantly using a HashMap (O(1) lookup)!

---

# 🎨 Once More :  Visual + Animation Style Explanation

## 📜 New Example

`nums = [2, 1, 3, 4, 1],  k = 2`  
(we count *subarrays where the number of **odd numbers** is exactly 2*)

---

## 🛤️ Walking through the array like a traveler...

Let's walk index-by-index:

---

| Step | Current num | Is Odd? | Odd Prefix Count | What we need? | HashMap State | How many subarrays here? |
|:----:|:-----------:|:-------:|:----------------:|:-------------:|:-------------:|:------------------------:|
| 0    | 2           | No      | 0                | Look for `0-2=-2` | {0:1, 0:1} | 0 |
| 1    | 1           | Yes     | 1                | Look for `1-2=-1` | {0:1, 1:1} | 0 |
| 2    | 3           | Yes     | 2                | Look for `2-2=0` | {0:1, 1:1, 2:1} | 1 |
| 3    | 4           | No      | 2                | Look for `2-2=0` | {0:1, 1:1, 2:2} | 1 |
| 4    | 1           | Yes     | 3                | Look for `3-2=1` | {0:1, 1:1, 2:2, 3:1} | 1 |

---

✅ Final count = 3 subarrays! 🌟

---

# 🧩 Storyboard Visualization

```
Start:
HashMap = {0:1}  // base case: 0 odd count seen once.

Step 0: num=2
- Not odd, prefixOdd = 0
- Want -2... no such thing! 😂
- Record 0 → HashMap {0:2}

Step 1: num=1
- Odd, prefixOdd = 1
- Want -1... impossible
- Record 1 → HashMap {0:2, 1:1}

Step 2: num=3
- Odd, prefixOdd = 2
- Want 0 → YES! 2 times (HashMap[0]=2)
- So add 2 subarrays!
- Record 2 → HashMap {0:2, 1:1, 2:1}

Step 3: num=4
- Not odd, prefixOdd = 2 (no change)
- Want 0 → YES! (HashMap[0]=2)
- So add 2 subarrays!
- Record 2 again → HashMap {0:2, 1:1, 2:2}

Step 4: num=1
- Odd, prefixOdd = 3
- Want 1 → YES! (HashMap[1]=1)
- Add 1 subarray
- Record 3 → HashMap {0:2, 1:1, 2:2, 3:1}
```

---

## ✨ Key Takeaways

- Think of **prefix count** like a memory of what we’ve seen.
- `map[prefix] = frequency` allows us to **quickly lookup** valid subarrays.
- You can tweak the **property you're tracking**: sum, odds, evens, etc.
- Can adapt to `at most K`, `exactly K`, and even range counts.

---

# 💡 When can we replace HashMap with an Array?

✅ **When the prefix values are small and non-negative**, we can directly use an array as a frequency counter (like how we use counting sort).  
Think of it as turning our HashMap into an *addressable memory shelf* 📦.

---

# 👀 Let's take a real example (with odd count):

`nums = [2, 1, 3, 4, 1], k = 2`

We calculate the prefix sum of **odd numbers** → this will always be between `0` and `n` (since max odd count ≤ length of array).

So we can safely do:

```java
int[] freq = new int[n + 1]; // instead of HashMap
```

Same idea applies:
- `freq[oddCount - k]` gives how many subarrays exist ending at this index.
- `freq[oddCount]++` updates for future queries.

---

# 🔁 Java Version with Array instead of HashMap

```java
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[n + 1]; // frequency of prefix odd counts
        freq[0] = 1; // base case: 0 odd elements seen once

        int oddCount = 0;
        int result = 0;

        for (int num : nums) {
            if (num % 2 != 0) oddCount++;

            if (oddCount >= k) {
                result += freq[oddCount - k];
            }

            freq[oddCount]++;
        }

        return result;
    }
}
```

---

# 🎯 Intuition Stays the Same!

- `freq[x]` means:
  > "I've seen a total of `x` odd numbers up to this point in the past."

- So when `oddCount = 4` and `k = 2`,  
  you look back:
  > “How many times did I have exactly `4 - 2 = 2` odds before?”  
  That means those subarrays between then and now have exactly `k` odds!

---

# 🚀 Visual Feeling with Array

Let's say:
- `oddCount = 3`
- You're at index 4
- `freq = [1, 1, 1, 1]`

You do:
- `freq[3 - 2] = freq[1] = 1` ➝ So, you add +1 to result!
- Then `freq[3]++ → freq[3] = 2`

You’re just using array *indexes as keys* like a HashMap 📊

---

# 🧠 When to Prefer Array over HashMap?

| Condition                     | Use Array? |
|------------------------------|------------|
| Prefix value is non-negative | ✅ Yes     |
| Prefix value is bounded (small size) | ✅ Yes     |
| Values can go negative       | ❌ No      |
| Values are large             | ❌ No      |

---

## 📦 Bonus Variants

- 🔹 **Subarray Sum Equals K** → Track `prefixSum` instead of odd count.
- 🔹 **Max Subarray with at most K Distinct** → Use sliding window + freq map.
- 🔹 **Binary Subarray with Sum K** → Same idea, just with 0/1s.

---

## 📚 Practice Problems

1. [Leetcode 1248 – Count Number of Nice Subarrays](https://leetcode.com/problems/count-number-of-nice-subarrays/)
2. [Leetcode 930 – Binary Subarrays With Sum](https://leetcode.com/problems/binary-subarrays-with-sum/)
3. [Leetcode 560 – Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)

---