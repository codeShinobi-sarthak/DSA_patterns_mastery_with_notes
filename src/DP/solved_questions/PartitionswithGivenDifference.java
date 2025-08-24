/**
 * ❓ Question: Partitions with Given Difference
 *
 * Given an array arr[], partition it into two subsets (possibly empty)
 * such that each element belongs to only one subset.
 *
 * Let the sum of elements of the two subsets be sum1 and sum2.
 * Given a difference `d`, count the number of ways to partition the array
 * such that:
 *
 * ➤ sum1 >= sum2
 * ➤ sum1 - sum2 = d
 *
 * 📥 Input:  arr[] (array of integers), d (required difference)
 * 🎯 Output: Number of valid partitions satisfying the above conditions.
 *
 * Example:
 * arr = [1, 1, 2, 3], d = 1
 * Output = 3
 * Explanation: The valid partitions are:
 *   [1, 3] and [1, 2] -> 4 - 3 = 1
 *   [1, 2] and [1, 3] -> 3 - 2 = 1
 *   [3, 1] and [1, 2] -> 4 - 3 = 1
 *
 * 🎓 Concept: This is a variation of the subset sum problem and is solved
 * using dynamic programming.
 */

package DP.solved_questions;

public class PartitionswithGivenDifference {
//    public static void main(String[] args) {
//        int[] arr = {1, 1, 2, 3};
//        int d = 1;
//        System.out.println("Total partitions: " + countPartitionsWithDiff(arr, d));
//    }

    // 🧠 DP-based solution
    public static int countPartitionsWithDiff(int[] arr, int d) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        // Handle invalid cases
        if ((totalSum + d) % 2 != 0) return 0;

        int target = (totalSum + d) / 2;

        return countSubsetsWithSum(arr, target);
    }

    // 🎯 Count subsets with a given sum (classic subset sum DP)
    private static int countSubsetsWithSum(int[] arr, int target) {
return 0;
    }
}
