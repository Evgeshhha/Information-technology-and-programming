
/*
Создайте программу, которая возвращает разницу между наибольшим и наименьшим элементом массива.
Примеры:
differenceMaxMin(new int[]{10, 4, 1, 2, 8, 91}) ➞ 90
differenceMaxMin(new int[]{-70, 43, 34, 54, 22}) ➞ 124
Необходимо создать класс, метод решающий задачу и метод main. В методе main необходимо реализовать ввод с клавиатуры параметра и вывод результатов работы метода на экран.

Для примера:

Ввод	Результат
[10, 4, 1, 2, 8, 91]
90

 */
import java.util.Arrays;
import java.util.Scanner;

public class DifferenceMaxMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        System.out.print(differenceMaxMin(text));
        scanner.close();
    }

    public static int differenceMaxMin(String text) {
        String[] text_mas = text.replace("[", "").replace("]", "").split(",");
        int[] mas = new int[text_mas.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Integer.parseInt(text_mas[i].trim());
        }
        Arrays.sort(mas);
        return mas[mas.length - 1] - mas[0];
    }
}
