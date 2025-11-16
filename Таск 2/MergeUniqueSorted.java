import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class MergeUniqueSorted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        line = line.replace("[", "");
        line = line.replace("]", "");
        String[] parts = line.split(",");
        ArrayList<Integer> mas = new ArrayList<>();
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].trim();
            if (!part.isEmpty()) {
                mas.add(Integer.parseInt(parts[i].trim()));
            }
        }
        ArrayList<Integer> result = mergeUniqueSorted(mas);
        System.out.print(result.toString().replace(" ", ""));
        scanner.close();
    }

    public static ArrayList<Integer> mergeUniqueSorted(ArrayList<Integer> mas) {
        Collections.sort(mas);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(mas.get(0));

        for (int i = 1; i < mas.size(); i++) {
            if (!mas.get(i).equals(mas.get(i - 1))) {
                result.add(mas.get(i));
            }
        }
        return result;
    }
}
