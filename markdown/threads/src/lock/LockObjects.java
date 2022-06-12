package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** Synchronisierung mit Lock-Objekten und Condition-Objekten */
public class LockObjects {
    private static final Lock LOCK = new ReentrantLock(); // gemeinsames Monitor-Objekt
    private static final Condition CONDITION = LOCK.newCondition();

    /** Starte die Demo */
    public static void main(String... args) {
        new Thread(LockObjects::display).start();
        // DisplayThread muss nicht unbedingt vor CalculatorThread starten
        // (kein Deadlock mehr durch Timeout im `await` => Starts vertauschen)
        new Thread(LockObjects::calculate).start();
    }

    private static void display() {
        LOCK.lock(); // übernimmt die Rolle von synchronized (monitor) { ... }

        System.out.println("Display-Thread: warte auf Berechnungsergebnis");

        try {
            // Auf Daten vom Calulator-Thread warten
            // übernimmt die Rolle von wait()
            // Vorteil Lock-Objekt/Condition: Timeout möglich!
            // (false: Zeit vor Benachrichtigung abgelaufen => Zeit variieren)
            if (CONDITION.await(4000, TimeUnit.MILLISECONDS)) {
                System.out.println("Display-Thread: wurde geweckt");
            } else {
                // Wartezeit abgelaufen, keine Daten
                System.out.println("Display-Thread: zu lange gewartet, kein Ergebnis :(");
            }
        } catch (InterruptedException ignored) {
        } finally {
            LOCK.unlock(); // Nachteil Lock-Objekt: Selbst um Un-Locking kümmern
        }

        // Daten "darstellen"
        System.out.println("Display-Thread: Ergebnis ist endlich da :-)");
    }

    private static void calculate() {
        LOCK.lock(); // übernimmt die Rolle von synchronized (monitor) { ... }

        System.out.println("Calculator-Thread: starte Berechung");

        // lange Berechnung ;-)
        sleep(2000);

        // Display-Thread benachrichtigen
        CONDITION.signal(); // übernimmt die Rolle von notify()

        System.out.println("Calculator-Thread: Berechnung beendet");

        LOCK.unlock(); // Nachteil Lock-Objekt: Selbst um Un-Locking kümmern
    }

    private static void sleep(long millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException ignored) {
        }
    }
}
