package singleton;

/**
 * Demonstration einer häufig verwendeten Ausprägung des Singleton-Patterns: "Lazy Singleton".
 * Die Instanz der Klasse wird erst bei Bedarf erzeugt.
 */
public class SingletonLazy {
    private static SingletonLazy inst = null;

    // Privater Constructor: Niemand kann Objekte außerhalb der Klasse anlegen
    private SingletonLazy() {}

    public static SingletonLazy getInst() {
        synchronized (SingletonLazy.class) {  // Thread-safe. Kann weggelassen werden bei Single-Threaded-Gebrauch
            if (inst == null) {
                inst = new SingletonLazy();
            }
        }
        return inst;
    }
}
