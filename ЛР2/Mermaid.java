public class Mermaid extends Monster {
    private double tailLength; // длина хвоста
    private String hairColor; // цвет волос
    private int vocalEvaluation; // оценка вокала

    public Mermaid(String name, String habitat, String notableFeatures,
            double tailLength, String hairColor, int vocalEvaluation) {
        super(name, habitat, notableFeatures);
        this.tailLength = tailLength;
        this.hairColor = hairColor;
        this.vocalEvaluation = vocalEvaluation;
    }

    public Mermaid() {
        this("Mermaid", "unknown", "unknown",
                0.0, "unknown", 0);
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public int getVocalEvaluation() {
        return vocalEvaluation;
    }

    public void setVocalEvaluation(int vocalEvaluation) {
        this.vocalEvaluation = vocalEvaluation;
    }

    @Override
    public String getMovement() {
        return getName() + " floating"; // плывет
    }

    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("tail Length: " + tailLength
                + "\nhair Color: " + hairColor
                + "\nvocalEvaluation: " + vocalEvaluation);
    }
}
