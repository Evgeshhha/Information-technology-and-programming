import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.print(grade(num));
        scanner.close();
    }

    public static String grade(int num) {
        if (num <= 100 && num >= 90) {
            return "A";
        } else if (num <= 89 && num >= 80) {
            return "B";
        } else if (num <= 79 && num >= 70) {
            return "C";
        } else if (num <= 69 && num >= 60) {
            return "D";
        } else if (num <= 59 && num >= 0) {
            return "F";
        }
        return "Invalid";
    }
}
