package merge_intervals;

import java.util.*;

public class CheckifGridcanbeCutintoSections {
    public static void main(String[] args) {
        int n = 5;
        int[][] rectangles = {
                {0, 0, 2, 2}, {2, 0, 4, 2}, {4, 0, 5, 5}
        };
        System.out.println(checkValidCuts(n, rectangles));
    }

    public static boolean checkValidCuts(int n, int[][] rectangles) {
        // Try both horizontal and vertical cuts
        return checkCuts(rectangles, 0) || checkCuts(rectangles, 1);
    }

    // Check if valid cuts can be made in a specific dimension
    private static boolean checkCuts(int[][] rectangles, int index) {
        int sections = 0;

        // Sort rectangles by their starting coordinate in the given points
        Arrays.sort(rectangles, (a, b) -> Integer.compare(a[index], b[index]));

        // Track the furthest ending coordinate seen so far
        int furthest = rectangles[0][index + 2];

        for (int i = 1; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];

            // If current rectangle starts after the furthest end we've seen,
            // we found a gap where a cut can be made
            if (furthest <= rectangle[index]) {
                sections++;
            }

            // Update the furthest ending coordinate
            furthest = Math.max(furthest, rectangle[index + 2]);
        }

        // We need at least 2 gaps to create 3 sections
        return sections >= 2;
    }
}
