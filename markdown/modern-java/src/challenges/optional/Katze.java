package challenges.optional;

public class Katze {
    private String name;
    private float gewicht;
    private Box lieblingsBox;

    /**
     * @param name Name der Katze
     * @param gewicht Gewicht der Katze in kg
     * @param lieblingsBox Lieblingsbox der Katze
     */
    public Katze(String name, float gewicht, Box lieblingsBox) {
        this.name = name;
        this.gewicht = gewicht;
        this.lieblingsBox = lieblingsBox;
    }

    public String name() {
        return name;
    }

    public float gewicht() {
        return gewicht;
    }

    public Box lieblingsBox() {
        return lieblingsBox;
    }
}
