package synchronised;

/** Warten auf andere Threads: Einseitige Synchronisierung */
public class Staffel {
    private boolean inBesitz = false;

    /** Starte die Demo */
    public static void main(String[] args) {
        final Staffel stab = new Staffel();

        new Thread(stab::laufen).start();
        new Thread(stab::laufen).start();
        new Thread(stab::laufen).start();
    }

    /** Versuche den Stab zu nehmen */
    public synchronized void nimm() {
        // Geschützt: hier kommt nur einer gleichzeitig rein
        System.out.println("Stab haben will " + Thread.currentThread().getName());
        while (inBesitz) { // Stab schon bei jemandem in Besitz?
            try {
                System.out.println("Mist, Stab belegt " + Thread.currentThread().getName());
                wait(); // Falls ja: Dann warte "auf" dem Stab
            } catch (InterruptedException exc) {
            }
        }
        inBesitz = true; // Stab war frei; jetzt ist er meins
        System.out.println("Stab hab! " + Thread.currentThread().getName());
    }

    /** Gib den Stab wieder ab */
    public synchronized void abgeben() {
        // Geschützt: hier kommt nur einer gleichzeitig rein
        inBesitz = false; // Stab abgeben
        notifyAll(); // Alle aufwecken: Mir doch egal, wer weiter macht :)
        System.out.println("Stab abgegeben " + Thread.currentThread().getName());
    }

    private void laufen() {
        nimm();
        for (int i = 0; i < 10; i++) {
            System.out.println("laufe ... " + Thread.currentThread().getName());
        }
        abgeben();
    }
}
