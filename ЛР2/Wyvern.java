public class Wyvern extends Dragon {
    public Wyvern(String name, String habitat, String notableFeatures,
            double wingLength, double wingWidth) {
        super(name, habitat, notableFeatures,
                wingLength, wingWidth, 2);
    }

    public Wyvern() {
        this("unknown", "unknown", "unknown",
                0.0, 0.0);
    }

    @Override
    public String getMovement() {
        return getName() + " flies with two heads"; // летает с двумя головами
    }

    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("Type: Wyvern");
    }
}
