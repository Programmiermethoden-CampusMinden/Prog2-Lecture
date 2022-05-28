package methodreferences;

/** Beispiel: Starten von Threads */
public class Wuppie {
    /** Methode für Aufruf per Methoden-Referenz */
    public static void wuppie() {
        System.out.println("wuppie(): wuppie");
    }

    /** Starter -- just to please Checkstyle */
    public static void main(String[] args) {
        // Anonyme innere Klasse
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("t1: wuppie");
            }
        });

        // Lambda-Ausdruck
        Thread t2 = new Thread(() -> System.out.println("t2: wuppie"));

        // Methodenreferenz
        Thread t3 = new Thread(Wuppie::wuppie);

        // Und nun los: Startet ...
        t1.start();
        t2.start();
        t3.start();
    }
}
