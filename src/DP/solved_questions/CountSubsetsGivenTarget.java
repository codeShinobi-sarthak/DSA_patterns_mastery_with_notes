package DP.solved_questions;

/*
Given an array arr[] of length n and an integer target, the task is to
find the number of subsets with a sum equal to target.

Examples:

    Input: arr[] = [1, 2, 3, 3], target = 6
    Output: 3
    Explanation: All the possible subsets are [1, 2, 3], [1, 2, 3] and [3, 3]

    Input: arr[] = [1, 1, 1, 1], target = 1
    Output: 4
    Explanation: All the possible subsets are [1], [1], [1] and [1]

 */

public class CountSubsetsGivenTarget {
    public static void main(String[] args) {
        System.out.println(countSubsetsGivenTarget(new int[]{1, 2, 3, 3}, 6));

    }


    public static int countSubsetsGivenTarget(int[] nums, int target) {
        return backtrack(nums, target, 0);
    }

    private static int backtrack(int[] nums, int remaining, int index) {
        if (remaining == 0) return 1;
        if (index == nums.length || remaining < 0) return 0;

        // Include current element
        int include = backtrack(nums, remaining - nums[index], index + 1);

        // Exclude current element
        int exclude = backtrack(nums, remaining, index + 1);

        return include + exclude;
    }


    /*
      private static int backtrack(int[] nums, int target, int index, int currSum) {
        // ✅ Base Case: Found valid subset
        if (currSum == target) {
            return 1;
        }

        // ❌ Base Case: Out of bounds or sum exceeded
        if (index == nums.length || currSum > target) {
            return 0;
        }

        // 🎯 Choices: include or exclude the current element
        int include = backtrack(nums, target, index + 1, currSum + nums[index]);
        int exclude = backtrack(nums, target, index + 1, currSum);

        return include + exclude;
    }
     */

    /*
    static int count = 0;  // ✅ Global count

    private static void backtrack(int[] nums, int target, int index, int currSum) {
    if (currSum == target) {
        count++;
        // ❗ Don't return — we may find other subsets further ahead
    }

    if (index == nums.length || currSum > target) return;

    for (int i = index; i < nums.length; i++) {
        backtrack(nums, target, i + 1, currSum + nums[i]); // ✅ move forward
    }
}

     */
}
