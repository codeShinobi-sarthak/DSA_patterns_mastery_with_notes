package monotonic_stack;

//! Linl : https://leetcode.com/problems/next-greater-element-i/


import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementOne {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] ans = new int[l1];
        HashMap<Integer, Integer> map = new HashMap<>(); // stores -> (element, index)
        Stack<Integer> stack = new Stack<>();

        for (int i = l2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else
                map.put(nums2[i], stack.peek());
            stack.push(nums2[i]);
        }

        for (int i = 0; i < l1; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

}
