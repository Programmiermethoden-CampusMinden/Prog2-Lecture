package forkjoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Demo für das Fork-Join-Framework
 *
 * <p>Task muss von RecursiveTask<V> ableiten
 */
public class ForkJoin extends RecursiveTask<Integer> {
    // Langes Array mit Wörtern, wird von allen Tasks gemeinsam genutzt
    private static final String[] WORDS = {
        "hello", "world", "wuppie", "fluppie", "foo", "bar", "42"
    };

    // Individuelle Start- und Ende-Marker
    private final int start;
    private final int end;

    /**
     * Lege neuen Task an
     *
     * @param start Startindex für die zu bearbeitende Teilliste
     * @param end Endindex für die zu bearbeitende Teilliste
     */
    public ForkJoin(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /** Starte die Demo */
    public static void main(String[] args) {
        // neuen Task erzeugen
        ForkJoinTask<Integer> task = new ForkJoin(0, WORDS.length);

        // Aufgabe an ForkJoinPool geben und Bearbeitung starten
        int erg = new ForkJoinPool().invoke(task);
        System.out.println(erg);

        // Direkte Berechnung (sequentiell, zur Kontrolle)
        System.out.println(
                Arrays.stream(WORDS, 0, WORDS.length)
                        .map(String::length)
                        .reduce(0, (a, b) -> a + b));
    }

    // Diese Methode wird vom ForkJoinPool aufgerufen
    @Override
    protected Integer compute() {
        int length = end - start;

        // Sequentielle Berechnung, wenn weniger als 2 Elemente
        // Anzahl hier willkürlich!
        if (length < 2) {
            return Arrays.stream(WORDS, start, end).map(String::length).reduce(0, (a, b) -> a + b);
        }

        // Teile Task in zwei Hälften
        ForkJoin left = new ForkJoin(start, start + length / 2);
        ForkJoin right = new ForkJoin(start + length / 2, end);

        // "Linken" Task parallelisieren => ForkJoinPool führt compute() in anderem Thread aus
        left.fork();

        // Direkter rekursiver Aufruf für "rechten" Tasks (Weiterverwendung vom aktuellen Thread)
        int rightErg = right.compute();

        // Wenn "rechter" Task fertig, auf Ergbnisse vom "linken" Task warten
        int leftErg = left.join();

        // Ergebnisse zusammenführen und fertig
        return leftErg + rightErg;
    }
}
