public class Goblin extends Monster {
    private double noseLength; // длина носа
    private double height; // рост
    private double footSize; // размер ноги

    public Goblin(String name, String habitat, String notableFeatures,
            double noseLength, double height, double footSize) {
        super(name, habitat, notableFeatures);
        this.noseLength = noseLength;
        this.height = height;
        this.footSize = footSize;
    }

    public Goblin() {
        this("unknown", "unknown", "unknown",
                0.0, 0.0, 0.0);
    }

    public double getNoseLength() {
        return noseLength;
    }

    public void setNoseLength(double noseLength) {
        this.noseLength = noseLength;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getFootSize() {
        return footSize;
    }

    public void setFootSize(double footSize) {
        this.footSize = footSize;
    }

    @Override
    public String getMovement() {
        return getName() + " goes"; // ходит
    }

    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("nose Length: " + noseLength
                + "\nheight: " + height
                + "\nfoot Size: " + footSize);
    }
}
