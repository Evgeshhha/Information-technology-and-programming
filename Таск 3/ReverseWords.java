
/*
Создайте программу, которая принимает строку и возвращает её со словами в обратном порядке. Все слова разделены пробелами.

Примеры:
reverseWords("Hello World") ➞ "World Hello"
reverseWords("Java is fun") ➞ "fun is Java"
reverseWords("a b c d") ➞ "d c b a"

Необходимо создать класс, метод решающий задачу и метод main. В методе main необходимо реализовать ввод с клавиатуры параметра и вывод результатов работы метода на экран.

Для примера:

Ввод	Результат
Hello World
World Hello

 */
import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.print(reverseWords(text));
        scanner.close();
    }

    public static String reverseWords(String text) {
        String[] text_mas = text.split(" ");
        String text_new = "";
        for (int i = text_mas.length - 1; i >= 0; i--) {
            text_new += text_mas[i] + " ";
        }
        return text_new;
    }
}
