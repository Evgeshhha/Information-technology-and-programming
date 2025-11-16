
/*
Создайте программу, которая считает количество слов в строке. Слова разделяются одним или несколькими пробелами.
Примеры:
countWords("Hello world") ➞ 2
countWords("Java is great language") ➞ 4
countWords("   multiple   spaces   ") ➞ 2


Необходимо создать класс, метод решающий задачу и метод main. В методе main необходимо реализовать ввод с клавиатуры параметра и вывод результатов работы метода на экран.

Для примера:

Ввод	Результат
Hello world
2
 */
import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.print(countWords(text));
        scanner.close();
    }

    public static int countWords(String text) {
        String[] text_mas = text.replaceAll("\\s+", " ").trim().split(" ");
        return text_mas.length;
    }
}
