
/*
Напишите рекурсивную функцию, которая принимает строку и удаляет из неё символы, которые повторяются больше 3-ех раз. Функция должна вернуть строку, в которой нет таких символов. Регистр не учитывается.

Пример:

nonRepeat("abracadabra") ➞ " brcdbr"
 
nonRepeat("abababcac") ➞ "bbbcc"

*/
import java.util.HashMap;
import java.util.Scanner;

public class NonRepeat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.print(nonRepeat(str));
        scanner.close();
    }

    public static String nonRepeat(String str) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] mas_str = str.split("");
        String letter = "";
        for (int i = 0; mas_str.length > i; i++) {
            if (!hashMap.containsKey(mas_str[i])) {
                hashMap.put(mas_str[i], 1);
            } else {
                hashMap.put(mas_str[i], hashMap.get(mas_str[i]) + 1);
                if (hashMap.get(mas_str[i]) > 3) {
                    letter = mas_str[i];
                    str = str.replaceAll(letter, "");
                    break;
                }
            }
        }
        if (!"".equals(letter)) {
            return nonRepeat(str);
        }
        return str;
    }
}