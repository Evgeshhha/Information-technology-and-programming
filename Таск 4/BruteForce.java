import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BruteForce {

    public static List<String> bruteForce(int n, int k) {
        List<String> result = new ArrayList<>();

        if (n > k || k > 5 || n <= 0 || k <= 0) {
            return result;
        }

        boolean[] used = new boolean[k];
        backtrack(n, k, new StringBuilder(), used, result);

        return result;
    }

    private static void backtrack(int n, int k,
            StringBuilder current,
            boolean[] used,
            List<String> result) {

        if (current.length() == n) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!used[i]) {
                used[i] = true;
                current.append(i);

                backtrack(n, k, current, used, result);

                current.deleteCharAt(current.length() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] parts = input.split(",");
        int n = Integer.parseInt(parts[0].trim());
        int k = Integer.parseInt(parts[1].trim());

        List<String> result = bruteForce(n, k);

        if (result.isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.println("[\"" + String.join("\",\"", result) + "\"]");
        }
        scanner.close();
    }
}
