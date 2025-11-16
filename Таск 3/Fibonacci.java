
/*
Создайте программу, которая возвращает n-е число Фибоначчи (начиная с 0, 1, 1, 2, 3, 5, …).  Реализовать рекурсивно!
Примеры:
fibonacci(0) ➞ 0
fibonacci(5) ➞ 5
fibonacci(8) ➞ 21
Необходимо создать класс, метод решающий задачу и метод main. В методе main необходимо реализовать ввод с клавиатуры параметра и вывод результатов работы метода на экран.

Для примера:

Ввод	Результат
0
0
 */
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.print(fibonacci(num));
        scanner.close();
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }
}
