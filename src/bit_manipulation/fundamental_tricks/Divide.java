package bit_manipulation.fundamental_tricks;

public class Divide {

    // Method 1: Divide by power of 2 using right shift
    void divideByPowerOfTwo(int num, int k) {
        System.out.println("Original number: " + num + " (Binary: " + Integer.toBinaryString(num) + ")");
        System.out.println("We want to divide it by 2^" + k + " i.e., " + (1 << k));

        // Right shift divides the number by 2^k
        int result = num >> k;

        System.out.println("After shifting right by " + k + " bits:");
        System.out.println("Result in binary: " + Integer.toBinaryString(result));
        System.out.println("Final Result: " + result);
    }

    // Method 2: Divide two numbers without using '/' (bit logic version of long division)
    void divideTwoNumbers(int dividend, int divisor) {
        System.out.println("\nDividing " + dividend + " by " + divisor + " using bit logic");

        if (divisor == 0) {
            System.out.println("Error: Division by zero is undefined!");
            return;
        }

        // Display the original number in binary
        System.out.println("Original number (" + dividend + ") in binary: " + Integer.toBinaryString(dividend));
        System.out.println("Original number (" + divisor + ") in binary: " + Integer.toBinaryString(divisor));

        boolean negative = (dividend < 0) ^ (divisor < 0); // XOR to check if signs differ

        // Convert to positive long for safe shifting
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long result = 0;

        // Long division via shifting
        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                result += (1L << i);
                a -= (b << i);
            }
        }

        result = negative ? -result : result;
        System.out.println("Final Quotient: " + result);
    }
}
