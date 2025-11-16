import java.util.Scanner;

public class CheckAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        System.out.print(checkAge(age));
        scanner.close();

    }

    public static String checkAge(int age) {
        if (age >= 18) {
            return "совершеннолетний";
        }
        return "несовершеннолетний";
    }
}
