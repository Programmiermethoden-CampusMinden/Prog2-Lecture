package nested;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MyCompare implements Comparator<Studi> {
    @Override
    public int compare(Studi o1, Studi o2) {
        return o1.getCredits() - o2.getCredits();
    }
}

/** Nur als Vorlage für die Folien ... */
public class DemoComparator {
    /** Just to please Checkstyle */
    public static void main(String... args) {
        List<Studi> sl = new ArrayList<>();

        // Liste sortieren?
        MyCompare mc = new MyCompare();
        sl.sort(mc);
    }
}
