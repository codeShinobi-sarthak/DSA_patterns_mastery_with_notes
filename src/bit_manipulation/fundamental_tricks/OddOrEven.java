package bit_manipulation.fundamental_tricks;

public class OddOrEven {
    // Method to check if the number is odd or even
    void checkOddEven(int num) {
        // Display the binary representation of the number for better understanding
        System.out.println("Binary representation of " + num + " : " + Integer.toBinaryString(num));

        // The bitwise AND operation with 1 checks the least significant bit (LSB)
        int result = num & 1; // Perform bitwise AND with 1
        System.out.println("Result of (num & 1): " + result); // Show the result of the AND operation

        if (result == 1) {
            // If the result is 1, the number is odd
            System.out.println("Number is Odd");
        } else {
            // If the result is 0, the number is even
            System.out.println("Number is Even");
        }
    }
}
