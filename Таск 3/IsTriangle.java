
/*
Создайте программу, которая принимает три числа (длины сторон) и возвращает true, если из них можно составить треугольник, иначе false. (По правилу треугольника: сумма любых двух сторон больше третьей.)
Примеры:
isTriangle(3, 4, 5) ➞ true
isTriangle(1, 2, 3) ➞ false
isTriangle(10, 15, 30) ➞ false
Необходимо создать класс, метод решающий задачу и метод main. В методе main необходимо реализовать ввод с клавиатуры параметра и вывод результатов работы метода на экран.

Для примера:

Ввод	Результат
3, 4, 5
true
 */
import java.util.Scanner;

public class IsTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        System.out.print(isTriangle(text));
        scanner.close();
    }

    public static boolean isTriangle(String text) {
        String[] text_mas = text.split(",");
        int[] mas = new int[text_mas.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Integer.parseInt(text_mas[i].trim());
        }
        if (mas[0] + mas[1] > mas[2] && mas[0] + mas[2] > mas[1] && mas[2] + mas[1] > mas[0]) {
            return true;
        }
        return false;
    }
}
