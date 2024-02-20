package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/** Abarbeiten von Threads über das Executor-Interface */
public class ExecutorDemo implements Runnable {
    private int val = 0;

    /** Starte die Demo */
    public static void main(String... args) {
        ExecutorDemo x = new ExecutorDemo();

        // Neuer Thread-Pool (beachte Javadoc zu Executors#newCachedThreadPool)
        ExecutorService pool = Executors.newCachedThreadPool();

        /*
         * Das Runnable-Objekt wird wiederverwendet und wird auf 2 bis 3 Threads
         * parallel ausgeführt. Dabei können diese sich gegenseitig ablösen!
         * Achten Sie auf die Ausgabe ("pool-1-thread-3") ...
         *
         * Wenn das stört, muss entsprechend synchronisiert werden.
         */
        pool.execute(x); // new Thread(x).start();
        pool.execute(x); // new Thread(x).start();
        pool.execute(x); // new Thread(x).start();

        // Feierabend :)
        pool.shutdown();
    }

    private synchronized void incrVal() {
        ++val; // Zugriff auf gemeinsame Ressource
        System.out.println(Thread.currentThread().getName() + ": " + val);
    }

    @Override
    public void run() {
        IntStream.range(0, 5).forEach(i -> incrVal());
    }
}
