
/*
Создайте программу, которая возвращает массив из 10 элементов — количество каждой цифры (0–9) в числе.
Примеры:
digitHistogram(1203405) ➞ [1,1,1,1,0,1,0,0,0,0]
*/
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class DigitHistogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String res = Arrays.toString(digitHistogram(num));
        System.out.println(res.replace(" ", ""));
        scanner.close();
    }

    public static int[] digitHistogram(int num) {
        int[] res = new int[10];
        ArrayList<Integer> num_mas = new ArrayList<>();
        while (num != 0) {
            num_mas.add(num % 10);
            num = num / 10;
        }
        for (int i = 0; i < num_mas.size(); i++) {
            res[num_mas.get(i)] += 1;
        }
        return res;
    }
}
