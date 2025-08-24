package bit_manipulation.fundamental_tricks;

public class Multiply {

    // Method to multiply a number by 2^k using bitwise shift
    void multiplyByPowerOfTwo(int num, int k) {
        // Step 1: Display the original number
        System.out.println("Original number: " + num + " (Binary: " + Integer.toBinaryString(num) + ")");
        System.out.println("We want to multiply it by 2^" + k + " i.e., " + (1 << k));

        // Step 2: Use left shift operator
        // Left shifting a number by k positions means: num * 2^k
        int result = num << k;

        // Step 3: Binary Explanation
        System.out.println("After shifting 'num' left by " + k + " bits");
        System.out.println("Result in binary: " + Integer.toBinaryString(result));
        System.out.println("Final Result: " + result);
    }

    // BONUS: Multiply any two numbers without using * operator (pure bit logic)
    void multiplyTwoNumbers(int a, int b) {
        System.out.println("Multiplying " + a + " and " + b + " using bit logic (Russian Peasant Method)");

//        Display the original number in binary
        System.out.println("Original number (" + a + ") in binary: " + Integer.toBinaryString(a));
        System.out.println("Original number (" + b + ") in binary: " + Integer.toBinaryString(b));

        int result = 0;

        while (b > 0) {
            // If last bit of b is 1, add current a to result
            if ((b & 1) == 1) {
                System.out.println("Adding " + a + " to result (as b's LSB is 1)");
                result += a;
            }

            // Double 'a' and halve 'b'
            a <<= 1; // a = a * 2
            b >>= 1; // b = b / 2
        }

        System.out.println("Final Result: " + result);
    }
}
