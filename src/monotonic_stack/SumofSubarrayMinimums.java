package monotonic_stack;
import java.util.*;

public class SumofSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] > arr[i])) {
                int idx = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                long leftCount = idx - left;
                long rightCount = i - idx;
                sum = (sum + (arr[idx] * leftCount * rightCount) % MOD) % MOD;
            }
            stack.push(i);
        }

        return (int) sum;
    }
}
