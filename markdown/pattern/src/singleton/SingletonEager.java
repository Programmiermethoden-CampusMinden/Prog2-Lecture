package singleton;

/**
 * Demonstration einer häufig verwendeten Ausprägung des Singleton-Patterns: "Eager Singleton".
 * Die Instanz der Klasse wird direkt beim Laden durch JVM angelegt.
 */
public class SingletonEager {
    private static final SingletonEager inst = new SingletonEager();

    // Privater Constructor: Niemand kann Objekte außerhalb der Klasse anlegen
    private SingletonEager() {}

    public static SingletonEager getInst() {
        return inst;
    }
}
