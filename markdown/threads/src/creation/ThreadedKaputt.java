package creation;

import java.util.stream.IntStream;

/** Paralleles Programm: So geht es nicht! */
public class ThreadedKaputt extends Thread {
    private int val = 0;

    /** Starte die Demo */
    public static void main(String[] args) {
        ThreadedKaputt x = new ThreadedKaputt();

        System.out.println("main(): vor run()");
        x.run(); // run() tut's nicht
        // x.start(); // so wird ein Thread gestartet ...
        // x.start(); // 2x start() geht nicht
        System.out.println("main(): nach run()");
    }

    private int incrVal() {
        return val++;
    }

    /**
     * Lasst uns eine Schleife parallel zu main() ausführen
     *
     * <p>Diese Schleife wird parallel zum main() ausgeführt: Erst erfolgt die Ausgabe in main(),
     * und dann wird ein neuer Kontrollflussfaden ("Thread") gestartet, der parallel zu main() diese
     * Schleife ausführt. Es kann also sein, dass die letzte Ausgabe in main() irgendwo in die
     * Ausgaben dieser Schleife hier dazwischen kommen.
     */
    @Override
    public void run() {
        IntStream.range(0, 10).mapToObj(i -> "in run(): " + incrVal()).forEach(System.out::println);
    }
}
