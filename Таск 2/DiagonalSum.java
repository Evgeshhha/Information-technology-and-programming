import java.util.Scanner;

public class DiagonalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        line = line.replace("[", "");
        line = line.replace("]", "");
        String[] parts = line.split(",");
        int[][] mas = new int[(int) Math.sqrt(parts.length)][(int) Math.sqrt(parts.length)];
        for (int i = 0; i < (int) Math.sqrt(parts.length); i++) {
            for (int j = 0; j < (int) Math.sqrt(parts.length); j++) {
                mas[i][j] = Integer.parseInt(parts[i * (int) Math.sqrt(parts.length) + j].trim());
            }
        }
        System.out.print(diagonalSum(mas));
        scanner.close();
    }

    public static int diagonalSum(int[][] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            sum += mas[i][i];
        }
        return sum;
    }
}
