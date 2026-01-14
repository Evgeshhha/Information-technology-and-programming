import java.util.Scanner;

public class Decode_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();

        int commaIndex = -1;
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                commaIndex = i;
                break;
            }
        }

        if (commaIndex == -1) {
            System.out.println("[]");
            return;
        }

        String str = line.substring(0, commaIndex).trim().replace(" ", "");
        String key = line.substring(commaIndex + 1).trim().replace(" ", "");

        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1);
        }
        if (key.startsWith("\"") && key.endsWith("\"")) {
            key = key.substring(1, key.length() - 1);
        }

        int[] numbers = decode(str, key);

        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] decode(String str, String key) {
        int[] result = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            int charCode = str.charAt(i);
            int keyCode = key.charAt(i % key.length());
            result[i] = charCode ^ keyCode;
        }

        return result;
    }

}
