package lock;

/** Synchronisierung mit synchronized und wait/notify */
public class TraditionalSynchronized {
    private static final Object MONITOR = new Object(); // gemeinsames Monitor-Objekt

    /** Starte die Demo */
    public static void main(String... args) {
        new Thread(TraditionalSynchronized::display).start();
        // DisplayThread sollte vor CalculatorThread starten, sonst bekommt
        // CalculatorThread den Lock auf monitor und DisplayThread wartet
        // bereits im synchronized (und nicht erst im wait) => anschließend
        // geht DisplayThread ins wait und bleibt da für immer (weil keiner
        // mehr notify aufruft ...)
        sleep(10);
        new Thread(TraditionalSynchronized::calculate).start();
    }

    private static void display() {
        synchronized (MONITOR) {
            System.out.println("Display-Thread: warte auf Berechnungsergebnis");

            try {
                // Auf Daten vom Calulator-Thread warten
                // (gibt Lock auf gemeinsamen Monitor-Objekt so lange auf =>
                // Calulator-Thread bekommt Lock auf dem Monitor-Objekt)
                MONITOR.wait();
                System.out.println("Display-Thread: wurde geweckt");
            } catch (InterruptedException ignored) {
            }

            // Daten "darstellen"
            System.out.println("Display-Thread: Ergebnis ist endlich da :-)");
        }
    }

    private static void calculate() {
        synchronized (MONITOR) {
            System.out.println("Calculator-Thread: starte Berechung");

            // lange Berechnung ;-)
            sleep(2000);

            // Display-Thread benachrichtigen
            MONITOR.notify();

            System.out.println("Calculator-Thread: Berechnung beendet");
        }
    }

    private static void sleep(long millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException ignored) {
        }
    }
}
