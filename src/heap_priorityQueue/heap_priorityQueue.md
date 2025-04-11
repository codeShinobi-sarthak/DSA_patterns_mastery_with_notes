# Heap & Priority Queue - DSA Pattern Notes

## 1. Introduction to Heap & Priority Queue
- A **Heap** is a specialized binary tree-based data structure that satisfies the **Heap Property**.
- A **Priority Queue** is an abstract data type that allows retrieval of the highest (or lowest) priority element efficiently, typically implemented using a heap.

### Heap Property:
- **Min Heap**: The parent node is always smaller than or equal to its child nodes.
- **Max Heap**: The parent node is always greater than or equal to its child nodes.

## 2. Types of Heaps
### Min Heap
- The smallest element is always at the root.
- Used in problems like **Dijkstra’s Algorithm** (shortest path), **Merge K Sorted Lists**, etc.

### Max Heap
- The largest element is always at the root.
- Used in problems like **Top K Elements**, **Heap Sort**, etc.

## 3. Common Heap Operations & Complexity
| Operation      | Min/Max Heap | Priority Queue |
|--------------|------------|----------------|
| Insert       | O(log N)   | O(log N)       |
| Get Min/Max | O(1)       | O(1)           |
| Delete Root | O(log N)   | O(log N)       |
| Build Heap  | O(N)       | O(N)           |

## 4. When to Use Heaps in DSA Problems
- **Top K elements** (Sorting is too expensive, heap gives O(K log N) complexity).
- **Scheduling Problems** (Task scheduling, CPU scheduling, etc.).
- **Graph Algorithms** (Dijkstra’s Algorithm for shortest path).
- **Merging Sorted Lists** (Efficiently merging K sorted arrays).

## 5. Important Problems & Variations
### 🔹 Top K Elements (Max/Min Heap)
- Given an array, find the **top K largest/smallest** elements.
- **Approach**: Use a **Min Heap** of size K to store the top K largest elements.
- **Complexity**: O(N log K)

### 🔹 Merge K Sorted Lists
- Merge K sorted linked lists into one sorted list.
- **Approach**: Use a **Min Heap** to store the smallest element from each list.
- **Complexity**: O(N log K) (N = total elements, K = number of lists)

### 🔹 Kth Largest Element in an Array
- Find the Kth largest element in an array.
- **Approach**: Use a **Min Heap** of size K.
- **Complexity**: O(N log K)

### 🔹 Dijkstra’s Algorithm (Shortest Path)
- Use a **Min Heap** to always expand the nearest unvisited node first.
- **Complexity**: O((V + E) log V)

## 6. Java Implementation
### 🔹 Min Heap Using PriorityQueue
```java
import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(4);
        minHeap.add(15);
        minHeap.add(1);
        
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " "); // Output: 1 4 10 15
        }
    }
}
```

### 🔹 Max Heap Using PriorityQueue
```java
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(10);
        maxHeap.add(4);
        maxHeap.add(15);
        maxHeap.add(1);
        
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " "); // Output: 15 10 4 1
        }
    }
}
```

## 7. Best Practices & Optimization
✅ Use **PriorityQueue** in Java for built-in heap functionality.  
✅ Use **Collections.reverseOrder()** for a max heap in Java.  
✅ For **custom objects**, override `Comparator` or implement `Comparable`.  
✅ Use **Heapify (O(N))** instead of inserting elements one by one (O(N log N)).

---
This covers the **Heap & Priority Queue** pattern in depth! 🚀 Next, we can explore **Heap variations**, **real-world use cases**, or solve more problems. Let me know what you’d like to focus on next!

