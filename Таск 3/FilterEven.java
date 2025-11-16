
/*
Создайте программу, которая принимает массив чисел и возвращает новый массив, содержащий только чётные числа.
Примеры:
filterEven(new int[]{1, 2, 3, 4, 5, 6}) ➞ [2, 4, 6]
filterEven(new int[]{13, 17, 19}) ➞ []
filterEven(new int[]{10, 20, 30, 41}) ➞ [10, 20, 30]
Необходимо создать класс, метод решающий задачу и метод main. В методе main необходимо реализовать ввод с клавиатуры параметра и вывод результатов работы метода на экран.

Для примера:

Ввод	Результат
[1, 2, 3, 4, 5, 6]
[2, 4, 6]
 */
import java.util.Scanner;
import java.util.ArrayList;

public class FilterEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.print(filterEven(text).toString());
        scanner.close();
    }

    public static ArrayList<Integer> filterEven(String text) {
        String[] text_mas = text.replace("[", "").replace("]", "").split(",");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < text_mas.length; i++) {
            if (Integer.parseInt(text_mas[i].trim()) % 2 == 0) {
                arrayList.add(Integer.parseInt(text_mas[i].trim()));
            }
        }
        return arrayList;
    }
}
