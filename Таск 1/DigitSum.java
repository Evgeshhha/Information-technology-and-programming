import java.util.Scanner;

public class DigitSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int digit = scanner.nextInt();
        System.out.println(digitSum(Math.abs(digit)));
        scanner.close();
    }

    public static int digitSum(int d) {
        int buf = 0;
        while (d != 0) {
            buf += d % 10;
            d /= 10;
        }
        return buf;
    }
}
