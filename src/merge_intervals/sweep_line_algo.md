# 🔥 **Conquring** the **Sweep Line Algorithm** ! 🚀

## **Step 1: Understanding the Core Idea**
The **Sweep Line Algorithm** is a way to process **interval-based** problems **efficiently** by:
1. **Sorting events** (start and end points).
2. **Sweeping through them in sorted order** (like a scanner moving across a timeline).
3. **Maintaining active intervals** using a data structure (like a **TreeMap, PriorityQueue, or a Counter**).

---

### **🔹 Core Use Cases** (When to Use Sweep Line?)
- **Counting overlapping intervals** (e.g., most booked time slots, busiest periods).
- **Finding gaps in intervals** (e.g., free days, available rooms).
- **Detecting intersections or merging intervals** (e.g., union of meetings).
- **Handling 2D Geometry Problems** (e.g., **Skyline Problem**, max area covered).

---

### **Step 2: First Problem – Count Maximum Overlapping Intervals**
💡 **Problem Statement:**  
You are given a list of meetings as intervals `[start, end]`. Find the maximum number of meetings that happen **at the same time**.

#### **Example**
```java
int[][] meetings = {{1, 3}, {2, 6}, {5, 7}, {8, 10}, {9, 12}};
```
🔹 **Visual Representation:**
```
Timeline:    1  2  3  4  5  6  7  8  9 10 11 12
             |  |  |  |  |  |  |  |  |  |  |  |
Interval 1:  1-----3
Interval 2:     2-----------6
Interval 3:              5-----7
Interval 4:                       8----10
Interval 5:                          9-------12

```
📌 **Between time `1-7`, we have 3 overlapping meetings!**

✅ **Expected Output:** `3` (Max overlapping intervals)

---

### **Step 3: Solve It Using Sweep Line**
#### **🚀 Approach**
1. **Convert intervals into events:**
    - `+1` when a meeting starts.
    - `-1` when a meeting ends.
2. **Sort events by time** (`start` first, then `end`).
3. **Sweep through events and track active meetings** using a counter.
4. **Keep track of the maximum number of overlapping meetings.**

---

### **🔥 Java Code (Optimized Using TreeMap)**
```java
import java.util.*;

class Solution {
    public int maxOverlappingMeetings(int[][] meetings) {
        TreeMap<Integer, Integer> events = new TreeMap<>();

        // Step 1: Convert intervals into events
        for (int[] meeting : meetings) {
            events.put(meeting[0], events.getOrDefault(meeting[0], 0) + 1); // Meeting starts
            events.put(meeting[1], events.getOrDefault(meeting[1], 0) - 1); // Meeting ends
        }

        int maxMeetings = 0, activeMeetings = 0;

        // Step 2: Sweep through events in sorted order
        for (int change : events.values()) {
            activeMeetings += change;
            maxMeetings = Math.max(maxMeetings, activeMeetings);
        }

        return maxMeetings;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] meetings = {{1, 3}, {2, 6}, {5, 7}, {8, 10}, {9, 12}};
        System.out.println(sol.maxOverlappingMeetings(meetings)); // Output: 3
    }
}
```

---

### **🔥 Complexity Analysis**
| Step | Complexity |
|------|------------|
| **Creating events (O(n))** | `O(n)` |
| **Sorting events (O(n log n))** | `O(n log n)` |
| **Sweeping through events (O(n))** | `O(n)` |
| **Total Complexity** | **O(n log n)** |

✅ **Super efficient!** 🚀

---

### **🔥 What's Next?**
- **Practice:** Try solving "Meeting Rooms II" and "The Skyline Problem" using the Sweep Line approach.
---

## Now Let’s **deep dive** into these key **Sweep Line** variants, break them down with **visuals**, and understand how they actually work. 🚀

---

# **1️⃣ Sorting + Iteration (Basic Approach)**
### **Concept**
- Convert each interval into **two events**:
   - `+1` when a meeting **starts**.
   - `-1` when a meeting **ends**.
- Sort the events based on **time**.
- Sweep through them, tracking the **number of active intervals**.

### **Example**
Given meetings:
```java
int[][] meetings = {{1, 3}, {2, 6}, {5, 7}, {8, 10}, {9, 12}};
```
### **Step 1: Convert into Events**
```
Start Events:  (1, +1), (2, +1), (5, +1), (8, +1), (9, +1)
End Events:    (3, -1), (6, -1), (7, -1), (10, -1), (12, -1)
```

