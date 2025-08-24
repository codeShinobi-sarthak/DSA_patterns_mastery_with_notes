package code_forces;

public class TrippiTroppi {
    public static void main(String[] args) {
        // You can test the method here
        String s = "hello world from codeforces";
        System.out.println(trippiTroppi(s));
    }

    public static String trippiTroppi(String s) {
        StringBuilder str = new StringBuilder();
        str.append(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                str.append(s.charAt(i + 1));
            }
            if(str.length() == 3) break;
        }
        return str.toString();
    }
}
