/*
Создайте программу, которая принимает целое число и возвращает сумму его цифр.

Примеры:
sumOfDigits(123) ➞ 6
sumOfDigits(9045) ➞ 18
sumOfDigits(7) ➞ 7

Необходимо создать класс, метод решающий задачу и метод main. В методе main необходимо реализовать ввод с клавиатуры параметра и вывод результатов работы метода на экран.

Для примера:

Ввод	Результат
123
6
 */
import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.print(sumOfDigits(text));
        scanner.close();
    }

    public static int sumOfDigits(String text) {
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            sum += Integer.parseInt(String.valueOf(text.charAt(i)));
        }
        return sum;
    }
}