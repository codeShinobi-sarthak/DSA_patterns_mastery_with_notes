package code_forces;

import java.util.Scanner;

public class TungTungSahur {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            String p = sc.next();
            String s = sc.next();

            System.out.println(checkSound(p, s) ? "YES" : "NO");
        }
    }

    private static boolean checkSound(String p, String s) {
        int i = 0;
        int j = 0;

        while (i < p.length() && j < s.length()) {
            char currHit = p.charAt(i);
            if (s.charAt(j) != currHit) {
                return false;
            }
            j++;

            if (j < s.length() && s.charAt(j) == currHit) {
                j++;
            }

            i++;
        }

        return i == p.length() && j == s.length();
    }
}
