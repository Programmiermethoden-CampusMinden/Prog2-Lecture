package synchronised;

import java.util.stream.IntStream;

/** Konkurrierender Zugriff auf gemeinsame Ressource (KAPUTTE Variante) */
public class Teaser implements Runnable {
    private int val = 0;

    /** Starte die Demo */
    public static void main(String... args) {
        Teaser x = new Teaser();

        // Zwei Threads auf dem *selben* Runnable => konkurrierender Zugriff auf val
        new Thread(x).start();
        new Thread(x).start();
    }

    private void incrVal() {
        ++val; // Zugriff auf gemeinsame Ressource
        System.out.println(Thread.currentThread().getId() + ": " + val);
    }

    @Override
    public void run() {
        IntStream.range(0, 5).forEach(i -> incrVal());
    }
}
