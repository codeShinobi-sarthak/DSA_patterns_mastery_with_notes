package recursion.problems;

//! link: https://leetcode.com/problems/palindrome-partitioning/

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrack(s, 0, current, result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String subStr = s.substring(start, end);
            if (isPalindrome(subStr)) {
                current.add(subStr);
                backtrack(s, start + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }


    private boolean isPalindrome(String str) {
        if (str.length() == 1) return true;
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }
}
