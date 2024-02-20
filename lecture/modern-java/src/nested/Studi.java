package nested;

/** Hilfsklasse: Modellieren wir einen Studi */
public class Studi {
    private final String name;
    private final int credits;

    /**
     * Konstruktor: Baue einen neuen Studi
     *
     * @param name Name des neuen Studis
     * @param credits Credits des neuen Studis
     */
    public Studi(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    /** Wie heisse ich? */
    public String getName() {
        return name;
    }

    /** Wieviele Credits habe ich? */
    public int getCredits() {
        return credits;
    }
}
