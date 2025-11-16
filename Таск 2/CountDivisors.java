import java.util.Scanner;

public class CountDivisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.print(countDivisors(n));
        scanner.close();
    }

    public static int countDivisors(int n) {
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }
}