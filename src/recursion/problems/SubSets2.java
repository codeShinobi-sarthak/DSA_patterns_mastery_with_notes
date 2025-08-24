package recursion.problems;

//! link:  

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<>();
        Arrays.sort(nums); // 🔑 Step 1: Sort to handle duplicates
        backtrack(nums, 0, new ArrayList<>(), subSets);
        return subSets;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> subSets) {
        subSets.add(new ArrayList<>(current)); // ✅ Add subset at each recursion

        for (int i = start; i < nums.length; i++) {
            // 🔁 Skip duplicates
            if (i > start && nums[i] == nums[i - 1])
                continue;

            current.add(nums[i]);
            backtrack(nums, i + 1, current, subSets); // Recurse
            current.remove(current.size() - 1); // Backtrack
        }
    }
}
