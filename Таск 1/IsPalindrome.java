import java.util.Scanner;

public class IsPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println((isPalindrome(s)));
        scanner.close();
    }

    public static boolean isPalindrome(String s) {
        String buf_s = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            buf_s += s.charAt(i);
        }
        return s.equals(buf_s);
    }
}
