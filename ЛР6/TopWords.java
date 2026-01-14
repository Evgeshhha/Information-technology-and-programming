import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class TopWords {
    public static void main(String[] args) {
        // указываем путь к файлу
        String filePath = "text.txt";
        // создаем объект File
        File file = new File(filePath);
        // создаем объект Scanner для чтения файла
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, Integer> wordCountMap = new HashMap<>();

        // читаем файл по словам и добавляем их в Map
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                // V getOrDefault(Object k, V defaultValue): возвращает значение объекта, ключ
                // которого равен k. Если такого элемента не окажется, то возвращается значение
                // defaultVlue

                // V put(K k, V v): помещает в коллекцию новый объект с ключом k и значением v.
                // Если в коллекции уже есть объект с подобным ключом, то он перезаписывается.
                // После добавления возвращает предыдущее значение для ключа k, если он уже был
                // в коллекции. Если же ключа еще не было в коллекции, то возвращается значение
                // null
            }
        }
        scanner.close();
        // создаем список из элементов Map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());
        /*
         * List<Map.Entry<String, Integer>>
         * Тип переменной list. Это список (List) объектов Map.Entry<String, Integer>.
         * 
         * Map.Entry<String, Integer> — это одна пара: слово (String) и количество
         * (Integer).
         * 
         * new ArrayList<>(...)
         * Создаём новый список (ArrayList) из коллекции, которую передаём в
         * конструктор.
         * 
         * wordCountMap.entrySet()
         * Метод entrySet() возвращает все пары ключ → значение
         * из Map в виде набора (Set) объектов Map.Entry<String, Integer>.
         * 
         * мы берём Map (словарь), превращаем его в список пар, чтобы потом
         * можно было сортировать по количеству.
         */

        // сортируем список по убыванию количества повторений
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                    Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        /*
         * new Comparator<Map.Entry<String, Integer>>() { ... } Создаём анонимный объект
         * Comparator, который определяет правило сравнения двух элементов списка.
         * 
         * public int compare(...)
         * Метод, который сравнивает две пары (o1 и o2)
         * 
         * Map.Entry<String, Integer> o1, o2
         * Два элемента списка, которые нужно сравнить. Каждый — пара слово →
         * количество.
         * 
         * o2.getValue()
         * Берём количество второго слова.
         * .compareTo(o1.getValue())
         * Сравниваем его с количеством первого слова. Возвращает: <0, 0 или >0.
         */

        // выводим топ-10 слов
        int limit = Math.min(10, list.size());
        for (int i = 0; i < limit; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
