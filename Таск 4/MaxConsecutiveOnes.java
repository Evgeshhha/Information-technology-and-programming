
/*
Создайте программу, которая возвращает длину самой длинной последовательности подряд идущих 1 в массиве, состоящем из 0 и 1.
Примеры:
maxConsecutiveOnes([1,1,0,1,1,1]) ➞ 3 */
import java.util.Scanner;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        text = text.replace("[", "").replace("]", "");
        String[] text_mas = text.split(",");
        int[] mas = new int[text_mas.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Integer.parseInt(text_mas[i].trim());
        }
        System.out.println(maxConsecutiveOnes(mas));
        scanner.close();
    }

    public static int maxConsecutiveOnes(int[] mas) {
        int max = 0;
        int res_max = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == 1) {
                max += 1;
            }
            if (res_max < max) {
                res_max = max;
            }
            if (mas[i] == 0) {
                max = 0;
            }

        }
        return res_max;
    }
}
