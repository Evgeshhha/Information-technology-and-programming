import java.util.*;

/*
TreeSet — это множество (Set), элементы которого всегда отсортированы.


Интерфейс SortedSet предназначен для создания коллекций, 
который хранят элементы в отсортированном виде (сортировка по возрастанию). 
SortedSet расширяет интерфейс Set, 
поэтому такая коллекция опять же хранит только уникальные значения.

Интерфейс NavigableSet расширяет интерфейс SortedSet и 
позволяет извлекать элементы на основании их значений. 

Обобщенный класс TreeSet<E> представляет структуру данных в виде дерева, 
в котором все объекты хранятся в отсортированном виде по возрастанию. 
TreeSet является наследником класса AbstractSet и реализует интерфейс NavigableSet, 
а следовательно, и интерфейс SortedSet.

*/
public class SalesStore {
    private TreeSet<Product> product;

    public SalesStore() {
        product = new TreeSet<>();
    }

    public void addProduct(String name, double price, int count) {
        for (Product p : product) {
            if (p.getName().equalsIgnoreCase(name)) {
                p.sell(price, count);
                return;
            }
        }
        Product p = new Product(name, price);
        p.sell(price, count);
        product.add(p);
    }

    public TreeSet<Product> setProducts() {
        return product;
    }

    public double sumSales() {
        double sum = 0;
        for (Product p : product) {
            sum += p.getPrice() * p.getCount();
        }
        return sum;
    }

    public Product popularProduct() {
        if (product.isEmpty())
            return null;
        Product popular = product.first();
        for (Product p : product) {
            if (p.getCount() > popular.getCount()) {
                popular = p;
            }
        }
        return popular;
    }

}
/*
 * множество (Set) — это структура данных, которая хранит уникальные элементы.
 * 
 * 
 * Порядок Уникальность Потокобезопасность Сортировка
 * ArrayList
 * Да Нет Нет Нет
 * LinkedList
 * Да Нет Нет Нет
 * HashSet
 * Нет Да Нет Нет
 * TreeSet
 * Да (сорт.) Да Нет Да
 * HashMap
 * Нет Ключ уникален Нет Нет
 * TreeMap
 * Да (сорт.) Ключ уникален Нет Да
 * LinkedHashMap
 * Да Ключ уникален Нет Нет
 * ConcurrentHashMap
 * Нет Ключ уникален Да Нет
 * CopyOnWriteArrayList
 * Да Нет Да Нет
 */