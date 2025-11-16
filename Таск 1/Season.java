import java.util.Scanner;

public class Season {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.print(season(n));
        scanner.close();

    }

    public static String season(int n) {
        if (n == 12 || n == 1 || n == 2) {
            return "зима";
        } else if (n >= 3 && n <= 5) {
            return "весна";
        } else if (n >= 6 && n <= 8) {
            return "лето";
        } else if (n >= 9 && n <= 11) {
            return "осень";
        }
        return "";
    }
}
