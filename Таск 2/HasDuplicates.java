import java.util.Scanner;

public class HasDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.trim().isEmpty()) {
            System.out.print(false);
            scanner.close();
            return;
        }
        String[] num = line.split(",");
        int[] mas = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            mas[i] = Integer.parseInt(num[i].trim());
        }
        System.out.print(hasDuplicates(mas));
        scanner.close();
    }

    public static boolean hasDuplicates(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = i + 1; j < mas.length; j++) {
                if (mas[i] == mas[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
