import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterSearch {
    public static void main(String[] args) {
        try {
            String text = "xc czZ XxxX  nn";
            Pattern pattern = Pattern.compile("[a-z][A-Z]");
            Matcher matcher = pattern.matcher(text);

            StringBuilder result = new StringBuilder();

            while (matcher.find()) {
                matcher.appendReplacement(result, "!" + matcher.group() + "!");
                // Добавляет текст до совпадения
                // Заменяет совпадение
            }
            matcher.appendTail(result);// добавляет остаток текста после последнего
            // совпадения

            // String res = matcher.replaceAll("!$0!");

            System.out.println(result.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