### **Step 2: Sort Events**
```
Sorted Events:  (1, +1), (2, +1), (3, -1), (5, +1), (6, -1), (7, -1), (8, +1), (9, +1), (10, -1), (12, -1)
```

### **Step 3: Sweep Line Process**
| Time | Event | Active Meetings | Max Meetings |
|------|-------|----------------|--------------|
| 1    | +1    | 1              | 1            |
| 2    | +1    | 2              | 2            |
| 3    | -1    | 1              | 2            |
| 5    | +1    | 2              | 2            |
| 6    | -1    | 1              | 2            |
| 7    | -1    | 0              | 2            |
| 8    | +1    | 1              | 2            |
| 9    | +1    | 2              | 2            |
| 10   | -1    | 1              | 2            |
| 12   | -1    | 0              | 2            |

✅ **Final Answer:** Maximum `2` meetings overlap.

---

# **2️⃣ Priority Queue (Min-Heap Approach)**
### **Concept**
- **Sort intervals by start time**.
- Use a **Min-Heap (PriorityQueue)** to track **end times**.
- If the current meeting **starts after the earliest ending meeting**, remove it from the heap.
- The **size of the heap** at any point = **number of active meetings**.

---

### **Example**
Meetings:
```java
int[][] meetings = {{1, 3}, {2, 6}, {5, 7}, {8, 10}, {9, 12}};
```

### **Step 1: Sort by Start Time**
```
Sorted Intervals:  [1,3], [2,6], [5,7], [8,10], [9,12]
```

### **Step 2: Process Meetings Using Min-Heap**
| Time | Action | Heap (End Times) | Active Meetings | Max |
|------|--------|-----------------|----------------|-----|
| 1    | Start [1,3] | `[3]` | 1 | 1 |
| 2    | Start [2,6] | `[3,6]` | 2 | 2 |
| 3    | Remove 3 (ended) | `[6]` | 1 | 2 |
| 5    | Start [5,7] | `[6,7]` | 2 | 2 |
| 6    | Remove 6 (ended) | `[7]` | 1 | 2 |
| 7    | Remove 7 (ended) | `[]` | 0 | 2 |
| 8    | Start [8,10] | `[10]` | 1 | 2 |
| 9    | Start [9,12] | `[10,12]` | 2 | 2 |
| 10   | Remove 10 (ended) | `[12]` | 1 | 2 |
| 12   | Remove 12 (ended) | `[]` | 0 | 2 |

✅ **Final Answer:** Maximum `2` meetings overlap.

---

# **3️⃣ Balanced Tree (TreeMap Approach)**
### **Concept**
- **Use a `TreeMap<Integer, Integer>`** to store **time points**.
   - `+1` for meeting start.
   - `-1` for meeting end.
- **Sweep through keys in sorted order**, tracking active meetings.

---

### **Example**
Meetings:
```java
int[][] meetings = {{1, 3}, {2, 6}, {5, 7}, {8, 10}, {9, 12}};
```

### **Step 1: Convert to TreeMap**
```
TreeMap: { 1:+1, 2:+1, 3:-1, 5:+1, 6:-1, 7:-1, 8:+1, 9:+1, 10:-1, 12:-1 }
```

### **Step 2: Sweep Line Execution**
| Time | Change | Active Meetings | Max Meetings |
|------|--------|----------------|--------------|
| 1    | +1     | 1              | 1            |
| 2    | +1     | 2              | 2            |
| 3    | -1     | 1              | 2            |
| 5    | +1     | 2              | 2            |
| 6    | -1     | 1              | 2            |
| 7    | -1     | 0              | 2            |
| 8    | +1     | 1              | 2            |
| 9    | +1     | 2              | 2            |
| 10   | -1     | 1              | 2            |
| 12   | -1     | 0              | 2            |

✅ **Final Answer:** Maximum `2` meetings overlap.

---

# **🔥 When to Use What?**
| Approach | Best When | Time Complexity |
|----------|----------|----------------|
| **Sorting + Iteration** | Small constraints (`n <= 10^5`) | `O(n log n)` |
| **Priority Queue (Heap)** | Need dynamic updates | `O(n log n)` |
| **TreeMap (Balanced BST)** | Need range queries efficiently | `O(n log n)` |

---

# **💥 Conclusion**
1. **Sorting + Iteration** → **Simple & effective for counting problems**
2. **Min-Heap (PriorityQueue)** → **Great for interval scheduling (like meeting rooms)**
3. **TreeMap (Balanced BST)** → **Best for range queries & precise interval tracking**

🔥🔥🔥 We just **mastered Sweep Line like PROS!** Want to try an **advanced problem** next? 🚀