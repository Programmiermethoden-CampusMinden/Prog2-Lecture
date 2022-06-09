package synchronised;

import java.util.stream.IntStream;

/** Konkurrierender Zugriff auf gemeinsame Ressource: Synchronisierung über Objekt */
public class ObjSync implements Runnable {
    private final Object waechter = new Object(); // gemeinsames Sperr-Objekt
    private int val = 0;

    /** Starte die Demo */
    public static void main(String... args) {
        ObjSync x = new ObjSync();

        // Zwei Threads auf dem *selben* Runnable => konkurrierender Zugriff auf val
        new Thread(x).start();
        new Thread(x).start();
    }

    private synchronized void incrVal() {
        synchronized (waechter) {
            ++val; // Zugriff auf gemeinsame Ressource
            System.out.println(Thread.currentThread().getId() + ": " + val);
        }
    }

    @Override
    public void run() {
        IntStream.range(0, 5).forEach(i -> incrVal());
    }
}
