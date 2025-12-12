import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ExceptionLogger {

    private static final String LOG_FILE = "errors.log";

    // Метод логирования исключения в файл
    public static void log(Exception e) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write("=== ERROR ===\n");
            fw.write("Timestamp: " + LocalDateTime.now() + "\n");
            fw.write("Exception Type: " + e.getClass().getName() + "\n");
            fw.write("Message: " + e.getMessage() + "\n\n");
        } catch (IOException io) {
            System.out.println("Error when writing to the log file: " + io.getMessage());
            // Ошибка при записи в лог-файл:
        }
    }
}
