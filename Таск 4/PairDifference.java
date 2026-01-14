
/*
Создайте программу, которая возвращает количество пар чисел в массиве, разность которых равна k.
Примеры:
pairDifference([1,5,3,4,2], 2) ➞ 3 */
import java.util.Scanner;

public class PairDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        text = text.replace("[", "").replace("]", "");
        String[] text_mas = text.split(",");
        int[] mas = new int[text_mas.length - 1];
        for (int i = 0; i < text_mas.length - 1; i++) {
            mas[i] = Integer.parseInt(text_mas[i].trim());
        }
        System.out.println(pairDifference(mas, Integer.parseInt(text_mas[text_mas.length - 1].trim())));
        scanner.close();
    }

    public static int pairDifference(int[] mas, int k) {
        int res = 0;
        for (int i = 0; i < mas.length - 1; i++) {
            for (int j = i + 1; j < mas.length; j++) {
                if (Math.abs(mas[i] - mas[j]) == k) {
                    res += 1;
                }
            }
        }
        return res;
    }
}
