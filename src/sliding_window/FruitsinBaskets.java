package sliding_window;

//! Link : https://leetcode.com/problems/fruit-into-baskets/

import java.util.HashMap;

public class FruitsinBaskets {
    public static void main(String[] args) {
        int[] fruits = {1, 1, 2, 2, 0, 0, 0};
        FruitsinBaskets obj = new FruitsinBaskets();
        System.out.println(obj.totalFruit(fruits)); // Expected output: 4
    }

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int maxFruits = 0;
        int left = 0;
        HashMap<Integer, Integer> typeToCount = new HashMap<>();

        for (int right = 0; right < n; right++) {
            int currFruit = fruits[right];

            typeToCount.put(currFruit, typeToCount.getOrDefault(currFruit, 0) + 1);

            if (typeToCount.size() > 2) {
                int leftFruit = fruits[left];

                typeToCount.put(leftFruit, typeToCount.getOrDefault(leftFruit, 0) - 1);
                if (typeToCount.get(leftFruit) == 0) {
                    typeToCount.remove(leftFruit);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }


//    more optimised aproach

    public int totalFruit2(int[] fruits) {
        int fruit1 = fruits[0], fruit2 = -1; // Two types of fruits allowed
        int left = 0, prevFruitIndex = 0;   // Left pointer and last occurrence of fruit1
        int maxFruits = 0;

        for (int right = 1; right < fruits.length; right++) {
            int currFruit = fruits[right];

            if (currFruit != fruit1) {
                // If we encounter a third fruit type
                if (currFruit != fruit2 && fruit2 != -1) {
                    maxFruits = Math.max(maxFruits, right - left);
                    left = prevFruitIndex; // Move left to previous fruit's start
                }

                // Update fruit types
                fruit2 = fruit1;
                fruit1 = currFruit;
                prevFruitIndex = right; // Mark start of the new fruit sequence
            }
        }

        return Math.max(maxFruits, fruits.length - left);
    }
}
