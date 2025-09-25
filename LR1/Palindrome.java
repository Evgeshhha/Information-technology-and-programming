public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.printf(s + " - Palindrome\n");
            } else {
                System.out.printf(s + " - Not Palindrome\n");
            }
        }

    }

    public static String reverseString(String s) {
        String local_s = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            local_s += s.charAt(i);
        }
        return local_s;
    }

    public static boolean isPalindrome(String s) {
        if (s.equals(reverseString(s))) {
            return true;
        }
        return false;
    }
}
