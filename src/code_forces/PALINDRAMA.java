package code_forces;


// codeforces

public class PALINDRAMA {
    public static void main(String[] args) {
        System.out.println(palindrama("ab"));
        System.out.println(palindrama("aabbcc"));
        System.out.println(palindrama("cadi"));
    }

    private static int palindrama(String s) {
        int len = s.length();
        if (len == 1) return 0;
        int operations = 0;

        for (int i = 0; i < len / 2; i++) {
            int start = (int) s.charAt(i);
            int end = (int) s.charAt(len - i - 1);

            if (start == end) {
                operations++;
                continue;
            }

            if (Math.abs(end - start) % 2 == 0) {
                operations++;
            }
        }
        return operations == len / 2 ? operations : -1;
    }
}
