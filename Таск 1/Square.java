import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double len = scanner.nextDouble();
        double wid = scanner.nextDouble();
        System.out.print(rectangleArea(len, wid));
        scanner.close();

    }

    public static double rectangleArea(double l, double w) {
        return l * w;
    }
}
