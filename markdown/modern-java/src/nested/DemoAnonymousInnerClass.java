package nested;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Beispiel: Referenz auf Instanz-Methode (Objekt) */
public class DemoAnonymousInnerClass {
    /** Just to please Checkstyle */
    public static void main(String... args) {
        List<Studi> sl = new ArrayList<Studi>();

        // Liste sortieren?
        sl.sort(
                new Comparator<Studi>() {
                    @Override
                    public int compare(Studi o1, Studi o2) {
                        return o1.getCredits() - o2.getCredits();
                    }
                });
    }
}
