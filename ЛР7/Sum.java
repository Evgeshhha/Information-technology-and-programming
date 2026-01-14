import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
InterruptedException
— если главный поток был прерван

ExecutionException
— если внутри Callable.call() возникло исключение
 */
public class Sum {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] mas = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> firstPart = executor.submit(() -> {
            int sum = 0;
            for (int i = 0; i < mas.length / 2; i++) {
                sum += mas[i];
            }
            return sum;
        });

        Future<Integer> secondPart = executor.submit(() -> {
            int sum = 0;
            for (int i = mas.length / 2; i < mas.length; i++) {
                sum += mas[i];
            }
            return sum;
        });

        int totalSum = firstPart.get() + secondPart.get();
        System.out.println("Общая сумма: " + totalSum);

        executor.shutdown();
    }
}
