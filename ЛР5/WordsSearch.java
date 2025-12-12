import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsSearch {
    public static void main(String[] args) {
        try {
            String text = "ayyy a11/ kkkkaaee";
            char letter = 'a';
            Pattern pattern = Pattern.compile("(?<=^|\\s)[" + Character.toLowerCase(letter)
                    + Character.toUpperCase(letter) + "]\\w*(?=$|\\s)");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}