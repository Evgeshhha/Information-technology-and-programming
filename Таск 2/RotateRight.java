import java.util.Arrays;
import java.util.Scanner;

public class RotateRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        line = line.replace("[", "");
        line = line.replace("]", "");
        String[] num = line.split(",");
        if (num[0].trim().isEmpty() || line.trim().isEmpty()) {
            System.out.print("[]");
            scanner.close();
            return;
        }
        int[] mas = new int[num.length - 1];
        for (int i = 0; i < num.length - 1; i++) {
            mas[i] = Integer.parseInt(num[i].trim());
        }
        int k = Integer.parseInt(num[num.length - 1].trim());
        System.out.print(Arrays.toString(rotateRight(mas, k)));
        scanner.close();
    }

    public static int[] rotateRight(int[] mas, int k) {
        int[] buf = new int[mas.length];
        for (int i = 0; i < mas.length; i++) {
            buf[(i + k) % mas.length] = mas[i];
        }
        return buf;
    }

}
