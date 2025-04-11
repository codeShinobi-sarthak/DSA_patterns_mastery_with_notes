package binary_search;

import java.util.ArrayList;
import java.util.List;


//! link : https://leetcode.com/problems/longest-increasing-subsequence/?envType=study-plan-v2&envId=binary-search


//note:  can also be solved as DP

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }

    public static int lengthOfLIS(int[] nums) {
        // List to store the smallest tail of all increasing subsequences
        List<Integer> tails = new ArrayList<>();

        for (int num : nums) {
            // Perform binary search on tails to find the insertion index
            int left = 0, right = tails.size();

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (tails.get(mid) < num) {
                    left = mid + 1; // num is bigger, move right
                } else {
                    right = mid; // num could be placed here or earlier
                }
            }

            // If left == tails.size(), it means num is greater than all elements → extend sequence
            if (left < tails.size()) {
                tails.set(left, num); // Replace to maintain the smallest possible tail
            } else {
                tails.add(num); // Append new subsequence
            }
        }

        // Length of tails = length of LIS
        return tails.size();
    }
}
