
/*
Создайте программу, которая возвращает второе по величине число в массиве.

Примеры:
secondLargest(new int[]{10, 40, 30, 20, 50}) ➞ 40
secondLargest(new int[]{25, 143, 89, 13, 105}) ➞ 105
secondLargest(new int[]{54, 23, 11, 17, 10}) ➞ 23

Необходимо создать класс, метод решающий задачу и метод main. В методе main необходимо реализовать ввод с клавиатуры параметра и вывод результатов работы метода на экран.

Для примера:

Ввод	Результат
[10, 40, 30, 20, 50]
40

 */
import java.util.Arrays;
import java.util.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.print(secondLargest(text));
        scanner.close();
    }

    public static int secondLargest(String text) {
        text = text.replace("[", "").replace("]", "");
        String[] text_mas = text.split(",");
        int[] mas = new int[text_mas.length];
        for (int i = 0; i < text_mas.length; i++) {
            mas[i] = Integer.parseInt(text_mas[i].trim());
        }
        Arrays.sort(mas);

        return mas[mas.length - 2];
    }
}
