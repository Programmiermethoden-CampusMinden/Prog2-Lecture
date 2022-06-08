package intro;

/** Paralleles Programm: Unabhängige Verarbeitung */
public class Threaded extends Thread {
    int val = 0;

    /** Starte die Demo */
    public static void main(String... args) {
        Threaded x = new Threaded();

        System.out.println("main(): vor run()");
        x.start();
        System.out.println("main(): nach run()");
    }

    /** Hilfsmethode zum Inkrementieren der Hilfsvariable */
    public int incrVal() {
        return val++;
    }

    /**
     * Lasst uns eine Schleife ausführen
     *
     * <p>Diese Schleife wird parallel zum main() ausgeführt: Erst erfolgt die Ausgabe in main(),
     * und dann wird ein neuer Kontrollflussfaden ("Thread") gestartet, der parallel zu main() diese
     * Schleife ausführt. Es kann also sein, dass die letzte Ausgabe in main() irgendwo in die
     * Ausgaben dieser Schleife hier dazwischen kommen.
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run(): " + incrVal());
        }
    }
}
