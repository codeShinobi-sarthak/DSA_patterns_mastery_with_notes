package code_forces;

// codeforces

public class RitikasStringShuffle {
    public static void main(String[] args) {
        System.out.println(stringShuffle("abcdef", "acbdef", new int[][]{{1, 3}, {2, 4}}, 6));
    }

    private static boolean stringShuffle(String s, String t, int[][] queries, int n) {
        for (int[] querie : queries) {
            int L = querie[0];
            int R = querie[1];

            StringBuffer tempS = new StringBuffer(s);

            for (int i = 0; i < n; i++) {
                if (tempS.charAt(i) == t.charAt(i)) continue;

                int newL = i + L;
                int newR = i + R;

//                boolean swapped = false;

                for (int j = newL; j <= newR; j++) {
                    if (tempS.charAt(j) == t.charAt(i)) {
//                        ? swap here
//                        char temp = s.charAt(i);
//                        tempS.c tempS.charAt(j);
//                        tempS.charAt(j) = temp;
//                        swapped = true;
                    }
                }
//                if (!swapped) return false;
            }
        }
        return true;
    }
}
