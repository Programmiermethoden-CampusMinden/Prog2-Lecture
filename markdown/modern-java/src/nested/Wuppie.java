package nested;

@FunctionalInterface
public interface Wuppie<T> {
    int wuppie(T obj);

    boolean equals(Object obj);

    default void fluppie() {
        throw new UnsupportedOperationException();
    }
}
