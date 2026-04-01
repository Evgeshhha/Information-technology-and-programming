package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Программа запущена");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String text = scanner.nextLine();

        String reversed = StringUtils.reverse(text);
        String capitalized = StringUtils.capitalize(text);

        logger.info("Исходная строка: {}", text);
        logger.info("Перевернутая строка: {}", reversed);
        logger.info("С заглавной буквы: {}", capitalized);

        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("build-passport.properties")) {

            if (input != null) {
                Properties props = new Properties();
                props.load(input);

                logger.info("=== Build Passport ===");
                logger.info("User: {}", props.getProperty("username"));
                logger.info("OS: {}", props.getProperty("os"));
                logger.info("Java: {}", props.getProperty("java_version"));
                logger.info("Build time: {}", props.getProperty("build_time"));
                logger.info("Message: {}", props.getProperty("message"));
            } else {
                logger.warn("build-passport.properties not found");
            }

        } catch (Exception e) {
            logger.error("Error reading build passport", e);
        }
        scanner.close();
        logger.info("Программа завершена");
    }
}