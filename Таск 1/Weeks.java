import java.util.Scanner;

public class Weeks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        System.out.println(daysToWeeks(day));
        scanner.close();

    }

    public static String daysToWeeks(int d) {
        int week = d / 7;
        int day = d % 7;
        String buf = "";
        if (week % 10 == 1 && week % 100 != 11) {
            buf = week + " неделя и ";
        } else if ((week % 10 >= 2 && week % 10 <= 4)
                && !(week % 100 >= 12 && week % 100 <= 14)) {
            buf = week + " недели и ";
        } else {
            buf = week + " недель и ";
        }

        if (day % 10 == 1) {
            buf += day + " день";
        } else if (day % 10 >= 2 && day % 10 <= 4) {
            buf += day + " дня";
        } else {
            buf += day + " дней";
        }
        return buf;
    }
}
