import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckingIP {
    public static void main(String[] args) {
        try {
            String ip = "1.1.10.1";
            Pattern pattern = Pattern
                    .compile("^((25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9])$");
            Matcher matcher = pattern.matcher(ip);
            if (matcher.matches()) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
