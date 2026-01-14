import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Max {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[][] mas = { { 3, 7, 8 }, { 7, 1, 3 }, { 5, 6, 9 } };
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> firstPart = executor.submit(() -> {
            int max = mas[0][0];
            for (int i = 0; i < mas.length / 2; i++) {
                for (int j = 0; j < mas[0].length; j++) {
                    if (max < mas[i][j]) {
                        max = mas[i][j];
                    }
                }
            }
            return max;
        });

        Future<Integer> secondPart = executor.submit(() -> {
            int max = mas[mas.length / 2][0];
            for (int i = mas.length / 2; i < mas.length; i++) {
                for (int j = 0; j < mas[0].length; j++) {
                    if (max < mas[i][j]) {
                        max = mas[i][j];
                    }
                }
            }
            return max;
        });

        System.out.println("Максимальное число: " + Math.max(firstPart.get(), secondPart.get()));

        executor.shutdown();
    }
}
