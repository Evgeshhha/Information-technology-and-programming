import java.util.regex.*;

public class PasswordVerification {
    public static void main(String[] args) {
        try {
            String password = "asd12345678W";
            Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[A-Z])[A-Za-z0-9]{8,16}$");
            Matcher matcher = pattern.matcher(password);
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
