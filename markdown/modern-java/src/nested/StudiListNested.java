package nested;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/** Eine iterierbare Studi-Liste mit inneren Klassen */
public class StudiListNested implements Iterable<Studi> {
    private final List<Studi> list = new ArrayList<>();

    /** Starte eine kleine Demo der Iterator-Funktionalität */
    public static void main(String[] args) {
        StudiListNested si = new StudiListNested();
        si.add(new Studi("Klaas", 2));
        si.add(new Studi("Hein", 10));
        si.add(new Studi("Pit", 42));

        // Hier benutzen wir unseren eigenen Iterator!
        for (Studi s : si) {
            System.out.println(s);
        }
    }

    /**
     * Hilfsmethode, um der Liste einen neuen Studi hinzuzufügen
     *
     * @param s Studi, der an die Liste angehängt wird
     */
    public void add(Studi s) {
        list.add(s);
    }

    /** Erzeuge einen Iterator, mit dem wir unsere Liste traversieren können */
    @Override
    public Iterator<Studi> iterator() {
        // Nutzung der inneren Klasse zur Iteration
        return new StudiIterator();
    }

    /**
     * Innere Klasse: Zugriff auf privates Feld <code>List<Studi> list</code> von StudiListNested
     */
    private class StudiIterator implements Iterator<Studi> {
        private int cursor = 0;

        /** Iterator-Hilfsmethode: Gibt es noch ein weiteres Element? */
        @Override
        public boolean hasNext() {
            return cursor < list.size();
        }

        /** Iterator-Hilfsmethode: Gebe das aktuelle Element zurück. */
        @Override
        public Studi next() {
            try {
                return list.get(cursor++);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        /** Iterator-Hilfsmethode: Lösche das aktuelle Element (nicht implementiert). */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
