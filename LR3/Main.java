public class Main {
    public static void main(String[] args) {
        // Задание 1
        System.out.println("Task 1");
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        System.out.println(hashTable.size());
        System.out.println(hashTable.isEmpty());

        System.out.println();

        hashTable.put("apple", null);
        System.out.println(hashTable.get("apple"));
        System.out.println(hashTable.size());
        System.out.println(hashTable.isEmpty());
        System.out.println();

        hashTable.remove("apple");
        System.out.println(hashTable.size());
        System.out.println(hashTable.isEmpty());
        System.out.println();

        hashTable.put("banana", 3);
        System.out.println(hashTable.get("banana"));

        hashTable.put("pear", 2);
        System.out.println(hashTable.get("pear"));

        hashTable.put("orange", 7);
        System.out.println(hashTable.get("orange"));
        System.out.println(hashTable.size());
        System.out.println(hashTable.isEmpty());
        System.out.println();

        // Задание 2
        System.out.println("Task 2");
        Library library = new Library();

        Book book1 = new Book("War and Peace", "Leo Tolstoy", 5);
        Book book2 = new Book("Crime and Punishment", "Fyodor Dostoevsky", 3);

        library.add("1234", book1);
        library.add("123456", book2);
        library.search("1234");
        library.del("1234");
        library.search("1234");

    }
}
