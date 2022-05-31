package methodreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** Code für die Motivation in der Vorlesung */
public class Teaser {
    /** Just to please Checkstyle */
    public static void main(String... args) {
        List<Studi> sl = new ArrayList<Studi>();

        // Anonyme innere Klasse
        Collections.sort(
                sl,
                new Comparator<Studi>() {
                    @Override
                    public int compare(Studi o1, Studi o2) {
                        return Studi.cmpCpsClass(o1, o2);
                    }
                });

        // Lambda-Ausdruck
        Collections.sort(sl, (o1, o2) -> Studi.cmpCpsClass(o1, o2));

        // Methoden-Referenz
        Collections.sort(sl, Studi::cmpCpsClass);
    }
}
