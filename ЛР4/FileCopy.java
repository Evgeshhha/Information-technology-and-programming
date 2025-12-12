import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String targetFile = "target.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(targetFile)) {
            int data;
            try {
                while ((data = fis.read()) != -1) {
                    fos.write(data);
                }
                System.out.println(sourceFile + " is copied to " + targetFile);
            } catch (IOException e) {
                System.out.println("Error when reading or writing a file:");// Ошибка при чтении или записи файла:
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error when opening or closing a file:");// Ошибка при открытии или закрытии файла:
            System.out.println(e.getMessage());
        }
    }
}