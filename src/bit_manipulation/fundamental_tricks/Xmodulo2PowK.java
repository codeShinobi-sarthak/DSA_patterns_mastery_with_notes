package bit_manipulation.fundamental_tricks;

public class Xmodulo2PowK {

    // This method computes num % (2^k) using bitwise operations
    void XModulo(int num, int k) {
        // Print the original number and its binary form
        System.out.println("Original number: " + num + " (Binary: " + Integer.toBinaryString(num) + ")");
        System.out.println("We want to compute num % (2^" + k + ")");

        // Step 1: Calculate 2^k using left shift
        // Left shifting 1 by k bits gives us 2 raised to the power k
        // For example, 1 << 3 = 8 (i.e., 2^3)
        int powerOfTwo = 1 << k;
        System.out.println("2^" + k + " = " + powerOfTwo + " (Binary: " + Integer.toBinaryString(powerOfTwo) + ")");

        // Step 2: Subtract 1 from 2^k to get a bitmask where the lowest k bits are 1
        // Example: if k = 3 → 2^k = 8 → mask = 7 → Binary: 00000111
        // This mask helps isolate the lowest k bits of the number
        int mask = powerOfTwo - 1;
        System.out.println("Mask (2^k - 1): " + mask + " (Binary: " + Integer.toBinaryString(mask) + ")");

        // Step 3: Perform bitwise AND between the number and the mask
        // Why? Because only the lowest k bits will remain — rest will be 0
        // This gives us exactly what we want: num % 2^k
        int result = num & mask;

        // Output the result with binary clarity
        System.out.println("Binary of num    : " + String.format("%8s", Integer.toBinaryString(num)).replace(' ', '0'));
        System.out.println("Binary of mask   : " + String.format("%8s", Integer.toBinaryString(mask)).replace(' ', '0'));
        System.out.println("AND Result       : " + String.format("%8s", Integer.toBinaryString(result)).replace(' ', '0'));
        System.out.println("So, " + num + " % " + powerOfTwo + " = " + result);
    }
}




/*
num = 77              → Binary: 1001101
k = 3                 → So 2^3 = 8
Mask = 8 - 1 = 7      → Binary: 0000111

Now:  77 & 7

              1001101 (77)
            & 0000111  (7)
            ---------
              0000101 → 5 ✅

So, 77 % 8 = 5

 */