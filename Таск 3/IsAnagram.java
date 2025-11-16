
/*
Создайте программу, которая принимает две строки и возвращает true, если одна является анаграммой другой (содержит те же буквы в любом порядке). Игнорируйте регистр букв.

Примеры:
isAnagram("listen", "silent") ➞ true
isAnagram("hello", "world") ➞ false
isAnagram("Dormitory", "Dirtyroom") ➞ true

Необходимо создать класс, метод решающий задачу и метод main. В методе main необходимо реализовать ввод с клавиатуры параметра и вывод результатов работы метода на экран.

Для примера:

Ввод	Результат
listen, silent
true
 */
import java.util.Scanner;
import java.util.Arrays;

public class IsAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] text_mas = text.split(", ");
        System.out.print(isAnagram(text_mas[0], text_mas[1]));
        scanner.close();
    }

    public static boolean isAnagram(String text1, String text2) {
        String[] mas1 = text1.split("");
        String[] mas2 = text2.split("");
        Arrays.sort(mas1);
        Arrays.sort(mas2);
        return Arrays.equals(mas1, mas2);
    }
}
