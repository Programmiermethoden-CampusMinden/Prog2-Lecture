import java.util.ArrayList;
import java.util.List;

public class Studi implements Comparable<Studi> {
    private final String name;

    public Studi(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        List<Studi> list = new ArrayList<Studi>();

        list.add(new Studi("Klaas"));
        list.add(new Studi("Hein"));
        list.add(new Studi("Pit"));

        // Sortieren der Liste (Standard-Reihenfolge)?!
        // Sortieren der Liste (eigene Reihenfolge)?!
    }

    @Override
    public int compareTo(Studi o) {
        return this.name.compareTo(o.name); // hier Kriterium fuer eigene Ordnung definieren
    }
}
