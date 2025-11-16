
/*
Создайте программу, которая считает количество гласных букв (a, e, i, o, u) в строке.

Примеры:
countVowels("Celebration") ➞ 5
countVowels("Palm") ➞ 1
countVowels("Crypt") ➞ 0

Необходимо создать класс, метод решающий задачу и метод main. В методе main необходимо реализовать ввод с клавиатуры параметра и вывод результатов работы метода на экран.

Для примера:

Ввод	Результат
Celebration
5

 */
import java.util.Scanner;

public class CountVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.print(countVowels(text));
        scanner.close();
    }

    public static int countVowels(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if ("aeiou".contains(String.valueOf(text.charAt(i)).toLowerCase())) {
                count++;
            }
        }
        return count;
    }
}
