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
        System.out.format("foo(): me: %s, other: %s\n", this.name, other.name);
        other.bar(this);
    }

    /** Wird von foo() aufgerufen, führt zum Deadlock */
    public synchronized void bar(Deadlock other) {
        System.out.format("bar(): me: %s, other: %s\n", this.name, other.name);
    }
}
