
/*
Создайте программу, которая возвращает частоты всех слов в строке (без учёта регистра и без знаков препинания).
Примеры:
wordHistogram("Hello hello world") ➞ {hello: 2, world: 1} */
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordHistogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        LinkedHashMap<String, Integer> map = wordHistogram(str);

        System.out.print("{");
        boolean first = true;
        for (String key : map.keySet()) {
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(key + ": " + map.get(key));
            first = false;
        }
        System.out.println("}");

        scanner.close();
    }

    public static LinkedHashMap<String, Integer> wordHistogram(String str) {
        String[] words = str.split("\\s+");
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for (String word : words) {
            String key = word.toLowerCase();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return map;
    }
}
