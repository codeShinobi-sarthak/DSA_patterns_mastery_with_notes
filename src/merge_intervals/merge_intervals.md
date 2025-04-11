# 🟢 **Merge Intervals Pattern**

## 📌 **Concept**
The **Merge Intervals** pattern is used when solving problems that involve **overlapping intervals**. It is commonly used in **scheduling problems, meeting rooms, and range merging** scenarios.

**Key Idea:**
1. **Sort the intervals** based on their start times.
2. **Iterate** through the intervals and merge overlapping ones.
3. **Use a result list** to store the merged intervals.

---

## 🛠 **When to Use?**
✅ When given a list of intervals that may overlap.  
✅ When merging or processing overlapping time slots or ranges.  
✅ When finding free time between intervals.

---

## 🚀 **Algorithm**

1️⃣ **Sort** the intervals based on the start time.  
2️⃣ Initialize a **result list** with the first interval.  
3️⃣ Iterate through the intervals:
- If the current interval **overlaps** with the last merged interval, merge them.
- Otherwise, add the current interval as a new entry.  
  4️⃣ Return the merged list.

---

## 📍 **Example**

### **Problem:** Merge overlapping intervals
🔹 **Input:** `[[1,3], [2,6], [8,10], [15,18]]`  
🔹 **Output:** `[[1,6], [8,10], [15,18]]`

### **Explanation:**
- `[1,3]` and `[2,6]` overlap → Merge to `[1,6]`
- `[8,10]` has no overlap → Keep as is
- `[15,18]` has no overlap → Keep as is

---

## 💻 **Java Code Implementation**

```java
import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        // Step 2: Iterate through intervals
        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) { // Overlapping intervals
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else { // Non-overlapping interval, add to result
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] result = merge(intervals);

        System.out.println("Merged Intervals:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
```

---

## 📊 **Time & Space Complexity**

- **Time Complexity:** `O(N log N)` → Sorting takes `O(N log N)`, merging takes `O(N)`.
- **Space Complexity:** `O(N)` → Storing merged intervals.

---

## 🔥 **Variations & Similar Problems**
🔹 **Insert Interval** – Insert a new interval into a sorted list and merge.  
🔹 **Employee Free Time** – Find available time slots between intervals.  
🔹 **Meeting Rooms II** – Find the minimum number of meeting rooms required.

