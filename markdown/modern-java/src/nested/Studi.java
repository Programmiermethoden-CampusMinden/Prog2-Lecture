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

    /**
     * Vergleiche die Credits zweier Studis
     *
     * <p>Als statische Methode ausgeführt für die Nutzung per Methoden-Referenz.
     *
     * @param s1 Erster Studi (als Vergleichsobjekt)
     * @param s2 Zweiter Studi (als Vergleichsobjekt)
     * @return Differenz der Credits der beiden Studis: s1 - s2
     */
    public static int cmpCpsClass(Studi s1, Studi s2) {
        return s1.getCredits() - s2.getCredits();
    }

    /** Wie heisse ich? */
    public String getName() {
        return name;
    }

    /** Wieviele Credits habe ich? */
    public int getCredits() {
        return credits;
    }

    /**
     * Habe ich mehr Credits als der andere Studi?
     *
     * <p>Als Instanz-Methode ausgeführt für die Nutzung per Methoden-Referenz.
     *
     * @param studi Anderer Studi (als Vergleichsobjekt)
     * @return Differenz meiner Credits und der des anderen Studis
     */
    public int cmpCpsInstance(Studi studi) {
        return this.getCredits() - studi.getCredits();
    }

    /**
     * Vergleiche die Credits zweier Studis
     *
     * <p>Als Instanz-Methode ausgeführt für die Nutzung per Methoden-Referenz.
     *
     * @param s1 Erster Studi (als Vergleichsobjekt)
     * @param s2 Zweiter Studi (als Vergleichsobjekt)
     * @return Differenz der Credits der beiden Studis: s1 - s2
     */
    public int cmpCpsInstance(Studi s1, Studi s2) {
        return s1.getCredits() - s2.getCredits();
    }
}
