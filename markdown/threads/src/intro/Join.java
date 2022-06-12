package intro;

/** Paralleles Programm: Demonstration von interrupt() und join() */
public class Join extends Thread {
    private int val = 0;

    /** Starte die Demo */
    public static void main(String... args) throws InterruptedException {
        Join t = new Join();

        // Threads sind "normale" Objekte
        System.out.println("main(): t.val = " + t.val);
        System.out.println("main(): t.incrVal()");
        t.incrVal();
        System.out.println("main(): t.val = " + t.val);

        // Thread starten
        System.out.println("main(): vor run()");
        t.start();

        // Threads sind "normale" Objekte
        System.out.println("main(): t.val = " + t.val);
        System.out.println("main(): t.incrVal()");
        t.incrVal();
        System.out.println("main(): t.val = " + t.val);

        // Threads lassen sich unterbrechen
        // Betrifft Methoden sleep(), wait() und join()
        // Löst dort eine `InterruptedException` aus
        System.out.println("main(): pieksen von Thread t");
        t.interrupt();

        // Wir (!) warten auf das Ende von Thread t
        // => Effekt zeigen: `t.join();` auskommentieren
        System.out.println("main(): warten auf Ende von Thread t");
        t.join();

        // Wird erst nach dem Ende von Thread t ausgeführt (join)
        System.out.println("main(): nach run()");
        System.out.println("main(): t.val=" + t.val);
    }

    private int incrVal() {
        return val++;
    }

    /**
     * Inhalt des Threads: Wir legen den Thread "schlafen" und können parallel im main() diesen
     * Schlaf durch das t.interrupt() "stören": Der Thread wird dann wieder aufgeweckt und arbeitet
     * weiter.
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(1000); // Statische Methode der Klasse `Thread`
            } catch (InterruptedException e) {
                System.out.println("run(): OUCH! (interrupted)");
            }
            System.out.println(
                    "run(): " + incrVal() + "(" + (System.currentTimeMillis() - startTime) + "ms)");
        }
    }
}
