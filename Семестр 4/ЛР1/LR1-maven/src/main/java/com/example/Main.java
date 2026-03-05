package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Goblin goblin = new Goblin("Goblin", "Cave", "Green and sneaky", 0.4, 1.1, 0.3);
        Mermaid mermaid = new Mermaid("Ariel", "Sea", "Beautiful voice", 2.0, "red", 10);
        Dragon dragon = new Dragon("Smaug", "Mountain", "Fire-breathing", 6.0, 3.5, 3);
        Wyvern wyvern = new Wyvern("Twinfang", "Cliffs", "Swift and deadly", 4.5, 2.8);
        Wyvern wyvern2 = new Wyvern();

        goblin.printDescription();
        logger.info(goblin.getMovement());

        mermaid.printDescription();
        logger.info(mermaid.getMovement());

        dragon.printDescription();
        logger.info(dragon.getMovement());
        logger.info(dragon.getMovement(100));

        wyvern.printDescription();
        logger.info(wyvern.getMovement());

        wyvern2.printDescription();
        logger.info(wyvern2.getMovement());

        logger.info("Total monsters created: " + Monster.getMonsterCount());

        try {
            String json = Serializer.toJson(goblin);
            logger.info("Сериализованный JSON: {}", json);

            Goblin restored = Serializer.fromJson(json, Goblin.class);
            logger.info("Десериализованный объект: {}", restored);
        } catch (Exception e) {
            logger.error("Ошибка при сериализации", e);
        }
    }
}
