import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        try {
            /*
             * Lookaround (lookbehind + lookahead)
             * (?<=...)
             * Слева должно быть ...
             * (?<!...)
             * Слева не должно быть ...
             * (?=...)
             * Справа должно быть ...
             * (?!...)
             * Справа не должно быть ...
             */
            String text = "1 The price   +2тт --3 - + 4 of the1,2product is $19.991111+11111 11/11 g 5.1 6,2 -7 +8 .9 ";
            Pattern pattern = Pattern.compile("(?<=^|\\s)[+-]?\\d+([\\.,]\\d+)?(?=$|\\s)");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}