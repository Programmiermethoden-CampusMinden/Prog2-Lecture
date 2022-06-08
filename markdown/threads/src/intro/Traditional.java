package intro;

/** Traditionelles Programm: Sequentielle Verarbeitung */
public class Traditional {
    int val = 0;

    /** Starte die Demo */
    public static void main(String... args) {
        Traditional x = new Traditional();

        System.out.println("main(): vor run()");
        x.run();
        System.out.println("main(): nach run()");
    }

    /** Hilfsmethode zum Inkrementieren der Hilfsvariable */
    public int incrVal() {
        return val++;
    }

    /**
     * Lasst uns eine Schleife ausführen
     *
     * <p>Diese Schleife wird sequentiell ausgeführt: Erst die Ausgabe in main(), dann geht der
     * Kontrollfluss hier in die Methode und die Schleife wird ausgeführt, und danach geht der
     * Kontrollfluss wieder zurück nach main() und die letzte Ausgabe dort wird gemacht.
     */
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run(): " + incrVal());
        }
    }
}
