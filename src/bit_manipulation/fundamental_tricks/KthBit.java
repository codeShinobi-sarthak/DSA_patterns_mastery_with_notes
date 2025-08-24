package bit_manipulation.fundamental_tricks;

public class KthBit {
    // Method to check whether the K-th bit (starting from 0) is set (i.e., is 1) in the given number
    void checkKthBit(int num, int k) {
        // Step 1: Display the binary representation of the number for better understanding
        System.out.println("Binary representation of " + num + " : " + Integer.toBinaryString(num));

        // Step 2: Explain the purpose
        // We want to check whether the k-th bit (counting from the right, 0-indexed) is set (1) or not.
        // Example:
        // num = 10 (Binary: 1010)
        // Let's say k = 1 --> We want to check if the 1st bit (second bit from the right) is 1.

        // Step 3: Create a mask by left shifting 1 by k positions
        // (1 << k) shifts 1 to the left by k places.
        // Example:
        // For k = 1:
        // 1 << 1 --> binary: 10 (decimal 2)
        // So, mask = 2 (binary 10)

        int mask = (1 << k);
        System.out.println("Mask after left shift (1 << " + k + ") : " + Integer.toBinaryString(mask));

        // Step 4: Perform bitwise AND between num and mask
        // If the result is NOT zero, it means the k-th bit is set.
        // If the result is zero, it means the k-th bit is NOT set.

        int result = num & mask;
        System.out.println("Result of (num & mask) : " + Integer.toBinaryString(result));

        // Step 5: Decision based on result
        if (result != 0) {
            System.out.println("The " + k + "-th bit is SET (1)");
        } else {
            System.out.println("The " + k + "-th bit is NOT set (0)");
        }
    }

    // Method to toggle (flip) the K-th bit of the given number
    void toggleKthBit(int num, int k) {
        // Step 1: Display the original number in binary
        System.out.println("Original number (" + num + ") in binary: " + Integer.toBinaryString(num));

        // Step 2: Purpose
        // We want to flip the K-th bit:
        // - If the bit is 1, make it 0
        // - If the bit is 0, make it 1

        // Step 3: Create the mask
        // (1 << k) creates a mask with only the K-th bit set to 1.
        int mask = (1 << k);
        System.out.println("Mask after (1 << " + k + ") : " + Integer.toBinaryString(mask));

        // Step 4: Toggle using XOR
        // num ^ mask flips ONLY the bits where the mask has 1.
        // - If num's bit is 1 and mask's bit is 1 → 1 ^ 1 = 0 (bit is flipped to 0)
        // - If num's bit is 0 and mask's bit is 1 → 0 ^ 1 = 1 (bit is flipped to 1)
        int toggledNum = num ^ mask;
        System.out.println("Number after toggling " + k + "-th bit: " + toggledNum);
        System.out.println("Toggled number in binary: " + Integer.toBinaryString(toggledNum));

        // Step 5: Final Output
        System.out.println("Result: " + toggledNum);
    }


    // Method to SET (turn ON) the K-th bit of the given number
    void setKthBit(int num, int k) {
        // Step 1: Display the original number in binary
        System.out.println("Original number (" + num + ") in binary: " + Integer.toBinaryString(num));

        // Step 2: Purpose
        // We want to set the K-th bit:
        // - If the bit is already 1, no change.
        // - If the bit is 0, we turn it to 1.

        // Step 3: Create a mask
        // (1 << k) will create a mask where only the K-th bit is set to 1.
        int mask = (1 << k);
        System.out.println("Mask after (1 << " + k + "): " + Integer.toBinaryString(mask));

        // Step 4: Perform bitwise OR operation
        // OR rule:
        // 0 | 1 = 1
        // 1 | 0 = 1
        // 1 | 1 = 1
        // Thus, ORing with 1 ensures the bit becomes 1.

        int updatedNum = num | mask;
        System.out.println("Number after setting " + k + "-th bit: " + updatedNum);
        System.out.println("Updated number in binary: " + Integer.toBinaryString(updatedNum));

        // Step 5: Final Result
        System.out.println("Result: " + updatedNum);
    }


    // Method to UNSET (turn OFF) the K-th bit of the given number
    void unsetKthBit(int num, int k) {
        // Step 1: Display the original number in binary
        System.out.println("Original number (" + num + ") in binary: " + Integer.toBinaryString(num));

        // Step 2: Purpose
        // We want to UNSET (turn OFF) the K-th bit:
        // - If the bit is 1, make it 0
        // - If the bit is already 0, no problem, it stays 0.

        // Step 3: Create the mask
        // (1 << k) sets ONLY the K-th bit to 1.
        int mask = (1 << k);
        System.out.println("Mask before NOT (~): " + Integer.toBinaryString(mask));

        // Now take bitwise NOT (~) to invert bits:
        // - The K-th bit becomes 0
        // - All other bits become 1
        int invertedMask = ~mask;
        System.out.println("Inverted Mask (~mask): " + Integer.toBinaryString(invertedMask));

        // Step 4: Perform bitwise AND operation
        // - AND with 1 keeps the bit same
        // - AND with 0 forces the bit to 0 (turns OFF)
        int updatedNum = num & invertedMask;
        System.out.println("Number after unsetting " + k + "-th bit: " + updatedNum);
        System.out.println("Updated number in binary: " + Integer.toBinaryString(updatedNum));

        // Step 5: Final Result
        System.out.println("Result: " + updatedNum);
    }
}
