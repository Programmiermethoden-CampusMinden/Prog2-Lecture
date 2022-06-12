package synchronised;

/** Konkurrierender Zugriff auf gemeinsame Ressource: Synchronisierung über Methode */
public class Deadlock {
    private final String name;

    /** Initialisiere neues Objekt */
    public Deadlock(String name) {
        this.name = name;
    }

    /** Starte die Demo */
    public static void main(String... args) {
        final Deadlock a = new Deadlock("a");
        final Deadlock b = new Deadlock("b");

        new Thread(() -> a.foo(b)).start();
        new Thread(() -> b.foo(a)).start();
    }

    /** Einstieg: Wird von beiden Threads aufgerufen */
    public synchronized void foo(Deadlock other) {
        System.out.format("%s: %s.foo() \n", Thread.currentThread().getName(), name);
        System.out.format("%s: %s.name()\n", Thread.currentThread().getName(), other.getName());
    }

    /** Wird von foo() aufgerufen, führt zum Deadlock */
    public synchronized String getName() {
        return name;
    }
}
