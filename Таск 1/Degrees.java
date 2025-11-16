import java.util.Scanner;

public class Degrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double celsius = scanner.nextDouble();
        System.out.print(toFahrenheit((celsius)));
        scanner.close();
    }

    public static double toFahrenheit(double c) {
        return c * 9 / 5 + 32;
    }
}
