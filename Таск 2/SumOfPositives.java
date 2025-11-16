import java.util.Scanner;

public class SumOfPositives {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.print(sumOfPositives(line));
        scanner.close();
    }

    public static int sumOfPositives(String line) {
        String[] parts = line.split(",");
        int sum = 0;
        for (int i = 0; i < parts.length; i++) {
            if (Integer.parseInt(parts[i].trim()) > 0) {
                sum += Integer.parseInt(parts[i].trim());
            }
        }
        return sum;
    }
}
