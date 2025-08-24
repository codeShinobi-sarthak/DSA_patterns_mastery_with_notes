package bit_manipulation.fundamental_tricks;

public class PowerOfTwo {
    // Method to check if the number is a power of two
    void checkPowerOfTwo(int num) {
        // Step 1: Edge case check: If num is less than or equal to 0, it can't be a power of two.
        // Powers of two are always positive integers. So, return false for non-positive numbers.
        if (num <= 0) {
            System.out.println(num + " is not a power of two");
            return; // Exit method early if the number is non-positive
        }

        // Step 2: Display the binary representation of the number for better understanding.
        // This will help you visualize the number's bits before performing operations.
        System.out.println("Binary representation of " + num + " : " + Integer.toBinaryString(num));

        // Example: num = 8 (binary: 1000)
        // Explanation: Powers of two have exactly one '1' bit and the rest are '0's.
        // Here 8 = 2^3, so its binary representation is 1000.

        // Step 3: Let's look at what happens when we subtract 1 from the number.
        // The core trick here is that if num is a power of two, num - 1 will flip all the bits after the first '1'.
        // For example:
        // - If num = 8 (binary: 1000), then num - 1 = 7 (binary: 0111).
        // - Notice that 8 and 7 have no bits in common, so the bitwise AND of num and num - 1 will be zero.
        System.out.println("num - 1 = " + (num - 1) + " (Binary: " + Integer.toBinaryString(num - 1) + ")");

        // Step 4: Perform the bitwise AND operation between num and num - 1.
        // This operation will give us a '0' for powers of two and a non-zero value for non-powers of two.
        // Example:
        // For num = 8 (binary: 1000) and num - 1 = 7 (binary: 0111):
        // 1000 & 0111 = 0000 (which is 0).
        System.out.println("num & (num - 1) = " + (num & (num - 1)) + " (Binary: " + Integer.toBinaryString(num & (num - 1)) + ")");

        // Step 5: If the result of (num & (num - 1)) equals 0, then num is a power of two.
        // This works because, for powers of two, the number and its previous value (num - 1) have no overlapping bits.
        if ((num & (num - 1)) == 0) {
            // Step 6: If the result is 0, we confirm that the number is a power of two and print the result.
            System.out.println(num + " is a power of two");
        } else {
            // Step 7: Otherwise, it means the number has more than one '1' bit, so it's not a power of two.
            System.out.println(num + " is not a power of two");
        }
    }
}
