package nested;

/** Beispiel für ein einfaches funktionales Interface */
@FunctionalInterface
public interface Wuppie<T> {
    /** Abstrakte Methode - _muss_ implementiert werden */
    int wuppie(T obj);

    /** Abstrakte Methode, von java.lang.Object geerbt */
    boolean equals(Object obj);

    /** Default-Methode */
    default void fluppie() {
        throw new UnsupportedOperationException();
    }
}
