import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortOwnCrit {
    public static void main(String[] args) {
        List<Studi> list = new ArrayList<Studi>();

        list.add(new Studi("Klaas"));
        list.add(new Studi("Hein"));
        list.add(new Studi("Pit"));

        // Sortieren der Liste (eigene Reihenfolge, prinzipiell unabhaengig zu
        // Studi#compareTo)
        Comparator<Studi> c = new Comparator<Studi>() {
            @Override
            public int compare(Studi o1, Studi o2) {
                return o1.compareTo(o2); // hier Kriterium fuer eigene Ordnung definieren
            }
        };

        list.sort(c);
        Collections.sort(list, c);
    }
}
