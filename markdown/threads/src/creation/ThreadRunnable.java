package creation;

import java.util.stream.IntStream;

/** Paralleles Programm: Implementierung über das Interface Runnable */
public class ThreadRunnable implements Runnable {
    private int val = 0;

    /** Starte die Demo */
    public static void main(String... args) {
        ThreadRunnable x = new ThreadRunnable();

        System.out.println("main(): vor run()");
        Thread t = new Thread(x); // Runnable "in" neuen Threads stecken
        t.start();
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
