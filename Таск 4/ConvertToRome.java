
/*
Напишите функцию, принимающую положительное целое число, не превышающее 1502, и возвращающую его представление в римской системе счисления.
Пример:
convertToRome(8) ➞ "VIII"

convertToRome(1234) ➞ "MCCXXXIV"

convertToRome(52) ➞ "LII" */
import java.util.Scanner;

public class ConvertToRome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num <= 1502) {
            System.out.println(convertToRome(num));
        }
        scanner.close();
    }

    public static String RomeAlphabet(int num) {
        if (num == 1)
            return "I";
        else if (num == 4)
            return "IV";
        else if (num == 5)
            return "V";
        else if (num == 9)
            return "IX";
        else if (num == 10)
            return "X";
        else if (num == 40)
            return "XL";
        else if (num == 50)
            return "L";
        else if (num == 90)
            return "XC";
        else if (num == 100)
            return "C";
        else if (num == 400)
            return "CD";
        else if (num == 500)
            return "D";
        else if (num == 900)
            return "CM";
        else if (num == 1000)
            return "M";
        return "";
    }

    public static String convertToRome(int num) {
        String num_rome = "";
        int[] alp_mas = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        for (int i = 0; i < alp_mas.length; i++) {
            while (num - alp_mas[i] >= 0) {
                num_rome += RomeAlphabet(alp_mas[i]);
                num = num - alp_mas[i];
            }
        }
        return num_rome;
    }
}
