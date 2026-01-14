
/*
Реализуйте в классе метод Decode реализующий алгоритм шифрования Вернама. Decode принимает строку и ключ, возвращает массив чисел. 
Пример:
decode("MTUCI","MKIIT") ➞ [0, 31, 28, 10, 29] */
import java.util.Arrays;

public class Decode {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decode("MTUCI", "MKIIT")));
    }

    public static int[] decode(String str, String key) {
        int[] mas = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            String binaryStr = Integer.toBinaryString((int) str.charAt(i));
            String binaryKey = Integer.toBinaryString((int) key.charAt(i));
            String binaryNewStr = "";
            if (binaryStr.equals(binaryKey)) {
                mas[i] = 0;
            } else {
                for (int j = 0; j < binaryStr.length(); j++) {
                    String[] mas_binaryStr = binaryStr.split("");
                    String[] mas_binaryKey = binaryKey.split("");
                    if (mas_binaryStr[j].equals(mas_binaryKey[j])) {
                        binaryNewStr += 0;
                    } else {
                        binaryNewStr += 1;
                    }
                }
                mas[i] = Integer.parseInt(binaryNewStr, 2);
            }
        }
        return mas;
    }
}
