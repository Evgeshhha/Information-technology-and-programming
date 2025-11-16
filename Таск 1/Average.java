import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        System.out.print(average(a, b, c));
        scanner.close();

    }

    public static double average(double a, double b, double c) {
        return (a + b + c) / 3.0;
    }
}
