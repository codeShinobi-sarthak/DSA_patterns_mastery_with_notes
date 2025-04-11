package prefix_sum;

//! Link: https://leetcode.com/problems/subarray-sum-equals-k/description/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SubarraySumEqualsK {
//    public static void main(String[] args) {
//
//    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Important base case

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            int need = prefixSum - k;
            if (map.containsKey(need)) {
                count += map.get(need);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

}
