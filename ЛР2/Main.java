public class Main {
    public static void main(String[] args) {
        Goblin goblin = new Goblin("Goblin", "Cave", "Green and sneaky", 0.4, 1.1, 0.3);
        Mermaid mermaid = new Mermaid("Ariel", "Sea", "Beautiful voice", 2.0, "red", 10);
        Dragon dragon = new Dragon("Smaug", "Mountain", "Fire-breathing", 6.0, 3.5, 3);
        Wyvern wyvern = new Wyvern("Twinfang", "Cliffs", "Swift and deadly", 4.5, 2.8);
        Wyvern wyvern2 = new Wyvern();
        Monster monster = new Goblin(); // upcasting (повышающее преобразование)

        goblin.printDescription();
        System.out.println(goblin.getMovement());
        System.out.println();

        mermaid.printDescription();
        System.out.println(mermaid.getMovement());
        System.out.println();

        dragon.printDescription();
        System.out.println(dragon.getMovement());
        System.out.println(dragon.getMovement(100));
        System.out.println();

        wyvern.printDescription();
        System.out.println(wyvern.getMovement());
        System.out.println();

        wyvern2.printDescription();
        System.out.println(wyvern2.getMovement());
        System.out.println();

        if (monster instanceof Goblin) { // инструкцию instanceof для проверки наследования между объектами
            Goblin goblin2 = (Goblin) monster; // downcasting (понижающее преобразование)
            goblin2.printDescription();
            System.out.println(goblin2.getMovement());
            System.out.println();

        }
        System.out.println("Total monsters created: " + Monster.getMonsterCount());
        // System.out.println("Total monsters created: " + Monster.monsterCount);
    }
}
