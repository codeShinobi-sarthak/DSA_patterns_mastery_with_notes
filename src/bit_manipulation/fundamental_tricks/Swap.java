package bit_manipulation.fundamental_tricks;

public class Swap {

    // Method to swap two numbers without using a third variable
    void swapTwoNumbers(int a, int b) {
        System.out.println("Before swapping: a = " + a + ", b = " + b);

        // Step 1: XOR both values and store the result in 'a'
        // Now 'a' holds: a ^ b
        a = a ^ b;
        System.out.println("After a = a ^ b => a = " + a + " (a now holds combined XOR of original a and b)");

        // Step 2: XOR the new 'a' with 'b' to get original 'a' back in 'b'
        // Since a = a ^ b and b = original b
        // So, b = (a ^ b) ^ b = a
        b = a ^ b;
        System.out.println("After b = a ^ b => b = " + b + " (b now holds original value of a)");

        // Step 3: XOR the new 'a' with new 'b' to get original 'b' back in 'a'
        // So, a = (a ^ b) ^ a = b
        a = a ^ b;
        System.out.println("After a = a ^ b => a = " + a + " (a now holds original value of b)");

        System.out.println("After swapping: a = " + a + ", b = " + b);
    }
}

/*
a ^ b ^ b = a
a ^ a = 0
0 ^ b = b
 */