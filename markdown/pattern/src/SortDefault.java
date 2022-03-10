import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDefault {
    public static void main(String[] args) {
        List<Studi> list = new ArrayList<Studi>();

        list.add(new Studi("Klaas"));
        list.add(new Studi("Hein"));
        list.add(new Studi("Pit"));

        // Sortieren der Liste (Standard-Reihenfolge, definiert in Studi#compareTo)
        Collections.sort(list);
    }
}
