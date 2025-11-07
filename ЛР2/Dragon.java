public class Dragon extends Monster {
    protected double wingLength; // длина крыльев
    protected double wingWidth; // ширина крыльев
    protected int numberHeads; // количество голов

    public Dragon(String name, String habitat, String notableFeatures,
            double wingLength, double wingWidth, int numberHeads) {
        super(name, habitat, notableFeatures);
        this.wingLength = wingLength;
        this.wingWidth = wingWidth;
        this.numberHeads = numberHeads;
    }

    public Dragon() {
        this("unknown", "unknown", "unknown",
                0.0, 0.0, 0);
    }

    public double getWingLength() {
        return wingLength;
    }

    public void setWingLength(double wingLength) {
        this.wingLength = wingLength;
    }

    public double getWingWidth() {
        return wingWidth;
    }

    public void setWingWidth(double wingWidth) {
        this.wingWidth = wingWidth;
    }

    public int getNumberHeads() {
        return numberHeads;
    }

    public void setNumberHeads(int numberHeads) {
        this.numberHeads = numberHeads;
    }

    @Override
    public String getMovement() {
        return getName() + " flies"; // летает
    }

    public String getMovement(double distance) {// растояние
        return getName() + " flies at a distance " + distance; // летает
    }

    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("wingLength: " + wingLength
                + "\nwingWidth: " + wingWidth
                + "\nnumberHeads: " + numberHeads);
    }
}
