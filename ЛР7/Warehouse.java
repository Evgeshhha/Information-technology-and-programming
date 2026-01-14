import java.util.*;
import java.util.concurrent.Semaphore;

public class Warehouse {

    // Очередь товаров на складе.
    // Каждый элемент — вес одного товара.
    private static final Queue<Integer> goods = new LinkedList<>();

    // mutex — семафор-взаимоисключение (binary semaphore).
    // Разрешает доступ к общим данным (goods, currentWeight)
    // только одному потоку-грузчику одновременно.
    private static final Semaphore mutex = new Semaphore(1);

    // unloadMutex — отдельный семафор для операции разгрузки.
    // Гарантирует, что разгрузка выполняется строго одним потоком.
    private static final Semaphore unloadMutex = new Semaphore(1);

    // Текущий общий вес товаров, который уже погрузили грузчики
    private static int currentWeight = 0;

    // Максимально допустимый вес для перевозки за один раз
    private static final int MAX_WEIGHT = 150;

    // Флаг, показывающий, что в данный момент выполняется разгрузка
    private static boolean unloading = false;

    public static void main(String[] args) {

        // Инициализация склада:
        // добавляем товары с заданным весом в очередь
        goods.addAll(List.of(
                140, 30, 40, 20, 50, 100, 60, 25, 35, 45, 100));

        // Создаём и запускаем три потока-грузчика
        new Thread(new Loader(1)).start();
        new Thread(new Loader(2)).start();
        new Thread(new Loader(3)).start();
    }

    // Класс грузчика, реализующий интерфейс Runnable
    static class Loader implements Runnable {

        // Идентификатор грузчика (для вывода в консоль)
        private final int id;

        Loader(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                // Грузчик работает, пока есть товары
                while (true) {

                    // Захватываем mutex,
                    // чтобы безопасно работать с общими данными
                    mutex.acquire();

                    // Если склад пуст,
                    // освобождаем mutex и выполняем финальную разгрузку
                    if (goods.isEmpty()) {
                        mutex.release();
                        unload();
                        break; // Завершаем поток
                    }

                    // Смотрим вес следующего товара,
                    // но пока не забираем его из очереди
                    int weight = goods.peek();

                    // Если текущий вес + вес товара превышает лимит,
                    // нужно сначала выполнить разгрузку
                    if (currentWeight + weight > MAX_WEIGHT) {
                        mutex.release();
                        unload();
                        continue; // После разгрузки пробуем снова
                    }

                    // Забираем товар из очереди
                    goods.poll();

                    // Увеличиваем текущий вес
                    currentWeight += weight;

                    // Выводим информацию о взятом товаре
                    System.out.println(
                            "Грузчик " + id +
                                    " взял товар весом " + weight +
                                    " кг (всего " + currentWeight + " кг)");

                    // Проверяем, достигнут ли максимальный вес
                    boolean needUnload = currentWeight == MAX_WEIGHT;

                    // Освобождаем mutex,
                    // так как критическая секция закончилась
                    mutex.release();

                    // Если вес ровно равен лимиту — выполняем разгрузку
                    if (needUnload) {
                        unload();
                    }

                    // Имитация времени работы грузчика
                    Thread.sleep(300);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Метод разгрузки товаров
        private void unload() throws InterruptedException {

            // Захватываем семафор разгрузки
            unloadMutex.acquire();

            // Если разгрузка уже идёт
            // или разгружать нечего — выходим
            if (unloading || currentWeight == 0) {
                unloadMutex.release();
                return;
            }

            // Помечаем, что разгрузка началась
            unloading = true;

            // Запоминаем вес, который везут на другой склад
            int weightToUnload = currentWeight;

            System.out.println(
                    "\nГрузчики везут " + weightToUnload + " кг на другой склад...");

            // Обнуляем текущий вес после разгрузки
            currentWeight = 0;

            // Снимаем флаг разгрузки
            unloading = false;

            System.out.println(
                    "Разгрузка завершена. Грузчики вернулись.\n");

            // Освобождаем семафор разгрузки
            unloadMutex.release();

            // Имитация времени разгрузки
            Thread.sleep(300);
        }
    }
}
