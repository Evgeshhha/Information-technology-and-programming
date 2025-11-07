public abstract class Monster {
    private String name;
    protected String habitat; // естественная среда обитания
    protected String notableFeatures; // отличительные черты
    private static int monsterCount = 0; // счетчик монсторов

    public Monster(String name, String habitat, String notableFeatures) {
        this.name = name;
        this.habitat = habitat;
        this.notableFeatures = notableFeatures;
        monsterCount++;
    }

    public Monster() {
        this("Monster", "unknown", "unknown");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getNotableFeatures() {
        return notableFeatures;
    }

    public void setNotableFeatures(String notableFeatures) {
        this.notableFeatures = notableFeatures;
    }

    public static int getMonsterCount() {
        return monsterCount;
    };

    public void printDescription() {
        System.out.println("name: " + getName()
                + "\nhabitat: " + habitat +
                "\nnotable Features: " + notableFeatures);
    }

    abstract String getMovement();

}