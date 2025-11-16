import java.util.Scanner;

public class CountEvenOddDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.print(countEvenOddDigits(num));
        scanner.close();
    }

    public static String countEvenOddDigits(int num) {
        int even = 0;
        int odd = 0;
        if (num == 0) {
            even++;
        }
        while (num != 0) {
            if ((num % 10) % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            num = num / 10;
        }
        return even + ", " + odd;
    }
}
