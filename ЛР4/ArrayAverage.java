public class ArrayAverage {
    public static void main(String[] args) {
        int[] int_arr = { 1, 2, 3, 4, 4 };
        String[] String_arr = { "1", "2", "3", "4", "5" };
        // String[] String_arr = { "1", "2", "three", "4", "5" };
        int sum = 0;
        try {
            // Правильный
            for (int i = 0; i < int_arr.length; i++) {
                sum += int_arr[i];
            }
            double avg = (double) sum / int_arr.length;
            System.out.println("Array Average: " + avg);

            // ArithmeticException
            // System.out.println(sum / 0);

            // IllegalArgumentException
            sum = 0;
            for (int i = 0; i < String_arr.length; i++) {
                sum += Integer.parseInt(String_arr[i]);
            }
            avg = (double) sum / String_arr.length;
            System.out.println("Array Average: " + avg);

            // ArrayIndexOutOfBoundsException
            sum = 0;
            for (int i = 0; i <= int_arr.length; i++) {
                sum += int_arr[i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error:\nGoing beyond the boundaries of the array\n" + e.getMessage());
            // Выход за границы массива
        } catch (ArithmeticException e) {
            System.out.println("Error:\nDivision by zero or other arithmetic error\n" + e.getMessage());
            // Деление на ноль или другая арифметическая ошибка
        } catch (IllegalArgumentException e) {
            System.out.println("Error:\nPassing an inappropriate argument to a method\n" + e.getMessage());
            // передача неподобающего аргумента в метод
        }
    }
}
